package projet100h.pojos;

public class Prestation {
	
	private Integer idprestation;
	private String nom;
	private String description;
	private String prix;
	private Integer idsouscat;
	
	
	
	
	public Prestation(Integer idprestation, String nom, String description, String prix, Integer idsouscat) {
		super();
		this.idprestation = idprestation;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.idsouscat = idsouscat;
	}
	
	
	public Integer getIdprestation() {
		return idprestation;
	}
	public void setIdprestation(Integer idprestation) {
		this.idprestation = idprestation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public Integer getIdsouscat() {
		return idsouscat;
	}
	public void setIdsouscat(Integer idsouscat) {
		this.idsouscat = idsouscat;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
