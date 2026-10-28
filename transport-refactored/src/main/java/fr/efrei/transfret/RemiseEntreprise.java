package fr.efrei.transfret;

public class RemiseEntreprise implements PolitiqueRemise {

    private static final double SEUIL = 5000;
    private static final double COEFFICIENT_AU_DESSUS_DU_SEUIL = 0.85;
    private static final double COEFFICIENT = 0.90;

    @Override
    public double appliquer(double prix) {
        if (prix > SEUIL) {
            return prix * COEFFICIENT_AU_DESSUS_DU_SEUIL;
        }
        return prix * COEFFICIENT;
    }
}
