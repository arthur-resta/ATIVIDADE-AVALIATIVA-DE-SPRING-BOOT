package com.resta.br.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.resta.br.entities.Animal;
import com.resta.br.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
		Animal animal = animalService.getAnimalByid(id);
		if (animal != null) {
			return ResponseEntity.ok(animal);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<Animal> getAllAnimais() {
		return animalService.getTodosAnimal();
	}

	@PostMapping("/create")
	public Animal createAnimal(
			@RequestParam("nome") String nome,
			@RequestParam("tipo") String tipo,
			@RequestParam("raca") String raca,
			@RequestParam("idade") int idade,
			@RequestParam("sexo") String sexo,
			@RequestParam("tutornome") String tutornome,
			@RequestParam("foto") MultipartFile foto) throws IOException {

		byte[] imageBytes = foto.getBytes();
		Animal animal = new Animal();
		animal.setNome(nome);
		animal.setTipo(tipo);
		animal.setRaca(raca);
		animal.setIdade(idade);
		animal.setSexo(sexo);
		animal.setTutornome(tutornome);
		animal.setFoto(imageBytes);

		return animalService.salvarAnimal(animal);
	}
}
