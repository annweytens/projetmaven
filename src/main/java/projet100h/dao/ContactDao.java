package projet100h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet100h.pojos.Contact;


public class ContactDao {
	
	
	public List<Contact> listContact() {
		List<Contact> Contact = new ArrayList<Contact>();

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM information")) {
			while (resultSet.next()) {
				Contact.add(new Contact(resultSet.getInt("idInformations"),resultSet.getString("Telephone1"),resultSet.getString("Telephone2"),resultSet.getString("Mail")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return Contact;
	}

	public Contact getContact(Integer id) {
		Contact Contact = null;
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM information ");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				Contact = new Contact(
						resultSet.getInt("idInformations"), 
						resultSet.getString("Telephone1"),
						resultSet.getString("Telephone2"),
						resultSet.getString("Mail")
						
						);
			}			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Contact;
	}

/*	public Contact addHoraires(Contact Contact) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `information`(`DimancheLundi`,`MardiVendredi`,`Samedi`)VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Contact.getDimancheLundi());
			stmt.setString(2, Contact.getMardiVendredi());
			stmt.setString(3, Contact.getSamedi());
			
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Horaires;
	}*/



	public void updateContact(String Telephone1, String Telephone2, String Mail) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE information SET Telephone1='"+Telephone1+"', Telephone2='"+Telephone2+"', Mail='"+Mail+"' WHERE idInformations=1")){
				statement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

}
