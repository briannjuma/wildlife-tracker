// This is an Abstract class that extends both endangered and safe species.

package Models;

public abstract class Animal {
    //fields
    public String name;
    public String type;
    public int id;

    //getters
    public String getName(){ return name;}
    public String getType(){ return type;}
    public int getId() {return id;}

}
