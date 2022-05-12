// This is an Abstract class that extends both endangered and safe species.

package Models;
import org.sql2o.Connection;


public abstract class Animal {
    //fields
    public String name;
    public String type;
    public int id;

    //getters
    public String getName(){ return name;}
    public String getType(){ return type;}
    public int getId() {return id;}

    //save animals to database
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            //this- object being added,retrieve properties
            //create object,connect into database,execute query statement,update existing fields,retrieve primary key
            this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter(type,this.type).executeUpdate().getKey();
        }

    }

}
