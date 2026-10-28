package fr.efrei.transfret;

import java.util.List;

public class AffectationVehicule {

    private final List<Vehicule> vehicules;

    public AffectationVehicule(Flotte flotte) {
        this.vehicules = flotte.vehicules();
    }

    // retourne le premier véhicule disponible et compatible, null si aucun
    public Vehicule trouverVehicule(List<Colis> colis, ModeTransport mode) {
        for (Vehicule v : vehicules) {
            if (v.peutPrendreEnCharge(colis, mode)) {
                return v;
            }
        }
        return null;
    }
}
