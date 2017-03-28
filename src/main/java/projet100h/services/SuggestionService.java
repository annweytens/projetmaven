package projet100h.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Part;

import projet100h.dao.PrestationDao;
import projet100h.pojos.Prestation;
import projet100h.pojos.Suggestion;


public class SuggestionService {
	
private projet100h.dao.SuggestionDao SuggestionDao = new projet100h.dao.SuggestionDao();
	
	
	private static final String PICTURE_MAIN_DIRECTORY = "C:/HEI/data";
	
	private static class SuggestionServiceHolder {
		private static SuggestionService instance = new SuggestionService();
	}
	
	public static SuggestionService getInstance() {
		return SuggestionServiceHolder.instance;
	}

	private SuggestionService() {
	}
	
	

	public List<Suggestion> listSuggestions() {
		return SuggestionDao.listSuggestions();
	}
	
	
		
	public void updateSuggestions(Integer idsuggestion, String text, String titre, String soustitre
			) throws IOException {
		SuggestionDao.updateSuggestions(idsuggestion, text, titre, soustitre);
	}
	
	/* public void ajouterSuggestion(Suggestion nouvelSuggestion, Part Image) {
		 
		 Path imagePath = Paths.get(PICTURE_MAIN_DIRECTORY, Image.getSubmittedFileName());
	        

		 SuggestionDao.ajouterSuggestion(nouvelSuggestion, imagePath.toString());
		 
		 try{
		 Files.copy(Image.getInputStream(), imagePath);
		 }catch (IOException e){
			 e.printStackTrace();
		 }
	    }*/
	 
	 public Path getPicturePath(Integer IdSuggestion){
			String picturePathString = SuggestionDao.getPicturePath(IdSuggestion);
			if(picturePathString == null){
				return getDefaultPicturePath();
			}else{
			Path picturePath = Paths.get(SuggestionDao.getPicturePath(IdSuggestion));
			if (!Files.exists(picturePath) || picturePath.toString().equals(PICTURE_MAIN_DIRECTORY)){  //Si image inexistant ou image non upload
				return getDefaultPicturePath();
			}else{
				return picturePath;
			}
			}
		}
				
		private Path getDefaultPicturePath(){
			try {
				return Paths.get(this.getClass().getClassLoader().getResource("imageDefault.jpeg").toURI());
			} catch (URISyntaxException e) {
				return null; 
			}
		}
	 
	 
	
	 public void supprimerSuggestions(Integer idsuggestion) {


		 SuggestionDao.supprimerSuggestions(idsuggestion);
	    }


}
