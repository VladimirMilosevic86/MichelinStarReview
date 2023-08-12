import java.util.ArrayList;

public abstract class UgostiteljskiObjekat implements Comparable<UgostiteljskiObjekat>{

    private String naziv;
    private double prosecnaOcena;
    private int brMichelinZvezda;
    private ArrayList<String> recenzije;

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena, int brMichelinZvezda, ArrayList<String> recenzije) {
        this.naziv = naziv;
        this.prosecnaOcena = prosecnaOcena;
        this.brMichelinZvezda = brMichelinZvezda;
        this.recenzije = recenzije;
    }

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena, int brMichelinZvezda) {
        this.naziv = naziv;
        this.prosecnaOcena = prosecnaOcena;
        this.brMichelinZvezda = brMichelinZvezda;
        this.recenzije = new ArrayList<>();
    }

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena) {
        this.naziv = naziv;
        this.prosecnaOcena = prosecnaOcena;
        this.brMichelinZvezda = 0;
        this.recenzije = new ArrayList<>();
    }

    public UgostiteljskiObjekat(String naziv) {
        this.naziv = naziv;
        this.prosecnaOcena = 3.0;
        this.brMichelinZvezda = 0;
        this.recenzije = new ArrayList<>();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public int getBrMichelinZvezda() {
        return brMichelinZvezda;
    }

    public void setBrMichelinZvezda(int brMichelinZvezda) {
        this.brMichelinZvezda = brMichelinZvezda;
    }

    public ArrayList<String> getRecenzije() {
        return recenzije;
    }

    public void setRecenzije(ArrayList<String> recenzije) {
        this.recenzije = recenzije;
    }

    public void dodajRecenziju(String recenzija) {
        recenzije.add(recenzija);
    }

    public void obrisiRecenziju(String recenzija){
        recenzije.remove(recenzija);
    }

    /* racuna prosecnu ocenu iz proslednjene liste, a zatim pamti novu prosecnu ocenu ugostiteljskog objekta kao prosek
    dobijene prosecne ocene iz liste i trenutne prosecne ocene ugostiteljskog objekta. Zatim azurirati broj zvezdi. */
    public void dodajViseOcena(ArrayList<Double> ocene) {
        double suma = 0;
        for (int i = 0; i < ocene.size(); i++) {
            dodajOcenu(ocene.get(i));
            suma += ocene.get(i);
        }
        prosecnaOcena = (prosecnaOcena + suma / ocene.size()) / 2;
        azurirajZvezdu();
    }

    //na odredjeni nacin azurira ocenu ugostiteljskog objekta.
    public abstract void dodajOcenu(double ocena);

    /* na odredjeni nacin procenjuje da li treba nekom ugostiteljskom objektuda se doda ili oduzme zvezda.
    Paziti na cinjenicu da nijedan takav objekat ne moze da ima strogo manje od 0 niti strogo vise od 3 zvezde! */
    public abstract void azurirajZvezdu();

    @Override
    public int compareTo(UgostiteljskiObjekat o){
        if (brMichelinZvezda > o.getBrMichelinZvezda() || (prosecnaOcena > o.getProsecnaOcena() && brMichelinZvezda == getBrMichelinZvezda()))
            return -1;
        else if (brMichelinZvezda == o.getBrMichelinZvezda() && prosecnaOcena == getProsecnaOcena())
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     ----- ").append(naziv).append(" -----").append("\n");
        sb.append("     ***** ").append(brMichelinZvezda).append(" *****").append("\n");
        sb.append("\n");
        sb.append("Prosecna ocena: ").append(prosecnaOcena).append("\n");
        sb.append("Recenzije:\n");
        for (String uo : recenzije)
            sb.append(uo).append("\n");
        return sb.toString();
    }
}
