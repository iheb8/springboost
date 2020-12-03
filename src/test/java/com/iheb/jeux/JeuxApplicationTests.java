package com.iheb.jeux;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iheb.jeux.entities.Jeu;
import com.iheb.jeux.repos.JeuRepository;

@SpringBootTest
class JeuxApplicationTests {
	@Autowired
	private JeuRepository JeuRepository;
	@Test
	public void testCreateJeu() {
	Jeu j = new Jeu("Fifa",200.000,new Date());
	JeuRepository.save(j);
	}
	@Test
	public void testFindJeu()
	{
	Jeu je = JeuRepository.findById(1L).get();
	System.out.println(je);
	
	}
	@Test
	public void testUpdateJeu()
	{
	Jeu j = JeuRepository.findById(1L).get();
	j.setPrixJeu(100.0);
	JeuRepository.save(j);
	
	System.out.println(j);
	}
	
	@Test
	public void testDeleteJeu()
	{
		JeuRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAlljeux()
	{
		List<Jeu> jx = JeuRepository.findAll();
		
		for (Jeu j:jx)
			 System.out.println(j);
		
	}
	

}
