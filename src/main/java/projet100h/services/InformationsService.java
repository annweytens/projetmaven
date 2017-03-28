package projet100h.services;

import java.io.IOException;
import java.util.List;


import projet100h.dao.InformationsDao;
import projet100h.pojos.Contact;
import projet100h.pojos.Horaires;
import projet100h.pojos.Informations;



public class InformationsService {
	
	private InformationsDao informationsDao = new InformationsDao();
	
	
	private static final String PICTURE_MAIN_DIRECTORY = "C:/HEI/data";
	
	private static class InformationsServiceHolder {
		private static InformationsService instance = new InformationsService();
	}
	
	public static InformationsService getInstance() {
		return InformationsServiceHolder.instance;
	}

	private InformationsService() {
	}
	
	
	private projet100h.dao.HorairesDao HorairesDao = new projet100h.dao.HorairesDao();
	
	
	public List<Horaires> listHoraires() {
		return HorairesDao.listHoraires();
	}
	
	public Horaires getHoraires(Integer id) {
		return HorairesDao.getHoraires(id);
	}

	public void addHoraires(Horaires Horaires) throws IOException {
		HorairesDao.addHoraires(Horaires);
		
	}
	public void updateHoraires(String dimancheLundi, String mardiVendredi, String samedi,String conge) {
		HorairesDao.updateHoraires(dimancheLundi, mardiVendredi, samedi, conge);
		
	}
	
	private projet100h.dao.ContactDao ContactDao = new projet100h.dao.ContactDao();
	
	public List<Contact> listContacts() {
		return ContactDao.listContact();
	}
	
	public Contact getContact(Integer id) {
		return ContactDao.getContact(id);
	}

	
	public void updateContact(String Telephone1, String Telephone2, String Mail) {
		ContactDao.updateContact(Telephone1, Telephone2, Mail);
		
	}
	
	
	
	private InformationsDao InformationsDao = new InformationsDao();

	public List<Informations> listInformations() {
		return InformationsDao.listInformations();
	}
	
	public Informations getInformations(Integer id) {
		return InformationsDao.getInformations(id);
	}

	public void addInformations(Informations informations) throws IOException {
		InformationsDao.addInformations(informations);
		
	}
	
	public void updateInformations(Integer idInformations, String DimancheLundi, String MardiVendredi, String Samedi, String Telephone1, String Telephone2, String Mail, String conge) throws IOException {
		InformationsDao.updateInformations(idInformations, DimancheLundi, MardiVendredi, Samedi, Telephone1, Telephone2, Mail,conge);
	}

	
	
	

	
	

}
