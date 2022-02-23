package javafxminiproject.service;

import javafxminiproject.model.Animal;
import javafxminiproject.repository.AnimalRepository;

public class AnimalService {

    private static AnimalService instance;
    private AnimalRepository repository;

    private AnimalService() {
        repository = AnimalRepository.getInstance();
    }
    public static AnimalService getInstance(){
        if (instance == null) {
            instance = new AnimalService();
        }
        return instance;
    }


    public Animal addAnimal (Animal animal) {
        if (repository.create(animal)) {
            return repository.findByTag(animal.getTag());
        }
        return null;
    }

    public Animal removeAnimalByID(int animal_id) {
        if (repository.remove(animal_id) != null){
            return repository.findByID(animal_id);
        }
        return null;
    }

    /*
        TODO implementar metodos do repository findAll, update
     */

}
