package fr.efrei.transfret;

public abstract class SupplementPrix implements ComposantPrix {

    private final ComposantPrix composant;

    protected SupplementPrix(ComposantPrix composant) {
        this.composant = composant;
    }

    protected double calculerComposant(Expedition expedition) {
        return composant.calculer(expedition);
    }
}
