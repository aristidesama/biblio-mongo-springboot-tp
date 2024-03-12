package com.tp.biblioapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Date;

@Document
public class Emprunt {


  @Id
  private String id;
  private String livre;
  private String utilisateur;
  //private Date date_emp;
  //private String date_emp;
  private String dateEmp;
  //private Date date_retour;
  //private String date_retour;
  private String dateRetour;
  //private Date date_effect;
  //private String date_effect;
  private String dateEffect;



  public Emprunt() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getLivre() {return livre;}

  public void setLivre(String livre) {this.livre = livre;}

  public String getUtilisateur() {return utilisateur;}

  public void setUtilisateur(String utilisateur) {this.utilisateur = utilisateur;}

  //public Date getDateEmp() {return date_emp;}
  public String getDateEmp() {return dateEmp;}

  //public void setDateEmp(Date date_emp) {this.date_emp = date_emp;}
  public void setDateEmp(String dateEmp) {this.dateEmp = dateEmp;}


  //public Date getDateRetour() {return date_retour;}
  public String getDateRetour() {return dateRetour;}

  //public void setDateRetour(Date date_retour) {this.date_retour = date_retour;}
  public void setDateRetour(String dateRetour) {this.dateRetour = dateRetour;}

  //public Date getDateEffect() {return date_effect;}
  public String getDateEffect() {return dateEffect;}

  //public void setDateEffect(Date date_effect) {this.date_effect = date_effect;}
  public void setDateEffect(String dateEffect) {this.dateEffect = dateEffect;}


}


