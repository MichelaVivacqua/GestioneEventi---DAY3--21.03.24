package epicode.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("GARA_ATLETICA")
public class GaraDiAtletica extends Event {
    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    private List<Person> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Person vincitore;

    public  GaraDiAtletica(){}
    public  GaraDiAtletica (List<Person> atleti, Person vincitore){
        this.atleti=atleti;
        this.vincitore=vincitore;
    }

    public List<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Person> atleti) {
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }
}