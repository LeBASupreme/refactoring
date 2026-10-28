package fr.efrei.transfret;

import java.util.List;

public class Camion extends Vehicule implements Roulant {

    protected boolean adr; // certification matières dangereuses

    public Camion(String immatriculation, double capaciteMax, boolean adr) {
        super(immatriculation, capaciteMax);
        this.adr = adr;
    }

    @Override
    public void rouler(int km) {
        System.out.println("Le camion " + immatriculation + " roule sur " + km + " km");
    }

    @Override
    public void partir(int distance) {
        rouler(distance);
    }

    public boolean peutTransporterMatieresDangereuses() {
        return adr;
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        if (mode != ModeTransport.ROUTE) {
            return false;
        }
        if (contient(colis, TypeMarchandise.REFRIGERE)) {
            return false;
        }
        if (contient(colis, TypeMarchandise.DANGEREUX)) {
            return adr;
        }
        return true;
    }
}
