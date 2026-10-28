package fr.efrei.transfret;

public class SupplementRefrigere extends SupplementPrix {

    private static final double COEFFICIENT = 1.20;

    public SupplementRefrigere(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        return calculerComposant(expedition) * COEFFICIENT;
    }
}
