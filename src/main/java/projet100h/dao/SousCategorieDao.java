package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import projet100h.pojos.SousCategorie;



public class SousCategorieDao {
	
	 public List<SousCategorie> listeSousCategories() {
	        List<SousCategorie> listeSousCategories = new ArrayList<SousCategorie>();
	        try {
	            // Créer une nouvelle connexion à la BDD
	            Connection connection = DataSourceProvider.getDataSource().getConnection();

	            // Utiliser la connexion
	            Statement stmt = connection.createStatement();
	            ResultSet results = stmt.executeQuery("SELECT * FROM souscategorie");
	            while (results.next()) {


	                //Récupération des paramètres
	                listeSousCategories.add(new SousCategorie(
	                                results.getInt("idsouscat"),
	                                results.getString("nom"),
	                                
	                                results.getInt("idcat")

	                        )
	                );
	            }
	            //ferme la connexion
	            stmt.close();

	        } catch (

	                SQLException e)

	        {

	            e.printStackTrace();
	        }
	        return listeSousCategories;
	    }
	
	public SousCategorie getSousCategorie(Integer id) {
		SousCategorie SousCategorie = null;
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM souscategorie WHERE idsouscategorie=? ");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				SousCategorie = new SousCategorie(
						resultSet.getInt("idsouscategorie"), 
						resultSet.getString("nom"),
						resultSet.getInt("idcat")
						
						
						
						);
			}			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SousCategorie;
	}
	
	public void updatesouscategorie(Integer idsouscategorie, String nom, Integer idcat		
			) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE souscategorie SET nom='"+nom+"', idcat='"+idcat+"' WHERE idsouscategorie= '"+idsouscategorie+"' ")){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/*public SousCategorie addSousCategories(SousCategorie SousCategories) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `souscategorie`(`nom`)VALUES(?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, SousCategories.getNom());
			
			
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SousCategories;
	}*/

}
