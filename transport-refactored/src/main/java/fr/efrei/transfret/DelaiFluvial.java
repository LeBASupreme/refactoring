package fr.efrei.transfret;

public class DelaiFluvial implements DelaiTransport {

    private static final double DISTANCE_JOURNALIERE = 360.0;
    private static final int JOURS_SUPPLEMENTAIRES = 1;

    @Override
    public int calculer(int distance, boolean urgent) {
        return (int) Math.ceil(distance / DISTANCE_JOURNALIERE) + JOURS_SUPPLEMENTAIRES;
    }
}
