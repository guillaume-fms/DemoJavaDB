package fr.fms.sgbd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.entities.Article;
import fr.fms.entities.User;

/*
 *@author GuillaumePastor
 *@since Jeudi 2/03/20230 à Vendredi 3/03/2023 
 *Exercice 4 : Nous souhaitons dorénavant utiliser un fichier de configuration unique
 *contenant toutes les informations de connexion. En effet, afin de rendre notre application
 *ouverte aux évolutions notamment lorsqu’il s’agit de migrer d’un SGBD à un autre sans
 *avoir à toucher au code source, un fichier de configuration contiendra toutes les
 *informations nécessaires comme ici.
 */




public class CreateConfigFile {

	public static void main(String[] args) throws IOException {
		ArrayList<Article> articles = new ArrayList<Article>();
		ArrayList<User> users = new ArrayList<User>();
		Properties prop = readPropertiesFile("files/conf.properties");
		String login = prop.getProperty("db.login");
		String password = prop.getProperty("db.password");
		String url = prop.getProperty("db.url");
		String driver = prop.getProperty("db.driver.class");
		System.out.println(login +"\n" + password +"\n" + url +"\n" + driver);
		System.out.println();
		try {
			// Sert à charger le pilote
			Class.forName(driver);
		}
		catch(ClassNotFoundException e) {

		}

		// Connection de java.sql
		try(Connection connection = DriverManager.getConnection(url, login, password)){			
			// Une fois connecté, réalisation d'une requête	
			String strSql = "SELECT * FROM T_Users";
			//String strSql1 = "INSERT INTO t_users (IdUser, Login, Password) VALUES(10,'Johnson', 'Boris')";
			try(Statement statement = connection.createStatement()){
				// ResultSet de java.sql
				try(ResultSet resultSet = statement.executeQuery(strSql)){
					while(resultSet.next()) {
						// Index (de 1 à n) de la colonne, soit le nom de la colonne
						//int rsIdUser = resultSet.getInt(1);
						//String rsDescription = resultSet.getString(2);
						//String rsBrand = resultSet.getString(3);
						//double rsPrice = resultSet.getDouble(4);
						//articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
						int rsId = resultSet.getInt(1);
						String rsLogin = resultSet.getString(2);
						String rsPassword = resultSet.getString(3);
						users.add((new User(rsId, rsLogin, rsPassword)));
					}
				}	
			}
				// Affichage de tous les articles
			//for(Article a : articles) 
			//	System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " 
			//			+ a.getPrice());
			
			// Affichage de tous les users
			for(User u : users) 
				System.out.println(u.getId() + " - " + u.getLogin() + " - " + u.getPassword());
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {

			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
}


