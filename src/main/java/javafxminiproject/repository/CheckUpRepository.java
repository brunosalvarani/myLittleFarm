package main.java.javafxminiproject.repository;

import main.java.javafxminiproject.infra.database.ConnectionFactory;
import main.java.javafxminiproject.model.CheckUp;
import main.java.javafxminiproject.service.AnimalService;
import main.java.javafxminiproject.utils.Converter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckUpRepository {
    /*
        To pass data towards the data base, check up table.
     */

    private static CheckUpRepository instance;
    private final AnimalService animalService = AnimalService.getInstance();

    private CheckUpRepository () {}

    public static CheckUpRepository getInstance() {
        if(instance == null){
            instance = new CheckUpRepository();
        }
        return instance;
    }

    public boolean saveCheckUp(CheckUp checkUp) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CHECKUP(ANIMAL_ID, WEIGH, DESIGNATED_AREA, DATE_OF_CHECK_UP, DESCRIPTION) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,animalService.findByTag(checkUp.getAnimalTag()).getAnimalId());
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
}
