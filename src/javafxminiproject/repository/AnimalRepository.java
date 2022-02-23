package javafxminiproject.repository;

import javafxminiproject.infra.database.ConnectionFactory;
import javafxminiproject.mapper.AnimalMapper;
import javafxminiproject.model.Animal;
import javafxminiproject.utils.Converter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    /*
        to pass data towards the database
     */

    private static AnimalRepository instance;

    private AnimalRepository () {}

    public static AnimalRepository getInstance(){
        if (instance == null) {
            instance = new AnimalRepository();
        }
        return instance;
    }



    public boolean create(Animal animal) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO ANIMAL(TAG, PARENTTAG, BIRTHDATE, RACE, ISNATIVE, WEIGHT) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,animal.getTag());
            preparedStatement.setString(2,animal.getParentTag());
            preparedStatement.setDate(3, Converter.stringToDate(animal.getBirthDate()));
            preparedStatement.setString(4,animal.getRace());
            preparedStatement.setString(5,animal.isIsNative() ? "Y" : "N");
            preparedStatement.setDouble(6,animal.getWeight());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Animal animal) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE ANIMAL SET TAG = ?, PARENTTAG = ?, BIRTHDATE = ?, RACE = ?, ISNATIVE = ?, WEIGHT = ? WHERE ANIMAL_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,animal.getTag());
            preparedStatement.setString(2,animal.getParentTag());
            preparedStatement.setDate(3, Converter.stringToDate(animal.getBirthDate()));
            preparedStatement.setString(4,animal.getRace());
            preparedStatement.setString(5,animal.isIsNative() ? "Y" : "N");
            preparedStatement.setDouble(6,animal.getWeight());
            preparedStatement.setInt(7, animal.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Animal findByTag(String tag) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ANIMAL WHERE TAG = ?";

        Animal animal = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tag);

            ResultSet result = preparedStatement.executeQuery();
            animal = AnimalMapper.toSingleModel(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public List<Animal> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ANIMAL";

        List<Animal> animalList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet result = preparedStatement.executeQuery();
            animalList = AnimalMapper.toModelList(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animalList;
    }

    public Animal remove(int animal_id) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM ANIMAL WHERE ANIMAL_ID = ?";

        Animal animal = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animal_id);

            ResultSet result = preparedStatement.executeQuery();
            animal = AnimalMapper.toSingleModel(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animal;
    }

    public Animal findByID(int tag) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ANIMAL WHERE TAG = ?";

        Animal animal = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tag);

            ResultSet result = preparedStatement.executeQuery();
            animal = AnimalMapper.toSingleModel(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
}
