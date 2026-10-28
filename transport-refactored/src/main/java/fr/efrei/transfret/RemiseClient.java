package fr.efrei.transfret;

public class RemiseClient extends SupplementPrix {

    public RemiseClient(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(Expedition expedition) {
        double prix = calculerComposant(expedition);
        return expedition.getClient().getType().remise().appliquer(prix);
    }
}
