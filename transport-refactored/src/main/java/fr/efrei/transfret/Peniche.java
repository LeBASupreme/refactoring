package fr.efrei.transfret;

import java.util.List;

public class Peniche extends Vehicule implements Navigant {

    private static final double KM_PAR_MILLE_NAUTIQUE = 1.852;

    public Peniche(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void naviguer(int milesNautiques) {
        System.out.println("La péniche " + immatriculation + " navigue sur " + milesNautiques + " milles nautiques");
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
        return mode == ModeTransport.FLUVIAL && !contient(colis, TypeMarchandise.REFRIGERE);
    }
}
