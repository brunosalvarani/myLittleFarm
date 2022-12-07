package main.java.javafxminiproject.repository;

import main.java.javafxminiproject.infra.database.ConnectionFactory;
import main.java.javafxminiproject.mapper.UserMapper;
import main.java.javafxminiproject.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {

    private static LoginRepository instance;

    public static LoginRepository getInstance(){
        if (instance == null){
            instance = new LoginRepository();
        }
        return instance;
    }

    public boolean create(User user){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSET INTO MY_USER(USER_ID, USERNAME, PASSWORD) VALUE(?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(String username){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM MY_USER WHERE USERNAME = ?";

        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet result = preparedStatement.executeQuery();
            user = UserMapper.toSingleModel(result);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }




}
