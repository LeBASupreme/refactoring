package fr.efrei.transfret;

public class Assurance extends SupplementPrix {

    private static final double TAUX = 0.02;
    private static final double MINIMUM = 15;

    public Assurance(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        double prix = calculerComposant(expedition);
        double montant = valeurDeclaree(expedition) * TAUX;
        if (montant < MINIMUM) {
            montant = MINIMUM;
        }
        return prix + montant;
    }

    private double valeurDeclaree(Expedition expedition) {
        double valeur = 0;
        for (Colis colis : expedition.getColis()) {
            valeur = valeur + colis.getValeurDeclaree();
        }
        return valeur;
    }
}
