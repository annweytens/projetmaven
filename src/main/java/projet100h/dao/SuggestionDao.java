package projet100h.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.pojos.Informations;
import projet100h.pojos.Prestation;
import projet100h.pojos.Suggestion;


public class SuggestionDao{

public List<Suggestion> listSuggestions() {
	List<Suggestion> Suggestions = new ArrayList<Suggestion>();

	try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM suggestion")) {
		while (resultSet.next()) {
			Suggestions.add(new Suggestion(resultSet.getInt("idsuggestion"),resultSet.getString("text"),resultSet.getString("titre"),resultSet.getString("soustitre")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
	}

	return Suggestions;
}



	public String getPicturePath(Integer IdSuggestion){
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT image FROM suggestion WHERE idsuggestion=?")){
			statement.setInt(1, IdSuggestion);
				try (ResultSet resulSet = statement.executeQuery()){
					if (resulSet.next()){
						return resulSet.getString("image");
					}
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  
	}

public void ajouterSuggestion(Suggestion Suggestions, String imagePath) {


    try {
        Connection connection = DataSourceProvider.getDataSource().getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO suggestion(text, titre, soustitre, image) VALUES(?, ?, ?, ?)");


        //Ajout des paramètres
        stmt.setString(1, Suggestions.getText());
        stmt.setString(2, Suggestions.getTitre());
        stmt.setString(3, Suggestions.getSoustitre());
        stmt.setString(4, imagePath);
        
        
        stmt.executeUpdate();
        stmt.close();


        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



public void updateSuggestions(Integer idsuggestion, String text, String titre, String soustitre) {
	try(Connection connection = DataSourceProvider.getDataSource().getConnection();
	PreparedStatement statement = connection.prepareStatement("UPDATE suggestion SET text='"+text+"', titre='"+titre+"', soustitre='"+soustitre+"' WHERE idsuggestion="+idsuggestion)){
	statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void supprimerSuggestions(Integer idsuggestion) {

    try {
        Connection connection = DataSourceProvider.getDataSource().getConnection();

        // Utiliser la connexion
        PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM suggestion WHERE idsuggestion=?");
        stmt.setInt(1, idsuggestion);
        stmt.executeUpdate();
        stmt.close();

        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
