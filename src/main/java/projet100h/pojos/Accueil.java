package projet100h.pojos;

public class Accueil {
	
	private String Photo;
	private String nom;
	private Integer idAccueil;
	
		
	public Accueil(Integer idAccueil, String nom, String photo) {
		super();
		Photo = photo;
		this.nom = nom;
		this.idAccueil = idAccueil;
	}
	
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getIdAccueil() {
		return idAccueil;
	}
	public void setIdAccueil(Integer idAccueil) {
		this.idAccueil = idAccueil;
	}
	
	
	
	
	
	
	

}
