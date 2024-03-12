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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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

//@PostMapping(value = "auteur/create")
@PostMapping({"auteur/create", "/auteur/create"})
public Auteur addAuteur(@RequestBody Auteur auteur) {
   logger.info("Saving auteur.");
   return auteurRepository.save(auteur);
}

    @PostMapping("auteur/creates")
    public List<Auteur> addAuteurs(@RequestBody List<Auteur> auteurs) {
        return auteurRepository.saveAll(auteurs);
    }


@PutMapping(value = "auteur/update/{auteurId}")
public Auteur updateAuteur(@PathVariable String auteurId, @RequestBody Auteur auteur) {
   logger.info("Updating auteur with ID: {}", auteurId);
   return auteurRepository.save(auteur);
}

@PutMapping("auteur/updateSomeInfo/{nom}")
public ResponseEntity<?> updateAuteur(@PathVariable String nom, @RequestBody AuteurDto auteurDto) {

    Auteur existingAuteur = auteurRepository.findByNom(nom).orElse(null);
    if (existingAuteur == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Auteur not found with name: " + nom);
    }

    // Mettre à jour les champs de l'auteur avec les valeurs fournies dans le DTO
    existingAuteur.setNom(auteurDto.getNom());
    existingAuteur.setNationalite(auteurDto.getNationalite());
    existingAuteur.setLivresPublie(auteurDto.getLivresPublie());

    Auteur updatedAuteur = auteurRepository.save(existingAuteur);
    return ResponseEntity.ok(updatedAuteur);
}

@DeleteMapping(value = "auteur/delete/{auteurId}")
public void deleteAuteur(@PathVariable String auteurId) {
   logger.info("Deleting auteur with ID: {}", auteurId);
   auteurRepository.deleteById(auteurId);
}

@DeleteMapping(value =  "auteur/deleteByNom/{nom}")
public ResponseEntity<?> deleteAuteurByNom(@PathVariable String nom) {
   logger.info("Deleting auteur with title : {}", nom);

    Auteur existingAuteur = auteurRepository.findByNom(nom).orElse(null);
    //Auteur existingAuteur = auteurRepository.findByNom(nom);
    if (existingAuteur == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La base ne contient pas un Auteur du nom : " + nom);
    }else {
      auteurRepository.deleteById(existingAuteur.getId());
    }

   return ResponseEntity.status(HttpStatus.OK).body("Suppression avec succès de l'auteur : " + nom);
}




}


