package projet100h.services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import projet100h.dao.AccueilDao;
import projet100h.pojos.Accueil;
import projet100h.pojos.Horaires;



public class AccueilService {
	
	private static final String PICTURE_MAIN_DIRECTORY = "C:/Users/benoit/Documents/GitHub/momentdesoi/img/slider";
	
	private AccueilDao accueilDao = new AccueilDao();
	
	private static class AccueilServiceHolder {
		private static AccueilService instance = new AccueilService();
	}
	
	public static AccueilService getInstance() {
		return AccueilServiceHolder.instance;
	}

	private AccueilService() {
	}
	
	/*public List<Accueil> listAccueil() {
		return AccueilDao.listAccueil();
	}
	
	public Horaires getHoraires(Integer id) {
		return HorairesDao.getHoraires(id);
	}

	public void addHoraires(Horaires Horaires) throws IOException {
		HorairesDao.addHoraires(Horaires);
		
	}
	
	Path photopath = Paths.get(PICTURE_MAIN_DIRECTORY, photo.getSubmittedFileName());*/

}
