package main.java.javafxminiproject.service;

import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.model.CheckUp;
import main.java.javafxminiproject.repository.CheckUpRepository;

public class CheckUpService {

    private static CheckUpService instance;
    private CheckUpRepository repository;

    private CheckUpService() {
        repository = CheckUpRepository.getInstance();
    }

    public static CheckUpService getInstance(){
        if (instance == null) {
            instance = new CheckUpService();
        }
        return instance;
    }

    private AnimalService animalService = AnimalService.getInstance();



    public boolean passCheckUpToRepository(CheckUp checkUp){
        Animal animal = animalService.findByTag(checkUp.getAnimalTag());
        if (animal != null){
            if (repository.saveCheckUp(checkUp)) {
                return true;
            }
        }
        return false;
    }

}
