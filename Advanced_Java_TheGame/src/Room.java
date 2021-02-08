/* - Ha unika namn
- ett inventory för rummet
- showMethod() som beskriver vad som finns för spelaren
 */

public class Room {

    private String name; // Rummets namn
    private String description;  // Rummets beskrivning
    private Inventory inventory;
    private Person[] person;

    public Room(String roomName, String roomDescription) {   // <- - Konstruktor
        this.person = new Person[5]; //Upp till fem personer i ett rum
        this.name = roomName;
        this.description = roomDescription;
        this.inventory = new Inventory(10);
        // Variabel som skickas in här får rumnamn, beskrivning och storlek på 10 platser i inventory
    }

    public String toString(){
        return name + " : " + description +"\n" +inventory;
    }

    public void addObject(GameObject go){
        this.inventory.addObject(go);
    }

    public void addNpc(Person person){
        this.person[0] = person; //TODO Fixa fler personer, som i inventory listan, kolla lediga platser och lägg till ifall null
    }

    public Person getPersons(){
        return this.person[0];   //Skickar tillbaka första positionen
    }


}
