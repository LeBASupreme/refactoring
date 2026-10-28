package fr.efrei.transfret;

public class TarifFluvial implements TarifTransport {

    private static final double TARIF_PAR_KM = 0.40;
    private static final double TARIF_PAR_KG = 0.02;
    private static final double MINIMUM = 300;

    @Override
    public double prixDeBase(double poids, double volume, int distance) {
        double prix = distance * TARIF_PAR_KM + poids * TARIF_PAR_KG;
        if (prix < MINIMUM) {
            prix = MINIMUM;
        }
        return prix;
    }
}
