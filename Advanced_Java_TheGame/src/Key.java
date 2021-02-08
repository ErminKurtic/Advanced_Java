/*
- Subklass till GameObject
- Låsa upp containers
- keyobjektet ska hålla koll på vilken instans av container den passar, eller tvärtom
 */

public class Key extends GameObject {

    Container container;

    public Key(String name, boolean moveable, Container c){
        super(name, moveable);
        this.container = c; //Nyckeln går till containern man skickar in
    }

    public boolean doesItFit(Container c){
        if (this.container.getName().equals(c.getName())){  //Om container(nyckeln) man skickar in heter samma som container
            return true; //Då passar den
        }
        else {
            return false; //Annars ej
        }
    }
}
