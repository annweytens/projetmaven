package projet100h.pojos;

public class Utilisateur {
	
	private String idutilisateur;
	private String mdputilisateur;
	
	
	public Utilisateur(String idutilisateur, String mdputilisateur) {
		super();
		this.idutilisateur = idutilisateur;
		this.mdputilisateur = mdputilisateur;
	}
	
	public String getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(String idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public String getMdputilisateur() {
		return mdputilisateur;
	}
	public void setMdputilisateur(String mdputilisateur) {
		this.mdputilisateur = mdputilisateur;
	}
	
	
	

}
