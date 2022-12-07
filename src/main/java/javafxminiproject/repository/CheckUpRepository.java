package main.java.javafxminiproject.repository;

import main.java.javafxminiproject.infra.database.ConnectionFactory;
import main.java.javafxminiproject.model.CheckUp;
import main.java.javafxminiproject.service.AnimalService;
import main.java.javafxminiproject.utils.Converter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CheckUpRepository {
    /*
        To pass data towards the data base, check up table.
     */

    private static CheckUpRepository instance;

    private CheckUpRepository () {}

    public static CheckUpRepository getInstance() {
        if(instance == null){
            instance = new CheckUpRepository();
        }
        return instance;
    }

    public boolean saveCheckUp(CheckUp checkUp, int animalId) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CHECKUP(ANIMAL_ID, WEIGH, DESIGNATED_AREA, DATE_OF_CHECK_UP, DESCRIPTION) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,animalId);
            preparedStatement.setDouble(2,checkUp.getWeigh());
            preparedStatement.setString(3,checkUp.getDesignatedArea());
            preparedStatement.setDate(4, Converter.stringToDate(checkUp.getDateOfCheckUp()));
            preparedStatement.setString(5,checkUp.getDescription());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 //TODO change from getAll, to get the first 10 or 20, and either create
 // a second method to get the next 10 or 20, or make a method capable
 // of both tasks.
    public ResultSet getTenCheckUpFromSelectedAnimal(int animalId, int numberOfCheckUpsBeeingShown) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM CHECKUP WHERE ANIMAL_ID = ? ORDER BY (DATE_OF_CHECK_UP, CHECKUP_ID) DESC  LIMIT ?";

        ResultSet result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalId);
            preparedStatement.setInt(2, numberOfCheckUpsBeeingShown + 10);
            result = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
