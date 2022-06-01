package javafxminiproject.service;

import javafxminiproject.model.Animal;
import javafxminiproject.repository.AnimalRepository;
import javafxminiproject.service.exception.EntityNotFoundException;

import java.util.List;

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

    public void checkAndRemoveAnimalByTag(String animalTag) throws EntityNotFoundException {
        if(repository.findByTag(animalTag) == null){
            throw new EntityNotFoundException();
        }
        repository.remove(findByTag(animalTag).getAnimalId());
    }//TODO findByTag returns animal


    public void checkAndRemoveAnimalByID(int animalId) throws EntityNotFoundException {
        if(repository.findById(animalId) == null){
            throw new EntityNotFoundException();
        }
        repository.remove(animalId);
    }

    public Animal findByTag(String tag) {
        return repository.findByTag(tag);
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    /*
        TODO implementar metodos do repository findAll, update
     */

}
