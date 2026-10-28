package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        Expedition expedition = new Expedition();
        expedition.setColis(colis);
        expedition.setDistance(distance);
        expedition.setMode(mode);
        expedition.setUrgent(urgent);
        expedition.setAssurance(assurance);
        Client client = new Client();
        client.setType(typeClient);
        expedition.setClient(client);
        return Utils.arrondir(new AssembleurPrix().assembler(expedition).calculer(expedition));
    }
}
