package Models;

import org.sql2o.Sql2o;

public class DB {
    // uncomment to use locally
    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "njengabrayan","UBUNTU");


    // for use on deployed application
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-107-22-238-112.compute-1.amazonaws.com:5432/d1kgj8trcfoniq","ndzagjmiwxqfre","fc283c5a10f038e3e45e4fcbc032e1e6c18a9b19e1526783c993f7ab61ca69ce");

    // uri -  postgres://ndzagjmiwxqfre:fc283c5a10f038e3e45e4fcbc032e1e6c18a9b19e1526783c993f7ab61ca69ce@ec2-107-22-238-112.compute-1.amazonaws.com:5432/d1kgj8trcfoniq
}
