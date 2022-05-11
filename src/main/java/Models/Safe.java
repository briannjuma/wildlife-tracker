// This class presents the template for animals of the invulnerable species type
package Models;

public class Safe extends Animal{
    //fields
    private static final String STATUS = "safe";
    private String health;
    private String age;

    // No getters since no additional information was required for invulnerable species

    //constructor
    public Safe(String name,String health, String age,String STATUS){
        this.name=name;
        this.health = health;
        this.age = age;
        this.type= STATUS ;
    }
}
