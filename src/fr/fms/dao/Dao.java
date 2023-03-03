package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao<T>{
	public Connection connection = BddConnection.getConnection();
	
	// Ajout d'une nouvelle occurence en base de données
	public void create(T obj);
	
	// Renvoi un objet correspondant à l'ID en base de données
	public T read(int id);
	
	// Met à jour l'objet en base, renvoi vrai si c'est fait
	public boolean update(T obj);
	
	// Supprime un objet en base, renvoi vrai si c'est fait
	public boolean delete(T obj);
	
	// Renvoi tous les objets de la table correspondante
	public ArrayList<T> readAll();
		
}
