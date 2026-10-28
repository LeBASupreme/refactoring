package fr.efrei.transfret;

import java.util.List;

public class BateauFrigorifique extends Bateau implements Refrigerant {

    public BateauFrigorifique(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void activerRefrigeration(double temperature) {
        System.out.println("Conteneurs frigorifiques réglés à " + temperature + "°C");
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.MER;
    }
}
