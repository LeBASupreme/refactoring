package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategiesDelaiTest {

    @Test
    void la_route_compte_les_journees_de_conduite() {
        DelaiRoute delai = new DelaiRoute();
        assertEquals(2, delai.calculer(700, false));
        assertEquals(1, delai.calculer(700, true));
    }

    @Test
    void le_rail_gagne_un_jour_en_urgence() {
        DelaiRail delai = new DelaiRail();
        assertEquals(2, delai.calculer(1440, false));
        assertEquals(1, delai.calculer(1440, true));
    }

    @Test
    void la_mer_ignore_l_urgence() {
        DelaiMer delai = new DelaiMer();
        assertEquals(3, delai.calculer(720, false));
        assertEquals(3, delai.calculer(720, true));
    }

    @Test
    void l_air_passe_a_deux_jours_au_dela_de_3000_km_sauf_urgence() {
        DelaiAir delai = new DelaiAir();
        assertEquals(1, delai.calculer(3000, false));
        assertEquals(2, delai.calculer(3001, false));
        assertEquals(1, delai.calculer(3001, true));
    }

    @Test
    void le_delai_ne_descend_pas_sous_un_jour() {
        assertEquals(1, new EstimateurDelai().calculerDelai(0, ModeTransport.RAIL, true));
    }
}
