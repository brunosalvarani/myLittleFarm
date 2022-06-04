package main.java.javafxminiproject.infra.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/myFarm","postgres","tere2012");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
