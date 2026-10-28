package fr.efrei.transfret;

public class DelaiMer implements DelaiTransport {

    private static final double DISTANCE_JOURNALIERE = 720.0;
    private static final int JOURS_SUPPLEMENTAIRES = 2;

    @Override
    public int calculer(int distance, boolean urgent) {
        return (int) Math.ceil(distance / DISTANCE_JOURNALIERE) + JOURS_SUPPLEMENTAIRES;
    }
}
