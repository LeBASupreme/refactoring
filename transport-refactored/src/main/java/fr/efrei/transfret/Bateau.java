package fr.efrei.transfret;

import java.util.List;

public class Bateau extends Vehicule implements Navigant {

    private static final double KM_PAR_MILLE_NAUTIQUE = 1.852;

    public Bateau(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void naviguer(int milesNautiques) {
        System.out.println("Le navire " + immatriculation + " navigue sur " + milesNautiques + " milles nautiques");
    }

    @Override
    public void partir(int distance) {
        naviguer((int) (distance / KM_PAR_MILLE_NAUTIQUE));
    }

    public boolean peutTransporterMatieresDangereuses() {
        return true;
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.MER && !contient(colis, TypeMarchandise.REFRIGERE);
    }
}
