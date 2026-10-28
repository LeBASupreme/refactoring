package fr.efrei.transfret;

public enum ModeTransport {
    ROUTE(new TarifRoute(), new DelaiRoute()),
    RAIL(new TarifRail(), new DelaiRail()),
    MER(new TarifMer(), new DelaiMer()),
    AIR(new TarifAir(), new DelaiAir());

    private final TarifTransport tarif;
    private final DelaiTransport delai;

    ModeTransport(TarifTransport tarif, DelaiTransport delai) {
        this.tarif = tarif;
        this.delai = delai;
    }

    public TarifTransport tarif() {
        return tarif;
    }

    public DelaiTransport delai() {
        return delai;
    }
}
