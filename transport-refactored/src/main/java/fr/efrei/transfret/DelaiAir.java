package fr.efrei.transfret;

public class DelaiAir implements DelaiTransport {

    private static final int DELAI_COURT = 1;
    private static final int SEUIL_DISTANCE = 3000;
    private static final int DELAI_LONG = 2;

    @Override
    public int calculer(int distance, boolean urgent) {
        int jours = DELAI_COURT;
        if (distance > SEUIL_DISTANCE) {
            jours = DELAI_LONG;
        }
        if (urgent) {
            jours = DELAI_COURT;
        }
        return jours;
    }
}
