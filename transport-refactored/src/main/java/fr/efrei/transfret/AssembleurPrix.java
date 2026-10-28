package fr.efrei.transfret;

public class AssembleurPrix {

    public ComposantPrix assembler(Expedition expedition) {
        ComposantPrix prix = new TarifDeBase();
        if (contient(expedition, TypeMarchandise.FRAGILE)) {
            prix = new SupplementFragile(prix);
        }
        if (contient(expedition, TypeMarchandise.DANGEREUX)) {
            prix = new SupplementDangereux(prix);
        }
        if (contient(expedition, TypeMarchandise.REFRIGERE)) {
            prix = new SupplementRefrigere(prix);
        }
        if (expedition.isUrgent()) {
            prix = new SupplementUrgence(prix);
        }
        prix = new RemiseClient(prix);
        if (expedition.isAssurance()) {
            prix = new Assurance(prix);
        }
        return prix;
    }

    private boolean contient(Expedition expedition, TypeMarchandise type) {
        for (Colis colis : expedition.getColis()) {
            if (colis.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
