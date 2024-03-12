package com.tp.biblioapp;
import java.util.List;

//import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface LivreRepository extends MongoRepository<Livre, String> {
 Livre findLivreById(String livreId);
 List<Livre> findByGenres(String genres);
 List<Livre> findByAuteurs(String auteurs);
 Livre findByTitre(String titre);

}

