// This template represents details recorded by rangers when they spot an animal
package Models;

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
}
