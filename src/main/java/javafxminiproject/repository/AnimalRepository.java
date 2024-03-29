package main.java.javafxminiproject.repository;

import main.java.javafxminiproject.infra.database.ConnectionFactory;
import main.java.javafxminiproject.mapper.AnimalMapper;
import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.utils.Converter;

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

    public static AnimalRepository getInstance(){
        if (instance == null) {
            instance = new AnimalRepository();
        }
        return instance;
    }

    public boolean create(Animal animal) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO ANIMAL(TAG, PARENTTAG, BIRTHDATE, GENDER, RACE, ISNATIVE) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,animal.getTag());
            preparedStatement.setString(2,animal.getParentTag());
            preparedStatement.setDate(3, Converter.stringToDate(animal.getBirthDate()));
            preparedStatement.setString(4, animal.getGender());
            preparedStatement.setString(5,animal.getRace());
            preparedStatement.setString(6,animal.isIsNative() ? "Y" : "N");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Animal animal) {

        Connection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE ANIMAL SET TAG = ?, PARENTTAG = ?, BIRTHDATE = ?, GENDER = ?, RACE = ?, ISNATIVE = ? WHERE ANIMAL_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,animal.getTag());
            preparedStatement.setString(2,animal.getParentTag());
            preparedStatement.setDate(3, Converter.stringToDate(animal.getBirthDate()));
            preparedStatement.setString(4, animal.getGender());
            preparedStatement.setString(5,animal.getRace());
            preparedStatement.setString(6,animal.isIsNative() ? "Y" : "N");
            preparedStatement.setInt(7, animal.getAnimalId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
        Find the animal of a Given (String) tag.
     */
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
        String sql = "SELECT * FROM ANIMAL ORDER BY LENGTH(TAG), TAG";

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

    public void remove(int animalId) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM ANIMAL WHERE ANIMAL_ID = ?";

//        Animal animal = null; // never used ? of there is no need, should be removed

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalId);

            boolean result = preparedStatement.execute();
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Animal findById(int animalId) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ANIMAL WHERE ANIMAL_ID = ?";

        Animal animal = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalId);

            ResultSet result = preparedStatement.executeQuery();
            animal = AnimalMapper.toSingleModel(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
}
