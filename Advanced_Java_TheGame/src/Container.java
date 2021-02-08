/*
- Subklass till GameObject som har ett Inventory
- Kan vara låst eller öppet
 */

public class Container extends GameObject{  //Får alla egenskaper från GameObject

    private Inventory inventory;
    private boolean locked;

    public Container(String name, boolean moveable, boolean locked){
        super(name,moveable);
        this.inventory = new Inventory(3);
        this.locked = locked;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public boolean isLocked(){
        return this.locked;
    }


    // METODER -> RITA INTE UT CONTAINER OM DEN ÄR LÅST
    // ÄR DEN ÖPPEN SÅ SKRIV UT DEN ETC
}
