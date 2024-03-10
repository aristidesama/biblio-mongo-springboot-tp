package com.tp.biblioapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Emprunt {


  @Id
  private String id;
  private String livre;
  private String utilisateur;
  private String date_emp;
  private String date_retour;
  private String date_effect;



  public Emprunt() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getLivre() {return livre;}

  public void setLivre(String livre) {this.livre = livre;}

  public String getUtilisateur() {return utilisateur;}

  public void setUtilisateur(String utilisateur) {this.utilisateur = utilisateur;}

  public String getDateEmp() {return date_emp;}

  public void setDateEmp(String date_emp) {this.date_emp = date_emp;}


  public String getDateRetour() {return date_retour;}

  public void setDateRetour(String date_retour) {this.date_retour = date_retour;}

  public String getDateEffect() {return date_effect;}

  public void setDateEffect(String date_effect) {this.date_effect = date_effect;}


}


