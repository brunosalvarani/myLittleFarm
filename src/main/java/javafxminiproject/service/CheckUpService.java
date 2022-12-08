package main.java.javafxminiproject.service;

import main.java.javafxminiproject.mapper.CheckUpMapper;
import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.model.CheckUp;
import main.java.javafxminiproject.repository.CheckUpRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CheckUpService {

    private static CheckUpService instance;
    private CheckUpRepository repository = CheckUpRepository.getInstance();
        private AnimalService animalService = AnimalService.getInstance();

    public static CheckUpService getInstance(){
        if (instance == null) {
            instance = new CheckUpService();
        }
        return instance;
    }



    public boolean passCheckUpToRepository(CheckUp checkUp, String animalTag){
        Animal animal = animalService.findByTag(animalTag);
        if (animal != null){
            return repository.saveCheckUp(checkUp, animal.getAnimalId());
        }
        return false;
    }

    public List<CheckUp> getCheckUpsFromSelectedAnimal(String animalTag, int numberOfCheckUpsBeeingShown){
        ResultSet checkUps = repository.getTenCheckUpFromSelectedAnimal(animalService.findByTag(animalTag).getAnimalId(), numberOfCheckUpsBeeingShown);
        try {
            return CheckUpMapper.toModelListWithId(checkUps, animalTag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
