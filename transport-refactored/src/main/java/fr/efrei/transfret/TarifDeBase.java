package fr.efrei.transfret;

public class TarifDeBase implements ComposantPrix {

    @Override
    public double calculer(Expedition expedition) {
        double poids = 0;
        double volume = 0;
        for (Colis colis : expedition.getColis()) {
            poids = poids + colis.getPoids();
            volume = volume + colis.getVolume();
        }
        return expedition.getMode().tarif().prixDeBase(poids, volume, expedition.getDistance());
    }
}
