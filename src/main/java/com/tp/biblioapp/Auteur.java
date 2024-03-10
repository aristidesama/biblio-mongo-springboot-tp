package com.tp.biblioapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Auteur {


  @Id
  private String id;
  private String nom;
  private String nationalite;
  private String livresPublie;



  public Auteur() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getNom() {return nom;}

  public void setNom(String nom) {this.nom = nom;}

  public String getNationalite() {return nationalite;}

  public void setNationalite(String nationalite) {this.nationalite = nationalite;}

  public String getLivresPublie() {return livresPublie;}

  public void setLivresPublie(String livresPublie) {this.livresPublie = livresPublie;}

}


