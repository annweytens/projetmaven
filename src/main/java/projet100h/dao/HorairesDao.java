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

import projet100h.pojos.Horaires;
import projet100h.pojos.Informations;


public class HorairesDao{

public List<Horaires> listHoraires() {
	List<Horaires> Horaires = new ArrayList<Horaires>();

	try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM information")) {
		while (resultSet.next()) {
			Horaires.add(new Horaires(resultSet.getInt("idInformations"),resultSet.getString("DimancheLundi"),resultSet.getString("MardiVendredi"),resultSet.getString("Samedi"),resultSet.getString("conge")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
	}

	return Horaires;
}

public Horaires getHoraires(Integer id) {
	Horaires Horaires = null;
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM information ");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		if(resultSet.next()) {
			Horaires = new Horaires(
					resultSet.getInt("idInformations"), 
					resultSet.getString("DimancheLundi"),
					resultSet.getString("MardiVendredi"),
					resultSet.getString("Samedi"),
					resultSet.getString("conge")
					
					);
		}			
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return Horaires;
}

public Horaires addHoraires(Horaires Horaires) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO `information`(`DimancheLundi`,`MardiVendredi`,`Samedi`,`conge`)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, Horaires.getDimancheLundi());
		stmt.setString(2, Horaires.getMardiVendredi());
		stmt.setString(3, Horaires.getSamedi());
		stmt.setString(3, Horaires.getConge());
		
		
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return Horaires;
}



public void updateHoraires(String dimancheLundi, String mardiVendredi, String samedi, String conge) {
	try(Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE information SET DimancheLundi='"+dimancheLundi+"', MardiVendredi='"+mardiVendredi+"', Samedi='"+samedi+"', conge='"+conge+"' WHERE idInformations=1")){
			statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
}

/*public String getPhotoPath(Integer id){
	try {
		Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT photo FROM article JOIN categorie ON article.idcategorie = categorie.id_categorie "
				+ "WHERE id_article=? AND deleted='0'");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		if(resultSet.next()) {
			return resultSet.getString("photo");
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}*/






}
