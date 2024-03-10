package com.tp.biblioapp;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AuteurController{
private Logger logger = LoggerFactory.getLogger(AuteurController.class);

@Autowired
private AuteurRepository auteurRepository;

@GetMapping(value = "auteur/")
public List<Auteur> getAllAuteurs() {
   logger.info("Getting all auteurs.");
   return auteurRepository.findAll();
}

@GetMapping(value = "auteur/{auteurId}")
public Auteur getAuteurById(@PathVariable String auteurId) {
   logger.info("Getting auteur with ID: {}", auteurId);
   return auteurRepository.findAuteurById(auteurId);
}

@PostMapping(value = "auteur/create")
public Auteur addAuteur(@RequestBody Auteur auteur) {
   logger.info("Saving auteur.");
   return auteurRepository.save(auteur);
}

@PutMapping(value = "auteur/update/{auteurId}")
public Auteur updateAuteur(@PathVariable String auteurId, @RequestBody Auteur auteur) {
   logger.info("Updating auteur with ID: {}", auteurId);
   return auteurRepository.save(auteur);
}

@DeleteMapping(value = "auteur/delete/{auteurId}")
public void deleteAuteur(@PathVariable String auteurId) {
   logger.info("Deleting auteur with ID: {}", auteurId);
   auteurRepository.deleteById(auteurId);
}


}


