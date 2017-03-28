package projet100h.services;

import java.io.IOException;
import java.util.List;


import projet100h.dao.SousCategorieDao;

import projet100h.pojos.SousCategorie;


public class SousCategorieService {

private SousCategorieDao SousCategorieDao = new SousCategorieDao();
	
	
		
	private static class SousCategorieServiceHolder {
		private static SousCategorieService instance = new SousCategorieService();
	}
	
	public static SousCategorieService getInstance() {
		return SousCategorieServiceHolder.instance;
	}

	private SousCategorieService() {
	}
	
	

	 public List<SousCategorie> listeSousCategories() {
	        return SousCategorieDao.listeSousCategories();

	    }
	
	public SousCategorie getSousCategorie(Integer id) {
		return SousCategorieDao.getSousCategorie(id);
	}

		
	public void updatesouscategorie(Integer idsouscategorie, String nom, Integer idcat
			) throws IOException {
		SousCategorieDao.updatesouscategorie(idsouscategorie, nom, idcat);
	}
	
	
	
}
