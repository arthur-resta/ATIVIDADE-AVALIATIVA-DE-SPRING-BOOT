package com.resta.br.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resta.br.entities.Animal;
import com.resta.br.repositories.AnimalRepository;

@Service
public class AnimalService {

	private final AnimalRepository animalrepository;

	public AnimalService(AnimalRepository animalrepository) {
		this.animalrepository = animalrepository;
	}

	public Animal getAnimalByid(Long id) {
		return animalrepository.findById(id).orElse(null);
	}

	public List<Animal> getTodosAnimal() {
		return animalrepository.findAll();
	}

	public Animal salvarAnimal(Animal animal) {
		return animalrepository.save(animal);
	}

	public void deleteAnimal(Long id) {
		animalrepository.deleteById(id);
	}
}