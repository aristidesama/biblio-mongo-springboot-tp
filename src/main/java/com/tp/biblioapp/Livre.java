package com.tp.biblioapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Livre {


  @Id
  private String id;
  private String titre;
  private List <String> auteurs;
  private String anneePublication;
  private List <String> genres;
  private String quantiteDispo;



  public Livre() {}

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getTitre() {return titre;}

  public void setTitre(String titre) {this.titre = titre;}

  public List <String> getAuteurs() {return auteurs;}

  public void setAuteurs(List <String> auteurs) {this.auteurs = auteurs;}

  public List <String> getGenres() {return genres;}

  public void setGenres(List <String> genres) {this.genres = genres;}
  
  public String getAnneePublication() {return anneePublication;}

  public void setAnneePublication(String anneePublication) {this.anneePublication = anneePublication;}

  public String getQuantiteDispo() {return quantiteDispo;}

  public void setQuantiteDispo(String quantiteDispo) {this.quantiteDispo = quantiteDispo;}

}


