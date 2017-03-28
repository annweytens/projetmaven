package projet100h.pojos;

public class SousCategorie {
	
	private Integer idsouscategorie;
	private String nom;
	private Integer idcat;
	
	
	
	public SousCategorie(Integer idsouscategorie, String nom, Integer idcat) {
		super();
		this.idsouscategorie = idsouscategorie;
		this.nom = nom;
		this.idcat = idcat;
	}
	
	
	
	
	public Integer getIdcat() {
		return idcat;
	}




	public void setIdcat(Integer idcat) {
		this.idcat = idcat;
	}




	public Integer getIdsouscategorie() {
		return idsouscategorie;
	}
	public void setIdsouscategorie(Integer idsouscategorie) {
		this.idsouscategorie = idsouscategorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
