package projet100h.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.pojos.Accueil;




public class AccueilDao{

public List<Accueil> listAccueil() {
	List<Accueil> Accueil = new ArrayList<Accueil>();

	try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM accueil")) {
		while (resultSet.next()) {
			Accueil.add(new Accueil(resultSet.getInt("idAccueil"), resultSet.getString("photo"),resultSet.getString("nom")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
	}

	return Accueil;
}

public Accueil getAccueil(Integer id) {
	
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM accueil WHERE idAccueil=? ");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		if(resultSet.next()) {
			return new Accueil(
					resultSet.getInt("idAccueil"), 
					resultSet.getString("photo"),
					resultSet.getString("nom")
					);
		}			
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public Accueil addInformations(Accueil accueil, String photoPath) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO `accueil`(`idAccueil`,`photo`,`nom`)VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, accueil.getNom());
		stmt.setString(2, photoPath);
		
		
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return accueil;
}
}
