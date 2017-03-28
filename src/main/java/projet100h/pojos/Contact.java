package projet100h.pojos;

public class Contact {
	
	private int idInformations;
	private String Telephone1;
	private String Telephone2;
	private String Mail;
	
	
	public Contact(int idInformations, String telephone1, String telephone2, String mail) {
		super();
		this.idInformations = idInformations;
		Telephone1 = telephone1;
		Telephone2 = telephone2;
		Mail = mail;
	}


	public int getIdInformations() {
		return idInformations;
	}


	public void setIdInformations(int idInformations) {
		this.idInformations = idInformations;
	}


	public String getTelephone1() {
		return Telephone1;
	}


	public void setTelephone1(String telephone1) {
		Telephone1 = telephone1;
	}


	public String getTelephone2() {
		return Telephone2;
	}


	public void setTelephone2(String telephone2) {
		Telephone2 = telephone2;
	}


	public String getMail() {
		return Mail;
	}


	public void setMail(String mail) {
		Mail = mail;
	}
	
	
	

}
