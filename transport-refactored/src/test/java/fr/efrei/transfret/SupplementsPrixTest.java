package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementsPrixTest {

    private static final double CENTIME = 0.001;
    private static final ComposantPrix CENT = expedition -> 100;

    @Test
    void le_fragile_ajoute_15_pourcent() {
        assertEquals(115, new SupplementFragile(CENT).calculer(new Expedition()), CENTIME);
    }

    @Test
    void le_dangereux_ajoute_30_pourcent() {
        assertEquals(130, new SupplementDangereux(CENT).calculer(new Expedition()), CENTIME);
    }

    @Test
    void le_refrigere_ajoute_20_pourcent() {
        assertEquals(120, new SupplementRefrigere(CENT).calculer(new Expedition()), CENTIME);
    }

    @Test
    void l_urgence_multiplie_par_1_5() {
        assertEquals(150, new SupplementUrgence(CENT).calculer(new Expedition()), CENTIME);
    }

    @Test
    void l_entreprise_a_10_pourcent_sur_1000() {
        Expedition expedition = new Expedition();
        Client client = new Client();
        client.setType(TypeClient.ENTREPRISE);
        expedition.setClient(client);
        ComposantPrix mille = ignoree -> 1000;

        assertEquals(900, new RemiseClient(mille).calculer(expedition), CENTIME);
    }

    @Test
    void l_assurance_ajoute_15_euros_quand_2_pourcent_sont_en_dessous() {
        Expedition expedition = new Expedition();
        expedition.getColis().add(new Colis("colis", 1, 0, 0, 0, TypeMarchandise.STANDARD, 100));

        assertEquals(115, new Assurance(CENT).calculer(expedition), CENTIME);
    }
}
