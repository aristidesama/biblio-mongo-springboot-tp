package com.tp.biblioapp;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuteurRepository extends MongoRepository<Auteur, String> {
 Auteur findAuteurById(String auteurId);
     Optional<Auteur> findByNom(String nom);
}

