package projet100h.services;

import java.io.IOException;
import java.util.List;


import projet100h.dao.PrestationDao;
import projet100h.pojos.Informations;
import projet100h.pojos.Prestation;


public class PrestationService {
	
private PrestationDao PrestationDao = new PrestationDao();
	
	
	private static final String PICTURE_MAIN_DIRECTORY = "C:/HEI/data";
	
	private static class PrestationServiceHolder {
		private static PrestationService instance = new PrestationService();
	}
	
	public static PrestationService getInstance() {
		return PrestationServiceHolder.instance;
	}

	private PrestationService() {
	}
	
	

	public List<Prestation> listPrestation() {
		return PrestationDao.listPrestation();
	}
	
	public Prestation getPrestation(Integer id) {
		return PrestationDao.getPrestation(id);
	}

		
	public void updatePrestation(Integer idPrestation, String nom, String description, String prix,Integer idsouscat
			) throws IOException {
		PrestationDao.updatePrestation(idPrestation, nom, description, prix, idsouscat);
	}
	
	 public void ajouterPrestation(Prestation nouvelPrestation) {
	        

	        PrestationDao.ajouterPrestation(nouvelPrestation);
	    }
	
	 public void supprimerPrestation(Integer idprestation) {


	        PrestationDao.supprimerPrestation(idprestation);
	    }

}
