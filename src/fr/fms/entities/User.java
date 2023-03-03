package fr.fms.entities;

public class User {

	// declarations des attributs
	private int Id; 
	private String Login;
	private String Password;


	// Constructeur	 
	public User(int id, String login, String password) {
		super();
		Id = id;
		Login = login;
		Password = password;
	}


	// Getters et Setters	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}		 

}
