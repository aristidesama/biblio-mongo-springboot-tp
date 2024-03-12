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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;


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
public ResponseEntity<?> deleteEmprunt(@PathVariable String empruntId) {
   logger.info("Deleting emprunt with ID: {}", empruntId);

    Emprunt existingEmprunt = empruntRepository.findEmpruntById(empruntId);
    if (existingEmprunt == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La base ne contient pas d'Emprunt avec l'id : " + empruntId);
    }else {
      empruntRepository.deleteById(empruntId);
    }

   return ResponseEntity.status(HttpStatus.OK).body("Emprunt supprimé avec succès.");
}


    @GetMapping("/emprunt/search/user/{utilisateur}")
    public List<Emprunt> searchByUtilisateur(@PathVariable String utilisateur) {
        return empruntRepository.findByUtilisateur(utilisateur);
    }

/*
    @GetMapping("/emprunt/aggregated")
    public ResponseEntity<?> aggregateEmprunts(
            @RequestParam("date_periode_debut") String datePeriodeDebut,
            @RequestParam("date_periode_fin") String datePeriodeFin) {
        
        List<EmpruntAggregationResult> results = empruntRepository.aggregateEmprunts(datePeriodeDebut, datePeriodeFin);
        return ResponseEntity.ok(results);
    }*/

    @GetMapping("emprunt/statistics/")
    public List<Map> getEmpruntStatistics() {
        List<Map> result = mongoTemplate.aggregate(
            Aggregation.newAggregation(
                Aggregation.match(Criteria.where("dateEmp").gte("2024-03-02").lt("2024-03-30")),
                Aggregation.group("dateEmp").count().as("totalLivresEmpruntes"),
                Aggregation.sort(Sort.by("dateEmp"))
            ),
            Emprunt.class,
            Map.class
        ).getMappedResults();

        return result;
    }

}


