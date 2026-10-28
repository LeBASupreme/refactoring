package fr.efrei.transfret;

public class TarifMer implements TarifTransport {

    private static final double TARIF_PAR_KM = 0.5;
    private static final double TARIF_PAR_KG = 0.03;
    private static final double MINIMUM = 500;

    @Override
    public double prixDeBase(double poids, double volume, int distance) {
        double prix = distance * TARIF_PAR_KM + poids * TARIF_PAR_KG;
        if (prix < MINIMUM) {
            prix = MINIMUM;
        }
        return prix;
    }
}
