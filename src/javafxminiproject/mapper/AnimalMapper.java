package javafxminiproject.mapper;

import javafxminiproject.model.Animal;
import javafxminiproject.utils.Converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalMapper {
    public static List<Animal> toModelList(ResultSet result) throws SQLException {
        List<Animal> modelList = new ArrayList<>();
        while(result.next()){
            Animal animal = new Animal(
                    result.getInt("ANIMAL_ID"),
                    result.getString("TAG"),
                    result.getString("PARENTTAG"),
                    result.getString("BIRTHDATE"),
                    result.getString("RACE"),
                    Converter.stringToBoolean(result.getString("ISNATIVE")),
                    result.getDouble("WEIGHT"));
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
