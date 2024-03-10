package com.tp.biblioapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Auteur {


  @Id
  private String id;
  private String nom;
  private String nationalite;
  private List <String> livresPublie;



  public Auteur() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getNom() {return nom;}

  public void setNom(String nom) {this.nom = nom;}

  public String getNationalite() {return nationalite;}

  public void setNationalite(String nationalite) {this.nationalite = nationalite;}

  public List <String> getLivresPublie() {return livresPublie;}

  public void setLivresPublie(List <String> livresPublie) {this.livresPublie = livresPublie;}
  

}


