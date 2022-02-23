package javafxminiproject.service;

import javafxminiproject.model.Animal;
import javafxminiproject.repository.AnimalRepository;
import javafxminiproject.service.exception.EntityNotFoundException;

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

    public void checkAndRemoveAnimalByID(int animalId) throws EntityNotFoundException {
        if(repository.findById(animalId) == null){
            throw new EntityNotFoundException();
        }
        repository.remove(animalId);
    }

    /*
        TODO implementar metodos do repository findAll, update
     */

}
