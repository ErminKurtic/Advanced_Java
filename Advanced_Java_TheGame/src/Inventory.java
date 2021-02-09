/*
- Ska innehålla en Array av GameObjects.
- Ska vara anpassad efter maxantal objekt som det kan bära
- NPC kan bara bära ett GameObject åt gången
- Spelare kan bära flera
- Rummen kan innehålla flera items
- Programmet säger till ifall det blir för fullt

- Här sköts mekaniken för att plocka upp, byta bort och lägga ned objekt (STREAM-HANTERING)
 */


import java.util.Arrays;

public class Inventory {

    private GameObject[] inventoryList; //Lista av gameobjects
    private int size; //Listans storlek

    public Inventory(int size){
        this.size = size;
        inventoryList = new GameObject[size];
    }

    public String toString(){
        return Arrays.toString(this.inventoryList);
    }

    private int getFirstEmptyIndex(){  //SKA HANTERAS MED STREAMS;REGEX
        for (int i = 0; i < this.inventoryList.length; i++){
            if (this.inventoryList[i] == (null)){
                return i;  //Return avbryter loopen och skickar tillbaka värdet
                //Om platsen i arrayen är null, returnera indexen som itemet är på
            }
        }
        return -1; //Returnerar minus ett ifall listan är full, dvs full med items, ingen tom plats ledig

    }

    public void addObject(GameObject go) {
        //inventoryList[0]=go;  //Lägger objektet på första plats i arraylistan
        int index = getFirstEmptyIndex();
        if (index ==-1){
            System.out.println("Inventory is full");
            return;
            //Om det är fullt i inventory, skicka detta felmeddelande
        }
        this.inventoryList[index] = go; //Om det finns plats, lägg till objektet
    }

    public void moveObject(Inventory inventory2, GameObject go){
        // RÄKNA IGENOM INVENTORY LISTA, Kör metoden för att kolla ledighet i inventory
        int index = getFirstEmptyIndex();
        if (index ==-1){
            System.out.println("Inventory is full");
            return;
        }
         // if (!isObjectHere(go)) {
        // return Felmeddelande } Om det ej finns, returnera felmedelande
        inventory2.addObject(go);
        //this.removeObject(go) TA BORT OBJEKTET I LISTAN
    }

    public void removeElement(String matchString){
        for (int i = 0; i < this.inventoryList.length; i++){
            if(matchString.equals(this.inventoryList[i].returnNameOfObject())){
                System.out.println("FOUND THE ITEM");
                break;
            }
            else {
                System.out.println("DID NOT FIND THE ITEM");
                break;
            }
        }
    }

}

