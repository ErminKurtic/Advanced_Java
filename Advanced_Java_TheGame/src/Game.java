/*
- Kickar igång allt här
- Spelloop -> Kommandon -> Uppdaterar spelet
 */

import java.util.Arrays;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4, room5;
    private Room[] map;
    boolean gameOn = true;
    boolean hasKey = false;

    public Game(){

        //Skapa rum-variable först med konstruktor parametrarna NAMN + BESKRIVNING!
        room1 = new Room("[1]. Vardagsrum", "Stor och fult med en soffa");
        room2 = new Room("[2]. Hall", "liten trång med ful tapet");
        room3 = new Room("[3]. Rum 3", "description3");
        room4 = new Room("[4]. Rum 4", "description4");

        //Skapar en array av Room-klassen, som man sedan gör om till 4 olika rum
        map = new Room[5]; // <- - - - -
        map[0] = room1;
        map[1] = room2;
        map[2] = room3;
        map[3] = room4;


        //- - - GameObjects - - -
        GameObject lampa = new GameObject("lampa", false); //Namn +  ska inte gå att flytta
        GameObject key = new GameObject("key", true);
        GameObject kanin = new GameObject("kanin", true); //Namn + ska kunna flyttas
        Container box = new Container("box", false, true); //Namn + ska inte kunna gå att flytta + upplåst

        GameObject kaka = new GameObject("kaka", true);

        room1.addObject(kanin); //I rum ett, läg till objektet kanin
        room1.addObject(box);
        room2.addObject(lampa);
        room2.addObject(box);
        room1.addObject(key);

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


        //- - - Starta GUI:t - - -
        this.gui = new Gui();
        //System.out.println(map[1]); //room1
        //gui.setShowRoom(map[1].toString()); // Shows a room in GUI with setShowRoom-method from GUI

        //toString för att det skrivs ut som en sträng, vilket vanligtvis sout gör
        int position = 0;
        gui.setShowRoom(map[position].toString()); //Visa position i rumarrayen

        //[r1, r2, r3] Man ska ej kunna gå från rum3 -> rum1

        while (gameOn){

            String command = gui.getCommand();
            String[] choice = command.split("\\s", 2);

            switch (choice[0]){

                case "1":
                   position = 0;
                   gui.gotCommand();
                   break;

                case "2":
                    position = 1;
                    gui.gotCommand();
                    break;

                case "3":
                    position = 2;
                    gui.gotCommand();
                    break;

                case "4":
                    position = 3;
                    gui.gotCommand();
                    break;

                case "pickup":
                    GameObject temp = map[0].getInventory().getGameObject(choice[1]);
                    if (position == 0) {
                        map[0].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else if (position == 1){
                        map[0].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else if (position == 2){
                        map[0].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else if (position == 3){
                        map[0].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }

                    if (temp == key){
                        System.out.println("YOU GOT THE KEY! NOW RUN TO ROOM 4 AND EXIT!");
                        hasKey = true;
                    }
                    gui.gotCommand();
                    break;

                case "exit":
                    if (hasKey == true && position == 3){
                        System.out.println("YOU GOT OUT!!!");
                        gameOn = false;
                    }
                    gui.gotCommand();
                    break;

            }

            /*if (!command.equals("-1")) { //Om fältet -1 eller null, kör då nedanstående

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

                }}*/
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