package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import projet100h.pojos.Informations;
import projet100h.pojos.Prestation;



public class PrestationDao {
	
	public List<Prestation> listPrestation() {
		List<Prestation> Prestation = new ArrayList<Prestation>();

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM prestation ")) {
			while (resultSet.next()) {
				Prestation.add(new Prestation(resultSet.getInt("idPrestation"),resultSet.getString("nom"),resultSet.getString("description"),resultSet.getString("prix"),resultSet.getInt("idsouscat")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return Prestation;
	}
	
	public Prestation getPrestation(Integer id) {
		Prestation Prestation = null;
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM prestation WHERE idPrestation=? ");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				Prestation = new Prestation(
						resultSet.getInt("idPrestation"), 
						resultSet.getString("nom"),
						resultSet.getString("description"),
						resultSet.getString("prix"),
						resultSet.getInt("idsouscat")
						
						
						
						);
			}			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Prestation;
	}
	
	public void updatePrestation(Integer idPrestation, String nom, String description, String prix, Integer idsouscat			
			) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE prestation SET nom='"+nom+"', description='"+description+"', prix='"+prix+"', idsouscat='"+idsouscat+"' WHERE idPrestation= '"+idPrestation+"' ")){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void ajouterPrestation(Prestation Prestations) {


        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO prestation(nom, description, prix, idsouscat) VALUES(?, ?, ?, ?)");


            //Ajout des paramètres
            stmt.setString(1, Prestations.getNom());
            stmt.setString(2, Prestations.getDescription());
            stmt.setString(3, Prestations.getPrix());
            stmt.setInt(4, Prestations.getIdsouscat());
            
            stmt.executeUpdate();
            stmt.close();


            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void supprimerPrestation(Integer idprestation) {

        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();

            // Utiliser la connexion
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM prestation WHERE idprestation=?");
            stmt.setInt(1, idprestation);
            stmt.executeUpdate();
            stmt.close();

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
