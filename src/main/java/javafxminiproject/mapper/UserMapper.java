package main.java.javafxminiproject.mapper;

import main.java.javafxminiproject.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User toSingleModel(ResultSet result) throws SQLException {
        User user = new User(
                result.getInt("USER_ID"),
                result.getString("USERNAME"),
                result.getString("PASSWORD")
                );
        return user;
    }
}
