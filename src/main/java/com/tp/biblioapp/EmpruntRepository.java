package com.tp.biblioapp;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpruntRepository extends MongoRepository<Emprunt, String> {
 Emprunt findEmpruntById(String empruntId);
 List<Emprunt> findByUtilisateur(String utilisateur);
}

