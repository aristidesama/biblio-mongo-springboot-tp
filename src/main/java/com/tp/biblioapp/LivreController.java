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
public class LivreController{
private Logger logger = LoggerFactory.getLogger(LivreController.class);

@Autowired
private LivreRepository livreRepository;

@Autowired
private MongoTemplate mongoTemplate;


@GetMapping(value = "livre/")
public List<Livre> getAllLivres() {
   logger.info("Getting all livres.");
   return livreRepository.findAll();
}

@GetMapping(value =  "livre/{livreId}")
public Livre getLivreById(@PathVariable String livreId) {
   logger.info("Getting livre with ID: {}", livreId);
   return livreRepository.findLivreById(livreId);
}

@PostMapping({"livre/create", "/livre/create"})
//@PostMapping(value =  "livre/create")
//@PostMapping(value =["livre/create", "/livre/create"])
public Livre addLivre(@RequestBody Livre livre) {
   logger.info("Saving livre.");
   return livreRepository.save(livre);
}

    @PostMapping("livre/creates")
    public List<Livre> addLivres(@RequestBody List<Livre> livres) {
        return livreRepository.saveAll(livres);
    }

@PutMapping(value =  "livre/update/{livreId}")
public Livre updateLivre(@PathVariable String livreId, @RequestBody Livre livre) {
   logger.info("Updating livre with ID: {}", livreId);
   return livreRepository.save(livre);
}

@DeleteMapping(value =  "livre/delete/{livreId}")
public void deleteLivre(@PathVariable String livreId) {
   logger.info("Deleting livre with ID: {}", livreId);
   livreRepository.deleteById(livreId);
}

//-------------SPECIALS-----------

    @GetMapping("livre/auteurs")
    public List<String> getAllAuteurs() {
        return mongoTemplate.query(Livre.class)
                .distinct("auteurs")
                .as(String.class)
                .all();
    }

    @GetMapping("livre/genres")
    public List<String> getAllGenres() {
        return mongoTemplate.query(Livre.class)
                .distinct("genres")
                .as(String.class)
                .all();
    }

}


