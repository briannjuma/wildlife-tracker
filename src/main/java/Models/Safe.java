// This class presents the template for animals of the invulnerable species type
package Models;

import org.sql2o.Connection;

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

    //save into database
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, type,health,age) VALUES(:name, :type,:health,:age)";
            this.id =(int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("type",this.type).addParameter("health", this.health).addParameter("age", this.age).executeUpdate().getKey();
        }
        catch (ClassCastException exc){

        }
    }
}
