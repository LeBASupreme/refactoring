package fr.efrei.transfret;

public class DelaiRail implements DelaiTransport {

    private static final double DISTANCE_JOURNALIERE = 1440.0;
    private static final int JOURS_SUPPLEMENTAIRES = 1;

    @Override
    public int calculer(int distance, boolean urgent) {
        int jours = (int) Math.ceil(distance / DISTANCE_JOURNALIERE) + JOURS_SUPPLEMENTAIRES;
        if (urgent) {
            jours = jours - 1;
        }
        return jours;
    }
}
