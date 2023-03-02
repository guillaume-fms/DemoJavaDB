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
	 private int Id; 
	 private String Description;
	 private String Brand;
	 private double Price;
	 
	 
	 // Constructeur
	 public Article(int Id, String Description, String Brand, double Price) {
			super();
			this.Id = Id;
			this.Description = Description;
			this.Brand = Brand;
			this.Price = Price;
		}
	 
	// Getters et Setters	 
	public int getId() {
		return Id;
		}

	public void setId(int Id) {
		this.Id = Id;
		}
	 
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String Brand) {
		this.Brand = Brand;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}

	
	
	
}
