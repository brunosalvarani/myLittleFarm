package main.java.javafxminiproject.mapper;

import main.java.javafxminiproject.model.CheckUp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckUpMapper {

    public static List<CheckUp> toModelListWithId(ResultSet result, String animalTag) throws SQLException {
        List<CheckUp> modelList = new ArrayList<>();
        while(result.next()){
            CheckUp checkUp = new CheckUp(
                    result.getInt("CHECKUP_ID"),
                    result.getInt("ANIMAL_ID"),
                    result.getDouble("WEIGH"),
                    result.getString("DESIGNATED_AREA"),
                    result.getString("DATE_OF_CHECK_UP"),
                    result.getString("DESCRIPTION"));
            modelList.add(checkUp);
        }
        return modelList;
    }
}
