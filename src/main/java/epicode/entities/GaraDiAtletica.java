package epicode.entities;

import javax.persistence.Entity;

@Entity

public class GaraDiAtletica extends Event {

    private Person setAtleti;
    private Person vincitore;

    public  GaraDiAtletica (){
    }

    public GaraDiAtletica (Person setAtleti, Person vincitore) {
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public Person getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Person setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }
}
