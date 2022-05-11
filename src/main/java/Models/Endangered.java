// This class presents template for animals of endangered species type

package Models;

public class Endangered extends Animal {
    //fields
    private static final String STATUS = "endangered";
    private String health;
    private String age;

    //getters
    public String getHealth(){ return health;}
    public String getAge(){ return age;}

    //constructor
    public Endangered(String name, String health, String age ,String STATUS) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = STATUS;
    }
}
