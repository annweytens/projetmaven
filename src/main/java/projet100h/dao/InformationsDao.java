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

import projet100h.pojos.Informations;


public class InformationsDao{

public List<Informations> listInformations() {
	List<Informations> Informations = new ArrayList<Informations>();

	try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM information")) {
		while (resultSet.next()) {
			Informations.add(new Informations(resultSet.getInt("idInformations"),resultSet.getString("DimancheLundi"),resultSet.getString("MardiVendredi"),resultSet.getString("Samedi"),resultSet.getString("telephone1"),resultSet.getString("telephone2"),resultSet.getString("mail"),resultSet.getString("conge")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
	}

	return Informations;
}

public Informations getInformations(Integer id) {
	
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM information WHERE idInformations=? ");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		if(resultSet.next()) {
			return new Informations(
					resultSet.getInt("idInformations"), 
					resultSet.getString("DimancheLundi"),
					resultSet.getString("MardiVendredi"),
					resultSet.getString("Samedi"),
					resultSet.getString("telephone1"),
					resultSet.getString("telephone2"),
					resultSet.getString("mail"),
					resultSet.getString("conge")
					
					);
		}			
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public Informations addInformations(Informations informations) {
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO `information`(`DimancheLundi`,`MardiVendredi`,`Samedi`,`Telephone1`,`Telephone2`,`Mail`,`conge`)VALUES(?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, informations.getDimancheLundi());
		stmt.setString(2, informations.getMardiVendredi());
		stmt.setString(3, informations.getSamedi());
		stmt.setString(4, informations.getTelephone1());
		stmt.setString(5, informations.getTelephone2());
		stmt.setString(6, informations.getMail());
		
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return informations;
}

public void updateInformations(Integer idInformations, String DimancheLundi, String MardiVendredi, String Samedi, String Telephone1, String Telephone2, String Mail, String conge) {
	try(Connection connection = DataSourceProvider.getDataSource().getConnection();
	PreparedStatement statement = connection.prepareStatement("UPDATE information SET DimancheLundi='"+DimancheLundi+"', MardiVendredi='"+MardiVendredi+"', Samedi='"+Samedi+"', Telephone1='"+Telephone1+"', Telephone2='"+Telephone2+"', Mail='"+Mail+"', conge='"+conge+"' WHERE idInformations="+idInformations)){
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