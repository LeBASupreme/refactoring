package fr.efrei.transfret;

public class DelaiRoute implements DelaiTransport {

    private static final double VITESSE_KM_H = 70.0;
    private static final double HEURES_CONDUITE_URGENTE = 18;
    private static final double HEURES_CONDUITE = 9;

    @Override
    public int calculer(int distance, boolean urgent) {
        double heures = distance / VITESSE_KM_H;
        if (urgent) {
            return (int) Math.ceil(heures / HEURES_CONDUITE_URGENTE);
        }
        return (int) Math.ceil(heures / HEURES_CONDUITE);
    }
}
