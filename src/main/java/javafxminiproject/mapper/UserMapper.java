package main.java.javafxminiproject.mapper;

import main.java.javafxminiproject.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<User> toModelList(ResultSet result) throws SQLException {
        List<User> modelList = new ArrayList<>();
        while (result.next()){
            User user = new User(
                    result.getInt("USER_ID"),
                    result.getString("USERNAME"),
                    result.getString("PASSWORD")
            );
            modelList.add(user);
        }
        return modelList;
    }

    public static User toSingleModel(ResultSet result) throws SQLException {
//        return new User(
//                result.getInt("USER_ID"),
//                result.getString("USERNAME"),
//                result.getString("PASSWORD")
//                );
        List<User> modelList = toModelList(result);
        if(!modelList.isEmpty()){
            return modelList.get(0);
        }
        return null;
    }
}
