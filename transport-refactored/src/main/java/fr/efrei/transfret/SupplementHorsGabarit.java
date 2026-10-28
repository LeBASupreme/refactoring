package fr.efrei.transfret;

public class SupplementHorsGabarit extends SupplementPrix {

    private static final double COEFFICIENT = 1.10;

    public SupplementHorsGabarit(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        return calculerComposant(expedition) * COEFFICIENT;
    }
}
