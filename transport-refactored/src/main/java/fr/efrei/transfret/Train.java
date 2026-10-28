package fr.efrei.transfret;

import java.util.List;

public class Train extends Vehicule implements Roulant {

    public Train(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void rouler(int km) {
        System.out.println("Le train " + immatriculation + " circule sur " + km + " km de voies ferrées");
    }

    @Override
    public void partir(int distance) {
        rouler(distance);
    }

    public boolean peutTransporterMatieresDangereuses() {
        return true;
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.RAIL;
    }

    @Override
    public void faireLePlein() {
        // Un train électrique ne consomme pas de carburant.
    }
}
