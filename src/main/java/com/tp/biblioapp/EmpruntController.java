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
import org.springframework.data.mongodb.core.MongoTemplate;


@RestController
public class EmpruntController{
private Logger logger = LoggerFactory.getLogger(EmpruntController.class);

@Autowired
private EmpruntRepository empruntRepository;

@Autowired
private MongoTemplate mongoTemplate;


@GetMapping(value = "emprunt/")
public List<Emprunt> getAllEmprunts() {
   logger.info("Getting all emprunts.");
   return empruntRepository.findAll();
}

@GetMapping(value =  "emprunt/{empruntId}")
public Emprunt getEmpruntById(@PathVariable String empruntId) {
   logger.info("Getting emprunt with ID: {}", empruntId);
   return empruntRepository.findEmpruntById(empruntId);
}

@PostMapping(value =  "emprunt/create")
public Emprunt addEmprunt(@RequestBody Emprunt emprunt) {
   logger.info("Saving emprunt.");
   return empruntRepository.save(emprunt);
}


    @PostMapping("emprunt/creates")
    public List<Emprunt> addEmprunts(@RequestBody List<Emprunt> emprunts) {
        return empruntRepository.saveAll(emprunts);
    }


@PutMapping(value =  "emprunt/update/{empruntId}")
public Emprunt updateEmprunt(@PathVariable String empruntId, @RequestBody Emprunt emprunt) {
   logger.info("Updating emprunt with ID: {}", empruntId);
   return empruntRepository.save(emprunt);
}

@DeleteMapping(value =  "emprunt/delete/{empruntId}")
public void deleteEmprunt(@PathVariable String empruntId) {
   logger.info("Deleting emprunt with ID: {}", empruntId);
   empruntRepository.deleteById(empruntId);
}

    @GetMapping("/emprunt/search/user/{utilisateur}")
    public List<Emprunt> searchByUtilisateur(@PathVariable String utilisateur) {
        return empruntRepository.findByUtilisateur(utilisateur);
    }



}


