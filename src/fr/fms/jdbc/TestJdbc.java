package fr.fms.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 *@author GuillaumePastor
 *@since Mardi 28/02/20230 à Vendredi 3/03/2023 
 *Exercice 2 :  Il s’agit maintenant d’afficher le contenu de votre table des articles sous
 *Eclipse aussi reprenez l’exemple vu en cours sans omettre d’ajouter le driver de mariaDB*
 *puis exécuter votre programme. La classe Article contient les mêmes données que la table
 *des articles en base, à savoir : identifiant, description, brand, price
 */

public class TestJdbc {

	public static void main(String[] args) throws Exception {
		ArrayList<Article> articles = new ArrayList<Article>(); 

		try {
			// Sert à charger le pilote
			Class.forName("org.mariadb.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {

		}

		// Récupérer une connection à partir d'une url + id + pwd
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2023";

		// Connection de java.sql
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			
		// Une fois connecté, réalisation d'une requête	
		String strSql = "SELECT * FROM T_Articles";
		//String strSql = "INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES('Laptop_Portable', 'DELL', 1380)";
		//String strSql = "UPDATE t_articles SET description ='Joystick', brand='Nintendo', UnitaryPrice='135' WHERE IdArticle=1";
	    //String strSql = "DELETE FROM t_articles WHERE IdArticle=15";
		//String strSql = "SELECT idarticle,t_articles.description,brand,unitaryprice,"
				//+ "catname FROM t_articles INNER JOIN t_categories WHERE"
				//+ " t_articles.idcategory = t_categories.idcategory and idarticle=1";
			
			try(Statement statement = connection.createStatement()){
				// ResultSet de java.sql
				try(ResultSet resultSet = statement.executeQuery(strSql)){
					while(resultSet.next()) {
						// Index (de 1 à n) de la colonne, soit le nom de la colonne
						int rsIdUser = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						double rsPrice = resultSet.getDouble(4);
						articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
					}
				}	
			}

			for(Article a : articles) 
				System.out.println(a.getId() + " - " + a.getRsDescription() + " - " + a.getRsBrand() + " - " 
						+ a.getRsPrice());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}	











