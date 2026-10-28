package fr.efrei.transfret;

public class SupplementFragile extends SupplementPrix {

    private static final double COEFFICIENT = 1.15;

    public SupplementFragile(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        return calculerComposant(expedition) * COEFFICIENT;
    }
}
