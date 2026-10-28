package fr.efrei.transfret;

public class EstimateurDelai {

    private static final int DELAI_MINIMUM = 1;

    public int calculerDelai(int distance, ModeTransport mode, boolean urgent) {
        int jours = mode.delai().calculer(distance, urgent);
        if (jours < DELAI_MINIMUM) {
            jours = DELAI_MINIMUM;
        }
        return jours;
    }
}
