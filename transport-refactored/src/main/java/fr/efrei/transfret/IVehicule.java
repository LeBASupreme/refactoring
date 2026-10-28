package fr.efrei.transfret;

/**
 * Interface commune à tous les véhicules de la flotte.
 */
public interface IVehicule {

    String getImmatriculation();

    double getCapaciteMax();

    double getChargeActuelle();

    boolean estDisponible();

    void setDisponible(boolean disponible);

    void charger(Colis colis);

    void decharger(Colis colis);

    boolean peutTransporterMatieresDangereuses();

    void faireLePlein();

    void partir(int distance);
}
