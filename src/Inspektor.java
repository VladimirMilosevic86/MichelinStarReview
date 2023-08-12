public class Inspektor {

    private UgostiteljskiObjekat objekat;

    public Inspektor(UgostiteljskiObjekat objekat) {
        this.objekat = objekat;
    }

    public UgostiteljskiObjekat getObjekat() {
        return objekat;
    }

    public void setObjekat(UgostiteljskiObjekat objekat) {
        this.objekat = objekat;
    }

    public void dodajOpis(String opis){
        objekat.dodajRecenziju(opis);
    }

    public void dodajOcenu(double ocena){
        objekat.dodajOcenu(ocena);
    }

    //Ovo nije tacno verovatno - ne razumem kako da odeli zvezdu a da ne zahteva argument neki
    public void dodeliZvezdu(){
        objekat.azurirajZvezdu();
    }

    public String procitajRecenzije(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objekat.getRecenzije().size(); i++) {
            sb.append(i + 1).append(") ").append(objekat.getRecenzije().get(i)).append(" [").append(i).append("]").append("\n");
        }
        return sb.toString();
    }

    public void zatvoriObjekat(){
        objekat.setProsecnaOcena(1.0);
        objekat.setBrMichelinZvezda(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inespektor je bio u sledecm objektu:\n");
        sb.append(objekat.getNaziv());
        return sb.toString();
    }
}
