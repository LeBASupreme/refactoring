package fr.efrei.transfret;

public class SupplementUrgence extends SupplementPrix {

    private static final double COEFFICIENT = 1.5;

    public SupplementUrgence(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        return calculerComposant(expedition) * COEFFICIENT;
    }
}
