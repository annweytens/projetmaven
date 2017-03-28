package projet100h.pojos;

public class Informations {
	
	private int idInformations;
	private String DimancheLundi;
	private String MardiVendredi;
	private String Samedi;
	private String Telephone1;
	private String Telephone2;
	private String Mail;
	private String conge;
	
	
	
	
	public Informations(int idInformations, String dimancheLundi, String mardiVendredi, String samedi,
			String telephone1, String telephone2, String mail, String conge) {
		super();
		this.idInformations = idInformations;
		this.DimancheLundi = dimancheLundi;
		this.MardiVendredi = mardiVendredi;
		this.Samedi = samedi;
		this.Telephone1 = telephone1;
		this.Telephone2 = telephone2;
		this.Mail = mail;
		this.conge= conge;
	}
	
	
	
	public String getConge() {
		return conge;
	}



	public void setConge(String conge) {
		this.conge = conge;
	}



	public int getIdInformations() {
		return idInformations;
	}
	public void setIdInformations(int idInformations) {
		this.idInformations = idInformations;
	}
	public String getDimancheLundi() {
		return DimancheLundi;
	}
	public void setDimancheLundi(String dimancheLundi) {
		this.DimancheLundi = dimancheLundi;
	}
	public String getMardiVendredi() {
		return MardiVendredi;
	}
	public void setMardiVendredi(String mardiVendredi) {
		this.MardiVendredi = mardiVendredi;
	}
	public String getSamedi() {
		return Samedi;
	}
	public void setSamedi(String samedi) {
		this.Samedi = samedi;
	}
	public String getTelephone1() {
		return Telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.Telephone1 = telephone1;
	}
	public String getTelephone2() {
		return Telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.Telephone2 = telephone2;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		this.Mail = mail;
	}
	
	
	
	
	
	
	
	
	
}