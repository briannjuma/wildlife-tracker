// This class presents template for animals of endangered species type

package Models;

import org.sql2o.Connection;

import java.util.List;

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

    //save into database
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name).addParameter("type", this.type).addParameter("health", this.health).addParameter("age", this.age).executeUpdate().getKey();
        }
        catch (ClassCastException exc){

        }
    }

    // Retrieve records
    public static List<Endangered> all() {
        String sql = "SELECT * FROM animals WHERE type = 'endangered'";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Endangered.class);
        }
    }

}
