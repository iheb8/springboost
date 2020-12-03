package com.iheb.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iheb.jeux.entities.Jeu;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

}
