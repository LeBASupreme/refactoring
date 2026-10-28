package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifDeBaseTest {

    private static final double CENTIME = 0.001;

    @Test
    void la_route_a_le_meme_prix_de_base_que_son_tarif() {
        Expedition expedition = new Expedition();
        expedition.setMode(ModeTransport.ROUTE);
        expedition.setDistance(10);
        expedition.getColis().add(new Colis("colis", 10, 0, 0, 0, TypeMarchandise.STANDARD, 0));

        double prix = new TarifDeBase().calculer(expedition);

        assertEquals(13, prix, CENTIME);
        assertEquals(new TarifRoute().prixDeBase(10, 0, 10), prix, CENTIME);
    }
}
