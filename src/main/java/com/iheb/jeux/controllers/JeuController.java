package com.iheb.jeux.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.iheb.jeux.entities.Jeu;
import com.iheb.jeux.service.JeuService;

@Controller
public class JeuController {
	@Autowired
	JeuService jeuService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createJeu";
	}
	
	@RequestMapping("/saveJeu")
	public String saveJeu(@ModelAttribute("jeu") Jeu jeu, 
							  @RequestParam("date") String date,
							  ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        jeu.setDateCreation(dateCreation);
      
		 Jeu saveJeu = jeuService.saveJeu(jeu);
		 String msg ="jeu enregistré avec Id "+saveJeu.getIdJeu();
		 modelMap.addAttribute("msg", msg);
		return "createJeu";
	}
	
	@RequestMapping("/ListeJeux")
	public String listeJeux(ModelMap modelMap)
	{
		List<Jeu> jx = jeuService.getAllJeux();
		modelMap.addAttribute("jeux", jx);		
		return "listeJeux";	
	}
	
	@RequestMapping("/supprimerJeu")
	public String supprimerJeu(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Jeu j= new Jeu();
		j.setIdJeu(id);
		jeuService.deleteJeu(j);
		List<Jeu> jx = jeuService.getAllJeux();
		modelMap.addAttribute("jeux", jx);	
		return "listeJeux";	
	}
	
	@RequestMapping("/modifierJeu")
	public String editerJeu(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Jeu j= 	jeuService.getJeu(id);
		modelMap.addAttribute("jeu", j);	
		return "editerProduit";	
	}

	@RequestMapping("/updateJeu")
	public String updateJeu(@ModelAttribute("jeu") Jeu jeu,
								@RequestParam("date") String date,
			                    ModelMap modelMap) throws ParseException 
	{
		
		//conversion de la date 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        jeu.setDateCreation(dateCreation);
        
		  jeuService.updateJeu(jeu);
		  List<Jeu> jx = jeuService.getAllJeux();
		  modelMap.addAttribute("jeux", jx);	
		
		return "listeJeux";
	}

	



}

