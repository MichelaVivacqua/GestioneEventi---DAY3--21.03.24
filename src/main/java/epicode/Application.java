package epicode;

import com.github.javafaker.Faker;
import epicode.dao.AttendancesDAO;
import epicode.dao.EventsDAO;
import epicode.dao.LocationsDAO;
import epicode.dao.PeopleDAO;
import epicode.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PeopleDAO peopleDAO = new PeopleDAO(em);
        AttendancesDAO attendancesDAO = new AttendancesDAO(em);
        Random rndm = new Random();

        // ******************** SALVATAGGIO LOCATIONS, UTENTI E EVENTI ************************

        Location location1 = new Location(faker.address().city(), faker.address().cityName());
         locationsDAO.save(location1);

        Location location2 = new Location(faker.address().city(), faker.address().cityName());
         locationsDAO.save(location2);

        Person person1 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
         peopleDAO.save(person1);

        for (int i = 0; i < 20; i++) {
            eventsDAO.save(new Event(
                    faker.chuckNorris().fact(),
                    LocalDate.of(rndm.nextInt(2023, 2025),
                            rndm.nextInt(1, 13),
                            rndm.nextInt(1, 29)),
                    faker.lorem().fixedString(50),
                    rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
                    rndm.nextInt(1, 1000),rndm.nextInt(0, 2) == 0 ? location1: location2));
        }

        // ******************** PARTECIPAZIONE AD UN EVENTO ************************

        Person person = peopleDAO.findById(28);

        Event event = eventsDAO.findById(29);

        Attendance partecipazione = new Attendance(person, event);
         attendancesDAO.save(partecipazione);

        // Stampo eventi a cui partecipa la persona 23
        person.getListaPartecipazioni().forEach(System.out::println);

        // Stampo elenco partecipanti evento 24
        event.getListaPartecipazioni().forEach(System.out::println);

        // ******************** CASCADING ************************

        // Eliminando un evento dovrebbe eliminare anche le partecipazioni ad esso collegate
        eventsDAO.findByIdAndDelete(24);

        List<Concerto> concertiInStreaming = eventsDAO.getConcertiInStreaming(true);
        System.out.println("Concerti in streaming: " + concertiInStreaming);

        List<Concerto> concertiPerGenere = eventsDAO.getConcertiPerGenere(TipoConcerto.ROCK);
        System.out.println("Concerti per genere: " + concertiPerGenere);

        PartitaDiCalcio partita1 = new PartitaDiCalcio("Juve_Roma", LocalDate.now(), "Descrizione della partita", TipoEvento.PRIVATO, 100, location1, "Juve", "Roma", "Squadra Vincente", 2, 1);

        PartitaDiCalcio partita2 = new PartitaDiCalcio("Juve_Inter", LocalDate.now(), "Descrizione della partita", TipoEvento.PRIVATO, 100, location1, "Juve", "Inter", "Squadra Vincente", 2, 1);



        eventsDAO.save(partita1);
        eventsDAO.save(partita2);

        em.close();
        emf.close();
   }
}
