package com.tp.biblioapp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpruntRepository extends MongoRepository<Emprunt, String> {
 Emprunt findEmpruntById(String empruntId);
}

