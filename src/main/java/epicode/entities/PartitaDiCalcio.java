package epicode.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.time.LocalDate;


@Entity
@NamedQuery(
        name = "PartitaDiCalcio.getPartiteVinteInCasa",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = :squadraCasa"
)
@NamedQuery(
        name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente <> :squadraCasa AND (p.squadraDiCasa = :squadraCasa OR p.squadraOspite = :squadraCasa)"
)

public class PartitaDiCalcio extends Event {

    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente; //null se pareggio
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public  PartitaDiCalcio (){
    }


    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        setTitolo(titolo);
        setDataEvento(dataEvento);
        setDescrizione(descrizione);
        setTipoEvento(tipoEvento);
        setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
        setLuogoEvento(location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;}

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}