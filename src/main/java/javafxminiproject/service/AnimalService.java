package main.java.javafxminiproject.service;

import main.java.javafxminiproject.model.Animal;
import main.java.javafxminiproject.repository.AnimalRepository;
import main.java.javafxminiproject.service.exception.EntityNotFoundException;

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

    public Animal updateAnimal(Animal animal){
        if(repository.update(animal)) {
            return repository.findById(animal.getAnimalId());
        }
        return null;
    }

    public Animal addAnimal (Animal animal) {
        if(repository.create(animal)) {
            return repository.findByTag(animal.getTag());
        }
        return null;
    } // TODO it shouldn't be possible to have two active animals with the same tag

    public void checkAndRemoveAnimalByTag(String animalTag) throws EntityNotFoundException {
        Animal toBeRemoved = repository.findByTag(animalTag);
        if(toBeRemoved == null){
            throw new EntityNotFoundException();
        }
        repository.remove(toBeRemoved.getAnimalId());
    } //TODO if there is two animals with the same tag, wich one should be removed ?


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
}
