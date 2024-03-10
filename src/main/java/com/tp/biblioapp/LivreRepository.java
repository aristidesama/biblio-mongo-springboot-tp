package com.tp.biblioapp;

//import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface LivreRepository extends MongoRepository<Livre, String> {
 Livre findLivreById(String livreId);
}

