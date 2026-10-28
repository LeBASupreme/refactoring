package fr.efrei.transfret;

public class EstimateurDelai {

    private static final double VITESSE_ROUTE_KM_H = 70.0;
    private static final double HEURES_CONDUITE_URGENTE = 18;
    private static final double HEURES_CONDUITE = 9;
    private static final double DISTANCE_JOURNALIERE_RAIL = 1440.0;
    private static final int JOURS_SUPPLEMENTAIRES_RAIL = 1;
    private static final double DISTANCE_JOURNALIERE_MER = 720.0;
    private static final int JOURS_SUPPLEMENTAIRES_MER = 2;
    private static final int DELAI_AIR_COURT = 1;
    private static final int SEUIL_DISTANCE_AIR = 3000;
    private static final int DELAI_AIR_LONG = 2;
    private static final int DELAI_MINIMUM = 1;

    public int calculerDelai(int distance, ModeTransport mode, boolean urgent) {
        int jours = 0;
        switch (mode) {
            case ROUTE:
                double heures = distance / VITESSE_ROUTE_KM_H;
                if (urgent) {
                    jours = (int) Math.ceil(heures / HEURES_CONDUITE_URGENTE);
                } else {
                    jours = (int) Math.ceil(heures / HEURES_CONDUITE);
                }
                break;
            case RAIL:
                jours = (int) Math.ceil(distance / DISTANCE_JOURNALIERE_RAIL) + JOURS_SUPPLEMENTAIRES_RAIL;
                if (urgent) jours = jours - 1;
                break;
            case MER:
                jours = (int) Math.ceil(distance / DISTANCE_JOURNALIERE_MER) + JOURS_SUPPLEMENTAIRES_MER;
                break;
            case AIR:
                jours = DELAI_MINIMUM;
                if (distance > SEUIL_DISTANCE_AIR) jours = DELAI_AIR_LONG;
                if (urgent) jours = DELAI_AIR_COURT;
                break;
        }
        if (jours < DELAI_MINIMUM) jours = DELAI_MINIMUM;
        return jours;
    }
}
