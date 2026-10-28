package fr.efrei.transfret;

public class Notificateur {

    private final CanalNotification email;
    private final CanalNotification sms;

    public Notificateur(CanalNotification email, CanalNotification sms) {
        this.email = email;
        this.sms = sms;
    }

    public void envoyer(Client client, String sujet, String corps, String sms) {
        email.envoyer(client.getEmail(), sujet, corps);
        if (sms != null && client.getType() == TypeClient.PREMIUM) {
            this.sms.envoyer(client.getTelephone(), sms, sms);
        }
    }
}
