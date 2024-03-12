package com.tp.biblioapp;

import java.util.List;

public class AuteurDto {


  private String id;
  private String nom;
  private String nationalite;
  private List <String> livresPublie;



  public AuteurDto() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getNom() {return nom;}

  public void setNom(String nom) {this.nom = nom;}

  public String getNationalite() {return nationalite;}

  public void setNationalite(String nationalite) {this.nationalite = nationalite;}

  public List <String> getLivresPublie() {return livresPublie;}

  public void setLivresPublie(List <String> livresPublie) {this.livresPublie = livresPublie;}
  

}


