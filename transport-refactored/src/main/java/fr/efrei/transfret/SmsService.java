package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public class SmsService implements CanalNotification {

    private final List<String[]> journal = new ArrayList<String[]>();

    private String apiKey = "sk_live_8f7d6e5c4b3a2918";

    @Override
    public void envoyer(String destinataire, String sujet, String corps) {
        String message = corps;
        if (message.length() > 160) {
            message = message.substring(0, 157) + "...";
        }
        System.out.println("[SMS] -> " + destinataire + " : " + message);
        journal.add(new String[]{destinataire, message});
    }

    @Override
    public List<String[]> journal() {
        return journal;
    }
}
