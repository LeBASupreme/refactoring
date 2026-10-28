package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExtensionsTest {

    private static final double CENTIME = 0.001;

    @Test
    void le_fluvial_facture_au_minimum_300() {
        assertEquals(300, new TarifFluvial().prixDeBase(10, 0, 10), CENTIME);
    }

    @Test
    void le_fluvial_facture_le_kilometre_et_le_kilo_au_dessus_du_minimum() {
        assertEquals(420, new TarifFluvial().prixDeBase(1000, 0, 1000), CENTIME);
    }

    @Test
    void le_delai_fluvial_arrondit_la_distance_au_dessus_puis_ajoute_un_jour() {
        DelaiFluvial delai = new DelaiFluvial();
        assertEquals(3, delai.calculer(365, false));
        assertEquals(3, delai.calculer(365, true));
        assertEquals(3, delai.calculer(720, false));
    }

    @Test
    void la_peniche_prend_le_fluvial_et_refuse_le_refrigere() {
        Peniche peniche = new Peniche("PEN-0001", 2_500_000);
        Colis standard = new Colis("sac", 10, 50, 40, 30, TypeMarchandise.STANDARD, 100);
        Colis refrigere = new Colis("lait", 10, 50, 40, 30, TypeMarchandise.REFRIGERE, 100);

        assertTrue(peniche.peutPrendreEnCharge(List.of(standard), ModeTransport.FLUVIAL));
        assertFalse(peniche.peutPrendreEnCharge(List.of(refrigere), ModeTransport.FLUVIAL));
        assertFalse(peniche.peutPrendreEnCharge(List.of(standard), ModeTransport.MER));
    }

    @Test
    void paris_le_havre_fait_365_km_sans_urgence_ni_refrigere() {
        Client client = new Client();
        client.setType(TypeClient.PARTICULIER);
        ValidateurExpedition validateur = new ValidateurExpedition();
        Colis standard = new Colis("sac", 10, 50, 40, 30, TypeMarchandise.STANDARD, 100);
        Colis refrigere = new Colis("lait", 10, 50, 40, 30, TypeMarchandise.REFRIGERE, 100);

        assertEquals(365, validateur.valider(client, List.of(standard), "Paris", "Le Havre", ModeTransport.FLUVIAL, false));
        assertNull(validateur.valider(client, List.of(standard), "Paris", "Le Havre", ModeTransport.FLUVIAL, true));
        assertNull(validateur.valider(client, List.of(refrigere), "Paris", "Le Havre", ModeTransport.FLUVIAL, false));
    }

    @Test
    void le_hors_gabarit_ajoute_10_pourcent() {
        assertEquals(110, new SupplementHorsGabarit(expedition -> 100).calculer(new Expedition()), CENTIME);
    }
}
