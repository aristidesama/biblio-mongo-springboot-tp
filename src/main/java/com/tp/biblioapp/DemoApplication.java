package com.tp.biblioapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
//@Import(AuteurController.class)
public class DemoApplication {


    @GetMapping("/")
    public String home() {
        return """
Pour informations et/ou opérations sur :

- Les livres, consulter : livre/
- Les auteurs, consulter : auteur/
- Les emprunts, consulter : emprunt/
            """;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
