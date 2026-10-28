package fr.efrei.transfret;

public class TarifRoute implements TarifTransport {

    private static final double TARIF_PAR_KM = 1.2;
    private static final double TARIF_PAR_KG = 0.10;

    @Override
    public double prixDeBase(double poids, double volume, int distance) {
        return distance * TARIF_PAR_KM + poids * TARIF_PAR_KG;
    }
}
