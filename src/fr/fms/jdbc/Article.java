package fr.fms.jdbc;


/*
 *@author GuillaumePastor
 *@since Mardi 28/02/20230 à Vendredi 3/03/2023 
 *Exercice 2 :  Il s’agit maintenant d’afficher le contenu de votre table des articles sous
 *Eclipse aussi reprenez l’exemple vu en cours sans omettre d’ajouter le driver de mariaDB*
 *puis exécuter votre programme. La classe Article contient les mêmes données que la table
 *des articles en base, à savoir : identifiant, description, brand, price
 */



public class Article {

	// declarations des attributs
	 private int rsIdUser; 
	 private String rsDescription;
	 private String rsBrand;
	 private double rsPrice;
	 
	 
	 // Constructeur
	 
	 public Article(int rsIdUser, String rsDescription, String rsBrand, double rsPrice) {
			super();
			this.rsIdUser = rsIdUser;
			this.rsDescription = rsDescription;
			this.rsBrand = rsBrand;
			this.rsPrice = rsPrice;
		}
	 
	// Getters et Setters
	 
	public int getRsIdUser() {
			return rsIdUser;
		}

	public void setRsIdUser(int rsIdUser) {
			this.rsIdUser = rsIdUser;
		}
	 
	public String getRsDescription() {
		return rsDescription;
	}
	
	public void setRsDescription(String rsDescription) {
		this.rsDescription = rsDescription;
	}
	public String getRsBrand() {
		return rsBrand;
	}
	public void setRsBrand(String rsBrand) {
		this.rsBrand = rsBrand;
	}
	public double getRsPrice() {
		return rsPrice;
	}
	public void setRsPrice(double rsPrice) {
		this.rsPrice = rsPrice;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return rsIdUser;
	}
	
	
}
