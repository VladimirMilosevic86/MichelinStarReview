public class ZadatakTest {

    public static void main(String[] args) {
        Restoran restoran = new Restoran("Zaplet", 3.0, 5);

        restoran.zaokupiSto(3);
        System.out.println("Broj stolova: " + restoran.getBrSlobodnihStolova());
        restoran.dodajOcenu(5);
        System.out.println("Prosecna ocena: " + restoran.getProsecnaOcena());

        System.out.println(restoran);
    }

}
