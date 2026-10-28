package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategiesPrixTest {

    private static final double CENTIME = 0.001;

    @Test
    void la_route_facture_le_kilometre_et_le_kilo() {
        assertEquals(13, new TarifRoute().prixDeBase(10, 0, 10), CENTIME);
    }

    @Test
    void le_rail_ne_descend_pas_sous_150() {
        assertEquals(150, new TarifRail().prixDeBase(1, 0, 1), CENTIME);
    }

    @Test
    void la_mer_ne_descend_pas_sous_500() {
        assertEquals(500, new TarifMer().prixDeBase(1, 0, 1), CENTIME);
    }

    @Test
    void l_air_prend_le_poids_volumetrique_quand_il_depasse_le_poids_reel() {
        assertEquals(757.5, new TarifAir().prixDeBase(1, 1, 10), CENTIME);
    }

    @Test
    void l_entreprise_a_10_pourcent_sous_5000_et_15_au_dessus() {
        RemiseEntreprise remise = new RemiseEntreprise();
        assertEquals(900, remise.appliquer(1000), CENTIME);
        assertEquals(5100, remise.appliquer(6000), CENTIME);
    }

    @Test
    void le_premium_a_20_pourcent() {
        assertEquals(80, new RemisePremium().appliquer(100), CENTIME);
    }

    @Test
    void le_particulier_ne_change_pas_le_prix() {
        assertEquals(100, new RemiseParticulier().appliquer(100), CENTIME);
    }
}
