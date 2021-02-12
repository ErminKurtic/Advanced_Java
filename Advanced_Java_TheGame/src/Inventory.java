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
import java.util.List;
import java.util.stream.IntStream;

public class Inventory {

    private GameObject[] inventoryList; //Lista av gameobjects
    private int size; //Listans storlek
    private int numberOfItems = 0;

    public Inventory(int size){
        this.size = size;
        inventoryList = new GameObject[size];
    }
    public void countUp(){
        numberOfItems++;
    }

    public String toString(){
        return Arrays.toString(this.inventoryList);
    }

    private int getFirstEmptyIndex(){  //SKA HANTERAS MED STREAMS;REGEX

       /* GameObject[] gameobject = Arrays.stream(inventoryList)
                .filter(Object::nonNull)
                .findFirst();*/

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
        numberOfItems++;
    }

   /* public void moveObject(Inventory inventory2, GameObject go){
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
    }*/

    public boolean findAndRemoveItem(String matchString){
        int index = -1;
        boolean done = false;

        for(int i = 0; i < this.inventoryList.length && !done; i++){
            if(matchString.equals(this.inventoryList[i].returnNameOfObject())){
                index = i;
                System.out.println("FOUND ITEM");
                done = true;

                removeElement(this.inventoryList[i], i);
            }
        }
        return done;
    }

   public void removeElement(GameObject go, int index){
        if (go == null){
            System.out.println("Inventory is empty, nothing to remove");
        }
      /* int index = IntStream.range(0, numberOfItems)
               .filter(i -> go.equals(inventoryList[i]))
               .findFirst()
               .orElse(-1);*/

       GameObject[] value = IntStream.range(0, inventoryList.length)
               .filter(i -> i !=index)
               .mapToObj(i -> inventoryList[i])
               .toArray(GameObject[]::new);

        inventoryList = Arrays.copyOf(value, size);
    }

    public GameObject getGameObject(String matchString){

        GameObject temp = null;
        boolean done = false;
        String name = "";

        for(int i = 0; i < numberOfItems && !done; i++){
            name = this.inventoryList[i].returnNameOfObject();

            if(matchString.equals(name)){
                temp = inventoryList[i];
                done = true;
            }
        }
        return temp;
    }

}

