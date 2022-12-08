package main.java.javafxminiproject.service;

import main.java.javafxminiproject.model.User;
import main.java.javafxminiproject.repository.LoginRepository;

public class LoginService {
    private static LoginService instance;
    private static LoginRepository repositoryInstance = LoginRepository.getInstance();

    public static LoginService getInstance(){
        if (instance == null){
            instance = new LoginService();
        }
        return instance;
    }

    public int validateLogin(User user){
        User userFromRepository = repositoryInstance.getUser(user.getUsername());
        if (userFromRepository != null){
            if (user.getPassword().equals(userFromRepository.getPassword())){
                return 0;
            }
            return -1;
        }
        return -2;
    }
}
