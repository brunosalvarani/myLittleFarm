package main.java.javafxminiproject.mapper;

import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.utils.Converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalMapper { // TODO create a test
    public static List<Animal> toModelList(ResultSet result) throws SQLException {
        List<Animal> modelList = new ArrayList<>();
        while(result.next()){
            Animal animal = new Animal(
                    result.getString("TAG"),
                    result.getString("PARENTTAG"),
                    result.getString("BIRTHDATE"),
                    result.getString("GENDER"),
                    result.getString("RACE"),
                    Converter.stringToBoolean(result.getString("ISNATIVE")));
            modelList.add(animal);
        }
        return modelList;
    }

    public static Animal toSingleModel (ResultSet result) throws SQLException {
        List<Animal> animalList = toModelList(result);
        if(!animalList.isEmpty()){
            return animalList.get(0);
        }
        return null;
    }
}
