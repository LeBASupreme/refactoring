package fr.efrei.transfret;

import java.util.List;

public class Avion extends Vehicule implements Roulant, Volant {

    private static final int ROULAGE_PISTE_KM = 2;
    private static final int ALTITUDE_CROISIERE = 35000;

    public Avion(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void rouler(int km) {
        // roulage sur la piste
        System.out.println("L'avion " + immatriculation + " roule sur la piste");
    }

    @Override
    public void voler(int altitude) {
        System.out.println("L'avion " + immatriculation + " vole à " + altitude + " pieds");
    }

    @Override
    public void partir(int distance) {
        rouler(ROULAGE_PISTE_KM);
        voler(ALTITUDE_CROISIERE);
    }

    public boolean peutTransporterMatieresDangereuses() {
        return false;
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.AIR;
    }
}
