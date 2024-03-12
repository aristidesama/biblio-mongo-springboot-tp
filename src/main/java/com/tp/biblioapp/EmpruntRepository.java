package com.tp.biblioapp;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpruntRepository extends MongoRepository<Emprunt, String> {
 Emprunt findEmpruntById(String empruntId);
 List<Emprunt> findByUtilisateur(String utilisateur);

 /*
 @Query("{$match: {date_emp: {$gte: ?0, $lt: ?1}}}, "
            + "{$group: {_id: {$month: \"$date_emp\"}, totalLivresEmpruntes: {$sum: 1}}}, "
            + "{$sort: {_id: 1}}")
    List<EmpruntAggregationResult> aggregateEmprunts(String datePeriodeDebut, String datePeriodeFin);
 */


}

