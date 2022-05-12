package Models;

import org.sql2o.Sql2o;

public class DB {

    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "njengabrayan","UBUNTU");
    static String connectionString = "jdbc:postgresql://ec2-54-161-239-198.compute-1.amazonaws.com:5432/d444grvd7afi2t";
    public static Sql2o sql2o = new Sql2o(connectionString,"fmgziuifsihprh","22d8b32aa822c86495478bfb5ed1c6f314179253de443e3ee21295e3fbeaae82");

}
