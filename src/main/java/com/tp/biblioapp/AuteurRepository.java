package com.tp.biblioapp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuteurRepository extends MongoRepository<Auteur, String> {
 Auteur findAuteurById(String auteurId);
}

