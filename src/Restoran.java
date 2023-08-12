import java.util.ArrayList;

public class Restoran extends UgostiteljskiObjekat{

    private int brSlobodnihStolova;

    public Restoran(String naziv, double prosecnaOcena, int brMichelinZvezda, ArrayList<String> recenzije, int brSlobodnihStolova) {
        super(naziv, prosecnaOcena, brMichelinZvezda, recenzije);
        this.brSlobodnihStolova = brSlobodnihStolova;
    }

    public Restoran(String naziv, double prosecnaOcena, int brMichelinZvezda, int brSlobodnihStolova) {
        super(naziv, prosecnaOcena, brMichelinZvezda);
        this.brSlobodnihStolova = brSlobodnihStolova;
    }

    public Restoran(String naziv, double prosecnaOcena, int brSlobodnihStolova) {
        super(naziv, prosecnaOcena);
        this.brSlobodnihStolova = brSlobodnihStolova;
    }

    public Restoran(String naziv, int brSlobodnihStolova) {
        super(naziv);
        this.brSlobodnihStolova = brSlobodnihStolova;
    }

    public Restoran(String naziv) {
        super(naziv);
        this.brSlobodnihStolova = 25;
    }

    public int getBrSlobodnihStolova() {
        return brSlobodnihStolova;
    }

    public void setBrSlobodnihStolova(int brSlobodnihStolova) {
        this.brSlobodnihStolova = brSlobodnihStolova;
    }

    public boolean imaLiSlobodnihStolova() {
        return brSlobodnihStolova > 0;
    }

    public void oslobodiSto() {
        brSlobodnihStolova += 1;
    }

    public void oslobodiSto(int x) {
        brSlobodnihStolova += x;
    }

    public void zaokupiSto() {
        if (brSlobodnihStolova > 0)
            brSlobodnihStolova -= 1;
    }

    public void zaokupiSto(int x) {
        while (brSlobodnihStolova > 0 && x > 0) {
            brSlobodnihStolova--;
            x--;
        }
    }

    @Override
    public void dodajOcenu(double ocena) {
        if (ocena > 0) {
            if (ocena > getProsecnaOcena() && ocena >= 4.5) {
                ocena -= 0.3;
                setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                azurirajZvezdu();
            }
            else if (ocena > getProsecnaOcena()) {
                ocena -= 0.3;
                setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
            }
            else if (ocena < getProsecnaOcena() && ocena <= 2.0){
                setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                azurirajZvezdu();
            }
            else if (ocena < getProsecnaOcena()){
                setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
            }
        }
    }

    @Override
    public void azurirajZvezdu() {
        if (getProsecnaOcena() > 4.5)
            setBrMichelinZvezda(getBrMichelinZvezda() + 2);
        else if (getProsecnaOcena() > 3.5)
            setBrMichelinZvezda(getBrMichelinZvezda() + 1);
        else if (getProsecnaOcena() > 3.0)
            setBrMichelinZvezda(getBrMichelinZvezda() - 1);
        else
            setBrMichelinZvezda(getBrMichelinZvezda() - 2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        sb.append("Restoran     \n");
        sb.append("---------------------\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
