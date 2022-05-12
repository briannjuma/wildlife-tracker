// This template represents details recorded by rangers when they spot an animal
package Models;
import org.sql2o.Connection;

import java.util.List;

public class Sightings {
    private int animalId;
    private String location;
    private String ranger;
    private int id;

    //getters
    public int getAnimalId(){ return animalId;}
    public String getLocation(){ return location;}
    public String getRanger(){ return ranger;}
    public int getId(){ return id;}

    //constructor
    public Sightings (String ranger, String location, int animalId ) {
        this.ranger = ranger;
        this.location = location;
        this.animalId = animalId;
    }

    //save object
    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO sightings (ranger, location, animalId) VALUES (:ranger, :location, :animalId)";
            this.id = (int) con.createQuery(sql, true) .addParameter("ranger",this.ranger).addParameter("location", this.location).addParameter("animalId", this.animalId).executeUpdate().getKey();
        }
        catch (ClassCastException exc){
        }
    }

    //retrieve records
    public static List<Sightings> getAll() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);/*all instances of Sightings*/
        }
    }
}
