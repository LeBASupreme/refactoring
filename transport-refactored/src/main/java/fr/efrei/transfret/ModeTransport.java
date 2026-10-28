package fr.efrei.transfret;

public enum ModeTransport {
    ROUTE(new TarifRoute(), new DelaiRoute(), true, true, true),
    RAIL(new TarifRail(), new DelaiRail(), true, false, true),
    MER(new TarifMer(), new DelaiMer(), true, true, false),
    AIR(new TarifAir(), new DelaiAir(), false, false, true),
    FLUVIAL(new TarifFluvial(), new DelaiFluvial(), true, false, false);

    private final TarifTransport tarif;
    private final DelaiTransport delai;
    private final boolean dangereuxAutorise;
    private final boolean refrigereAutorise;
    private final boolean urgenceAutorisee;

    ModeTransport(TarifTransport tarif, DelaiTransport delai, boolean dangereuxAutorise, boolean refrigereAutorise, boolean urgenceAutorisee) {
        this.tarif = tarif;
        this.delai = delai;
        this.dangereuxAutorise = dangereuxAutorise;
        this.refrigereAutorise = refrigereAutorise;
        this.urgenceAutorisee = urgenceAutorisee;
    }

    public TarifTransport tarif() {
        return tarif;
    }

    public DelaiTransport delai() {
        return delai;
    }

    public boolean accepteDangereux() {
        return dangereuxAutorise;
    }

    public boolean accepteRefrigere() {
        return refrigereAutorise;
    }

    public boolean accepteUrgence() {
        return urgenceAutorisee;
    }
}
