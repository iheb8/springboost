package com.iheb.jeux;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iheb.jeux.entities.Jeu;
import com.iheb.jeux.service.JeuService;

@SpringBootApplication
public class JeuxApplication implements CommandLineRunner {
@Autowired
JeuService jeuService;
public static void main(String[] args) {
SpringApplication.run(JeuxApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
jeuService.saveJeu(new Jeu("Fifa 20", 260.0, new Date()));
jeuService.saveJeu(new Jeu("Gta V", 280.0, new Date()));
jeuService.saveJeu(new Jeu("Uncharted", 90.0, new Date()));
}
}
