OPÉRATIONS CRUD
----------------------

1.	Création des scripts pour insérer de nouveaux
-	Livres (test du insert many)
Request URL - POST : http://localhost:8080/livre/creates
Request Body : 
[
    {
        "titre": "Les Misérables",
        "auteurs": ["Victor Hugo"],
        "anneePublication": 1862,
        "genres": ["Roman historique"],
        "quantiteDispo": 15
    },
    {
        "titre": "Harry Potter and the Philosopher's Stone",
        "auteurs": ["J.K. Rowling"],
        "anneePublication": 1997,
        "genres": ["Fantasy", "Young adult"],
        "quantiteDispo": 20
    }
]


Méthode du contrôleur:
...
    @PostMapping("livre/creates")
    public List<Livre> addLivres(@RequestBody List<Livre> livres) {
        return livreRepository.saveAll(livres);
    }
...

-	Auteurs (test du insert many)
Request URL - POST : http://localhost:8080/auteur/creates
Request Body : 
[
    {
        "nom": "John Doe",
        "dateNaissance": "1985-07-15",
        "nationalite": "American",
        "livresPublie": ["The Great Adventure", "Journey to the Unknown"]
    },
    {
        "nom": "Alice Smith",
        "dateNaissance": "1990-04-25",
        "nationalite": "British",
        "livresPublie": ["Secrets of the Mind", "Lost in Wonderland"]
    }
]

Méthode du contrôleur:
...
    @PostMapping("auteur/creates")
    public List<Auteur> addAuteurs(@RequestBody List<Auteur> auteurs) {
        return auteurRepository.saveAll(auteurs);
    }
...
-	Emprunt (test du insert many)
Request URL - POST : http://localhost:8080/emprunt/creates
Request Body : 
[
    {
        "livre": "Le petit prince",
        "utilisateur": "juliette",
        "date_emp": "2023-09-20T00:00:00Z",
        "date_retour": "2023-10-05T00:00:00Z",
        "date_effect": "2023-10-06T00:00:00Z"
    },
    {
        "livre": "Harry Potter and the Philosopher's Stone",
        "utilisateur": "thomas",
        "date_emp": "2024-01-15T00:00:00Z",
        "date_retour": "2024-02-29T00:00:00Z",
        "date_effect": "2024-03-01T00:00:00Z"
    }
]

Méthode du contrôleur:
...
    @PostMapping("emprunt/creates")
    public List<Emprunt> addEmprunts(@RequestBody List<Emprunt> emprunts) {
        return empruntRepository.saveAll(emprunts);
    }
...

2.	Lire les données
-	Trouver tous les livres d'un genre spécifique « fiction »
db.livres.find({ genres: "fiction" })

Request URL - GET * http://localhost:8080/livre/search/genre/fiction
Methode du contrôleur
...
    @GetMapping("/livre/search/genre/{genres}")
    public List<Livre> searchByGenres(@PathVariable String genres) {
        return livreRepository.findByGenres(genres);
    }
...


-	Lister tous les livres d'un auteur donné.
db.livres.find({ auteurs: "Bob" })
Request URL - GET * http://localhost:8080/livre/search/auteur/Bob
Methode du contrôleur
...
    @GetMapping("/livre/search/auteur/{auteurs}")
    public List<Livre> searchByAuteurs(@PathVariable String auteurs) {
        return livreRepository.findByAuteurs(auteurs);
    }
...

-	Afficher l'historique des emprunts pour un utilisateur « michi ».
db.emprunts.find({ utilisateur: "michi" })

Request URL - GET * http://localhost:8080/emprunt/search/user/michi
Methode du contrôleur
...
    @GetMapping("/emprunt/search/user/{utilisateur}")
    public List<Emprunt> searchByUtilisateur(@PathVariable String utilisateur) {
        return empruntRepository.findByUtilisateur(utilisateur);
    }
...

3.	Mettre à jour les données
-	Mettre à jour la quantité disponible d'un livre après un emprunt ou un retour « la poule et le chien » : 
db.livres.updateOne( { titre: "la poule et le chien" }, { $inc: { quantiteDispo: -1 } } )

-	Modifier les informations d'un auteur « bob » :
db.auteurs.updateOne( { nom: "bob" }, { $set: { dateNaissance: new Date("1980-01-01") } } )

4.	Supprimer des documents
-	Supprimer un emprunt après le retour du livre :
db.emprunts.deleteOne({ _id: ObjectId("65ec8800993f42b181b17adb") })

-	Supprimer un auteur de la base de données
db.auteurs.deleteOne({ nom: "bob" })

-	Supprimer un livre de la base de données
db.livres.deleteOne({ titre: "Le petit prince" })

VI.	PARTIE 3 : REQUÊTES AVANCÉES
1.	Agrégation 
Nous allons maintenant utiliser les opérations d'agrégation pour calculer le nombre total de livres empruntés par mois.

db.emprunts.aggregate([ { $match: { date_emp: { $gte: ISODate("2024-03-04"), $lt: ISODate("2024-04-19") } } }, { $group: { _id: { $month: "$date_emp" }, totalLivresEmpruntes: { $sum: 1 } } }, { $sort: { _id: 1 } }] )

2.	Indexation : 
créer un nouvel index dans la collection "livres"
-	Auteurs
db.livres.createIndex({ auteurs: 1 })
-	Titre
db.livres.createIndex({ titre: "text" })
3.	Text Search : 
db.livres.find({ $text: { $search: "amour" } })
