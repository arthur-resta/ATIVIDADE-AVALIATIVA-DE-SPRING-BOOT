package com.resta.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resta.br.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}