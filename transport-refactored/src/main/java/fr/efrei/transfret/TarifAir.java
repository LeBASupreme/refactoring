package fr.efrei.transfret;

public class TarifAir implements TarifTransport {

    private static final double DIVISEUR_VOLUMETRIQUE = 167;
    private static final double TARIF_PAR_KM = 0.6;
    private static final double TARIF_PAR_KG = 4.5;

    @Override
    public double prixDeBase(double poids, double volume, int distance) {
        double poidsTaxable = poids;
        if (volume * DIVISEUR_VOLUMETRIQUE > poids) {
            poidsTaxable = volume * DIVISEUR_VOLUMETRIQUE;
        }
        return distance * TARIF_PAR_KM + poidsTaxable * TARIF_PAR_KG;
    }
}
