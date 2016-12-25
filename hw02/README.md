# Úloha č. 2: Parkovací systém

**Zadanie projektu:** pondelok 7.11.

**Odovzdanie projektu:** pondelok 28.11. 23:59

Vašou druhou domácou úlohou je vytvoriť jednoduchy parkovací systém. 

## Bodovanie

Maximálny počet bodov je **9**, body sú rozdelené nasledovne:
 
* **6 bodov** za prejdenie testov (priložené testy negarantujú 100% správnosť),
* **2 body** za správnu implementáciu (posúdia cvičiaci),
* **1 bod** za čístú a elegantnú implementáciu. 

## Požiadavky

Úloha má preveriť vaše znalosti:

* základného používania výnimiek
* prácu s kolekciami a znalosť jednotlivých metód
* korektné nadefinovanie rovnosti jednotlivých objektov
* korektné používanie `static` metód a premenných

Vašou úlohou je vytvoriť triedy (prípadne doplniť kód) v balíčku `cz.muni.fi.pb162.parking.impl`:

### 1. Person 

Máte vytvorenú triedu `Person`, do ktorej pridáte:

* unikátne id osoby typu `int`
    -  rastúce od čisla 1 (t.j. 1, 2, 3, ... )
    - id nastavíte v konštruktore triedy
* statickú metódu `boolean isAlreadyStored(String name)`, ktorá zistí, či už bola vytvorená osoba s daným menom
* nastavíte rovnosť dvoch osôb v prípade, že majú rovnaké id

### 2. Car

Vytvoríte triedu auto, ktoré bude mať 7 znakovú registračnú značku, vlastníka auta a parkovací lístok. Konštruktor má dva parametre: značku a osobu (vlastníka).
Trieda bude mať statickú metódu `boolean isValidPlate(String registrationPlate)`, ktorá skontroluje, 
či má značka presne 7 znakov a obsahuje iba písmená a čísla. Rovnosť dvoch áut platí v prípade, 
keď autá majú zhodnú registračnú značku a vlastníka. Trieda bude mať metódu `boolean buyTicket(int days)`, 
ktorá umožní kúpiť lístok. Avšak každé auto môže mať iba jeden lístok, takže ak už auto nejaký lístok má, 
metóda zlyhá a vráti false (inak true). Vytvorte si aj metódu na odstránenie parkovacieho lístka (ktorú použijete pri odchode auta z parkoviska).

Pre jednoduchosť vytvorte pre každý atribút v Car a Person gettery a settery (aj pre id). Tieto dve triedy majú tiež vytvorené triedy na generovanie objektov: `PersonFactory` a `CarFactory`. Metódy týchto tried môžete použiť pri testovaní, nie v samotnom kóde.

### 3. ParkingTicket & ParkingTicketType

Triedu `ParkingTicket` som naimplementoval za vás, pretože pracuje s časom. Parkovací lístok je veľmi 
jednoduchý, dá  sa kúpiť iba na určitý počet dní a je platný do presne definovaného dátumu. Vytvorte 
datový typ `ParkingTicketType`, ktorý môže obsahovať jednu z nasledovných hodnôt:

* `VALID` - doba expirácie (čas konca platnosti) lístka ešte nenastala,
* `EXPIRED `- doba expirácie lístka už nastala,
* `MISSING` - lístok chýba.

### 4. PlaceOccupiedException

Vytvorte stráženú (hlídanú) výnimku `PlaceOccupiedException`, ktorá ako parameter berie správu, ktorú vypíše pri jej vyhodení.
Výnimka je vyhodená, ak je miesto, na ktoré chceme auto zaparkovať, už obsadené iným autom.

### 5. ParkingLotImpl 
Najviac práce bude v triede `ParkingLotImpl`, ktorá implementuje rozhranie `ParkingLot`. Trieda reprezentuje parkovisko, na ktorom sú zaparkované autá, 
pričom bude mať iba jeden atribút (kontrolujú to testy), naozaj to stačí. Prípadne si môžte vytvoriť ešte jeden atribút - konštantu - 
na uloženie kapacity parkoviska, ale nie je to potrebné.
Má konštruktor s práve jedným parametrom, ktorý je typu `int` a určuje kapacitu parkoviska. Trieda bude mať jeden atribút typu `List`, 
ktorý slúži na ukladanie áut zaparkovaných na parkovisku. Parkovacie miesta na parkovisku majú svoje čislo, začínajúce od nuly, zväčšujúce sa o jednotku. 
Stručné informácie k jednotlivým metódam (podrobnejší popis nájdete v rozhraní):

* `int parkInPlace(Car car, int place)` zaparkuje (prípadne preparkuje) auto na dané parkovacie miesto
* `int findCarNumber(Car car)` zistí parkovacie číslo daného auta
* `ParkingTicketType leaveParking(Car car)` auto opustí parkovisko a vráti typ lístka, aké malo auto
* `Collection<Car> getParkedCars()` vráti kolekciu unikátnych zaparkovaných áut
* `int getCapacity()` vráti kapacitu parkoviska
* `boolean isSpaceOccupied(int parkingNumber)` vráti true, ak sa na parkovacom mieste nachádza nejaké auto
* `boolean isFull()` vráti true, ak je parkovisko úplne plné
* `int getFreeParkingPlace()` vráti číslo parkovacieho miesta, ktoré je prázdne
* `Collection<Integer> getFreePlaces()` vráti kolekciu čísel všetkých prázdnych parkovacích miest
* `Set<Person> getExpiredCarOwners()` vráti množinu hriešnikov, ktorí majú prešlý parkovací lístok 

### Main

Trieda simuluje príkazový riadok po zadaní kapacity parkoviska. Príkazom *help* vypíšete príkazy, ktoré môžete použiť.

### Hinty

* nevytvárajte 'zbytočné' atribúty, neprejdú vám potom testy
* používajte metódy, ktoré už niekto spravil (napr. nerobte ručné zisťovanie toho, či je písmeno alfanumerickým znakom)
* využite metódy, ktoré ste vytvorili pri vytváraní iných metód, napr. `getFreeParkingPlace` by mala použiť `isFull`
* čítajte si javadoc, hlavne javadoc kolekcie [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
* občas sa oplatí použiť množinu alebo prekonvertovať zoznam do množiny
* priložené testy slúžia skôr na správne pochopenie zadania, nie na zistenie správnosti kódu (unit testy zistia, či tam daná chyba je, nepovedia vám že tam chyba nie je)
* kód aj komentáre by mal slušný programátor písať v angličtine
*  `toString()` vytvárať netreba, no odporúčam ho vytvoriť :slight_smile:
