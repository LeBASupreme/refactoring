package fr.efrei.transfret;

public class SupplementDangereux extends SupplementPrix {

    private static final double COEFFICIENT = 1.30;

    public SupplementDangereux(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        return calculerComposant(expedition) * COEFFICIENT;
    }
}
