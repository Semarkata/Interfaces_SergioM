package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;


    public Connection getConnection(){
        String databaseName = "databasename";
        String databaseUser = "databaseUser";
        String databasePassword = "databasePassword";
        String url = "jdbc:mysql://path/" + databaseName;

        try {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }


}
