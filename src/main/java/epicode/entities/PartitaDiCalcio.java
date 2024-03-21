package epicode.entities;

import javax.persistence.Entity;

@Entity

public class PartitaDiCalcio extends Event {

    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente; //null se pareggio
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public  PartitaDiCalcio (){
    }

    public PartitaDiCalcio (String squadraDiCasa,String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite){
        this.squadraDiCasa=squadraDiCasa;
        this.squadraOspite=squadraOspite;
        this.squadraVincente=squadraVincente;
        this.numeroGolSquadraDiCasa=numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite=numeroGolSquadraOspite;
    }

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