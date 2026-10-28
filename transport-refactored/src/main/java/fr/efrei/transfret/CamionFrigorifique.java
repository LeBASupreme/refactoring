package fr.efrei.transfret;

import java.util.List;

public class CamionFrigorifique extends Camion implements Refrigerant {

    public CamionFrigorifique(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, false);
    }

    @Override
    public void activerRefrigeration(double temperature) {
        System.out.println("Réfrigération activée à " + temperature + "°C sur " + immatriculation);
    }

    @Override
    protected boolean accepte(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.ROUTE && contient(colis, TypeMarchandise.REFRIGERE);
    }
}
