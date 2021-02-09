/*
- Kickar igång allt här
- Spelloop -> Kommandon -> Uppdaterar spelet
 */

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4, room5;
    private Room[] map;
    boolean gameOn = true;

    public Game(){

        //Skapa rum-variable först med konstruktor parametrarna NAMN + BESKRIVNING!
        room1 = new Room("[1]. Vardagsrum", "Stor och fult med en soffa");
        room2 = new Room("[2]. Hall", "liten trång med ful tapet");
        room3 = new Room("[3]. Rum 3", "description3");
        room4 = new Room("[4]. Rum 4", "description4");
        room5 = new Room("[5] . EXIT", "THE END");

        //Skapar en array av Room-klassen, som man sedan gör om till 4 olika rum
        map = new Room[5]; // <- - - - -
        map[0] = room1;
        map[1] = room2;
        map[2] = room3;
        map[3] = room4;
        map[4] = room5;


        //- - - GameObjects - - -
        GameObject lampa = new GameObject("Taklampa", false); //Namn +  ska inte gå att flytta
        GameObject key = new GameObject("Key", true);
        GameObject kanin = new GameObject("Liten vit kanin", true); //Namn + ska kunna flyttas
        Container box = new Container("En blå låda", false, true); //Namn + ska inte kunna gå att flytta + upplåst

        GameObject bajs = new GameObject("En bajskorv", true);

        room1.addObject(kanin); //I rum ett, läg till objektet kanin
        room1.addObject(box);
        room2.addObject(lampa);
        room2.addObject(box);

        // - - - NPC's - - -
        Person Otto = new Person("Otto", 0);
        room1.addNpc(Otto);
        Otto.getInventory().addObject(lampa);

        Person Kevin = new Person("Kevin", 1);
        room2.addNpc(Kevin);
        Kevin.getInventory().addObject(key);

        Person Lars = new Person("Lars", 2);
        room3.addNpc(Lars);
        Lars.getInventory().addObject(lampa);

        Person Erik = new Person("Erik", 3);
        room4.addNpc(Erik);
        Erik.getInventory();

        /*
        System.out.println(lampa);
        System.out.println(lampa.isMovable()); //Visar false, från metoden i klassen
        System.out.println(kanin);
        System.out.println(kanin.isMovable()); //Visar true, från metoden i klassen
         */

        //- - - Inventory - - -
        Inventory playerInventory = new Inventory(5);
        System.out.println(playerInventory); //Printar inventory, som då är tom
        playerInventory.addObject(kanin); //Lägger till kanin i inventory arrayen /listan
        playerInventory.addObject(key);
        System.out.println(playerInventory);
        playerInventory.addObject(bajs);
        System.out.println(playerInventory); //Printar ut listan igen, med kanin i första plats

        playerInventory.moveObject(Erik.inventory, bajs);
        System.out.println(playerInventory);

        //- - - Starta GUI:t - - -
        this.gui = new Gui();
        //System.out.println(map[1]); //room1
        //gui.setShowRoom(map[1].toString()); // Shows a room in GUI with setShowRoom-method from GUI

        //toString för att det skrivs ut som en sträng, vilket vanligtvis sout gör
        int position = 0;
        gui.setShowRoom(map[position].toString()); //Visa position i rumarrayen

        //[r1, r2, r3] Man ska ej kunna gå från rum3 -> rum1

        playerInventory.removeElement("Liten vit kanin");
        System.out.println(playerInventory);

        while (gameOn){
            String command = gui.getCommand();
            if (!command.equals("-1")) { //Om fältet -1 eller null, kör då nedanstående

                if (command.equals("1")) {  //Equals gäller alltid för strängar, objekt
                    // Här kan man skriva if-sats för att kolla vilken position de är på och om de kan gå från det rummet till ett annat
                    position = 0; //Skriver man ett så är positionen rum1 i Array
                }
                if (command.equals("2")) {
                    position = 1;
                }
                if (command.equals("3")) {
                    position = 2;
                }
                if (command.equals("4")) {
                    position = 3;
                }
                /*if (command.equals("4")) {
                    if (playerInventory.containsobjectKey) {
                        position = 4;
                    }
                }*/
            }
            gui.setShowRoom(map[position].toString());
            gui.setShowInventory(playerInventory);

            if (map[position].getPersons() != null) { //Om map-positionen inte är null
            gui.setPerson(map[position].getPersons()); //Finns personen i rummet, printa den då på GUI
            }
        }



        /*
        while (true) {     // Kör while loopen hela tiden för att ta emot kommandon i GUI:t
            String command = gui.getCommand();
            System.out.println(command);
            // Hämtar instruktioner från användaren
        }*/

    }



}