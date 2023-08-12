# MichelinStarReview

Napomene i uputstva
Vreme izrade testa je 120 minuta.
Napraviti projekat OOPTest i paket sa imenom imePrezimeOOP unutar src foldera.
Imena klasa, atributa (polja) i metoda pisati onako kao sto je naznaceno (boldovano)!
Napisati praznu klasu CodeWars i kao komentar ostaviti link ka vasem profilu.
Znakove "\t" i "\n" interpretirati kao Tab-ove i Enter-e!
Ukoliko je x neka promenjiva, tada se sa <x> oznacava vrednost te promenjive.
Npr za int x = 5;:
Ispisati poruku "Vrednost od x je <x>" --> "Vrednost od x je 5"
Dozvoljeno je pisanje dodatnih (pomocnih) metoda (bilo private ili public). One ne mogu da uticu negativno na ocenu.

Michelin Star Review

Potrebno je kreirati program Michelin Star Review koji pomaze Miselin inspektorima da ocene ugostiteljske objekte.
Aplikacija omogucava inspektoru da dobije uvidjaj o odredjenim podacima nekog ugostiteljskog objekta, kao i da dobije i azurira ocene i recenzije istog.
==================================================================================================================================================================
1. UgostiteljskiObjekat
Kreirati apstraktnu klasu UgostiteljskiObjekat koja opisuje uopsteno neki ugostiteljski objekat.
Svaki ugostiteljski objekat ima svoje ime, svoju prosecnu ocenu (realan broj [1.0, 5.0]), broj Michelin zvezda (ceo broj [0, 3]), i listu recenzija.
Popuniti ovu klasu na sledeci nacin:
1. Polja:
String naziv
double prosecnaOcena
int brMichelinZvezda
ArrayList<String> recenzije
2. Konstruktori:
Pun konstruktor koji popunjava svaki atribut preko argumenata metode
Konstruktor koji prima argumente String naziv, double prosecnaOcena, int brMichelinZvezda, a listu recenzija postavlja na novu, praznu ArrayListu
Konstruktor koji prima argumente String naziv, double prosecnaOcena, a broj Michelin zvezda postavlja na 0 i listu recenzija postavlja na novu, praznu ArrayListu
Konstruktor koji samo prima argument String naziv, a prosecnu ocenu postavlja na 3.0, broj Michelin zvezda na 0 i listu recenzija postavlja na novu, praznu ArrayListu
3. Napisati sve potrebne gettere i settere.
4. Omoguciti da inspektor moze da doda recenziju i obrise recenziju.
5. Napisati metodu public void dodajViseOcena(ArrayList<Double> ocene) koja:
racuna prosecnu ocenu iz proslednjene liste, a zatim pamti novu prosecnu ocenu ugostiteljskog objekta kao prosek dobijene prosecne ocene iz liste i trenutne prosecne ocene ugostiteljskog objekta.
Zatim azurirati broj zvezdi.
6. Napisati abstraktne metode:
public abstract void dodajOcenu(double ocena); koja prima double ocenu i
na odredjeni nacin azurira ocenu ugostiteljskog objekta.
public abstract void azurirajZvezdu(); koja na odredjeni nacin procenjuje da li treba nekom ugostiteljskom objektu
da se doda ili oduzme zvezda. Paziti na cinjenicu da nijedan takav objekat ne moze da ima strogo manje od 0 niti strogo vise od 3 zvezde!
7. Preopteretiti toString() metod:
"\t-----<naziv>-----"
"\t*****(<brMichelinZvezda>)*****"
""
"Prosecna ocena: <prosecnaOcena>"
"Recenzije:"
"1) <recenzija[0]>"
"2) <recenzija[1]>"
...
"N) <recenzija[N]>"
====================================================================================================================================================================================================================
2. Restoran
Kreirati klasu Restoran koja prosiruje klasu UgostiteljskiObjekat i koja opisuje neki restoran.
Svaki restoran pored navedenih stvari ima i broj slobodnih stolova.
Popuniti ovu klasu na sledeci nacin:
1. Polja:
int brSlobodnihStolova
2. Konstruktori:
Potpun konstruktor koji prima sve argumente
Po jedan konstruktor za svaki nadkonstruktor koji prima argument za broj slobodnih stolova i sve ostale odgovarajuce argumente
Jedan konstruktor koji prima samo String naziv, a postavlja broj slobodnih stolova na 25
3. Napisati sve potrebne gettere i settere, pazeci da broj slobodnih stolova ne moze biti negativan broj!
4. Napisati sledece metode:
public boolean imaLiSlobodnihStolova() koja se pita da li postoji slobodan sto.
public void oslobodiSto() koja dodaje jedan slobodan sto.
public void oslobodiSto(int x) koja dodaje x slobodnih stolova.
public void zaokupiSto() koja zaokupljuje jedan slobodan sto. Paziti da broj slobodnih stolova ne moze biti negativan broj.
public void zaokupiSto(int x) koja zaokupljuje x slobodnih stolova. Paziti da broj slobodnih stolova ne moze biti negativan broj.
Ukoliko nema dovoljno slobodnih stolova, zaokupiti onoliko koliko ih je ostalo!
5. Implementirati naredne metode:
public abstract void dodajOcenu(double ocena); na sledeci nacin:
Ukoliko je prosledjena ocena veca ili jednaka od prosecne ocene restorana, onda je umanjiti za 0.3 i izracunati i zapamtiti novu prosecnu ocenu restorana. (kao prosek prosledjene i trenutne)
Ukoliko je prosledjena ocena strogo manja od prosecne ocene restorana, izracunati i zapamtiti novu prosecnu ocenu restorana. (kao prosek prosledjene i trenutne)
Ukoliko je proslednjena ocena nevalidna, zanemariti je.
Ukoliko je prosledjena ocena veca ili jednaka od 4.5 ili manja ili jednaka od 2.0 azurirati broj zvezda restorana.
public abstract void azurirajZvezdu(); na sledeci nacin:
Ukoliko je prosecna ocena strogo iznad 4.5, dodati 2 zvezde restoranu.
Ukoliko je prosecna ocena strogo veca od 3.5 a ispod 4.5, dodati 1 zvezdu restoranu.
Ukoliko je prosecna ocena strogo veca od 3.0 a ispod 3.5, oduzeti 1 zvezdu restoranu.
Ukoliko je prosecna ocena manja ili jednaka od 3.0, oduzeti 2 zvezde restoranu.
6. Preopteretiti toString() metod:
"---------------"
"\Restoran\t"
"---------------"
"\t-----<naziv>-----"
"\t*****(<brMichelinZvezda>)*****"
""
"Prosecna ocena: <prosecnaOcena>"
"Recenzije:"
"1) <recenzija[0]>"
"2) <recenzija[1]>"
...
"N) <recenzija[N]>"
===========================================================================================================================================================================================
3. Inspektor
Kreirati klasu Inspektor koja predstavlja jednog Michelin inspektora.
Svaki inspektor ima ugostiteljski objekat kojeg trenutno pregleda.
Popuniti ovu klasu na sledeci nacin:
1. Polja:
UgostiteljskiObjekat objekat
2. Konstruktori:
Kreirati jedan potpun konstruktor
3. Napisati sve potrebne gettere i settere
4. Napisati sledece metode:
public void dodajOpis(String opis) koja dodaje recenziju tom ugostiteljskom objektu kojeg inspektor trenutno pregleda.
public void dodajOcenu(double ocena) koja dodaje ocenu tom ugostiteljskom objektu kojeg inspektor trenutno pregleda.
public void dodeliZvezdu() koja dodeljuje ili oduzima odredjen broj zvezdi od ugostiteljskog objekta kojeg inspektor trenutno pregleda.
public String procitajRecenzije() koja vraca sve recenzije ugostiteljskog objekta kojeg inspektor trenutno pregleda, kao Nisku oblika:
"1) <recenzija[0]>"
"2) <recenzija[1]>"
...
"N) <recenzija[N]>"
public String procitajRecenzije(int i) koja vraca i-tu recezniju ugostiteljskog objekta kojeg inspektor trenutno pregleda, pazeci na validnost prosledjenog indeksa!
public void zatvoriObjekat() koja postavlja ocenu ugostiteljskog objekta kojeg inspektor trenutno pregleda na 1.0 i broj zvezda na 0.
public static int uporediUgostiteljskeObjekte(UgostiteljskiObjekat o1, UgostiteljskiObjekat o2) koja vraca:
-1; Ako je o1 strogo bolji ugostiteljski objekat od ugostiteljskog objekta o2
0; Ako je o1 ugostiteljski objekat isti kao ugostiteljski objekat o2
1; Ako je o2 strogo bolji ugostiteljski objekat od ugostiteljskog objekta o1
Ugostiteljski objekat je strogo bolji od nekog drugog ugostiteljskog objekta ako:
Ima strogo vise Miselinovih zvezda
Ima strogo bolju prosecnu ocenu; ukoliko imaju isti broj Miselinovih zvezdi
