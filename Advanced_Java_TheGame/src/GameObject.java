/*
 - Ska hantera alla icke levenade objekt (möbler, nycklar etc)
 - GameObject ska innehålla en boolean som,
 - avgör om objektet går att ta med sig eller det är fastmonterat i rummet
 */

public class GameObject {

    //Instans-variabler är variabler som är bundna till objekt

    private String name;
    boolean movable;  // Går det att flytta/plocka upp objekt, därav BOOLEAN för att kolla true/false

    public  GameObject(String name, boolean moveable){
        this.name = name;
        this.movable = moveable;
    }

    public String toString(){
        return this.name; // <- - - this.name returnerar private String name variablen i klassen
    }

    public boolean isMovable(){
        return this.movable;
    }

    public String getName(){
        return this.name;
    }
}
