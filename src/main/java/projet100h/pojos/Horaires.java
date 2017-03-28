package projet100h.pojos;

public class Horaires {
	
	private int idInformations;
	private String DimancheLundi;
	private String MardiVendredi;
	private String Samedi;
	private String conge;
	
	
	public Horaires(Integer idInformations, String dimancheLundi, String mardiVendredi, String samedi, String conge) {
		super();
		this.idInformations = idInformations;
		this.DimancheLundi = dimancheLundi;
		this.MardiVendredi = mardiVendredi;
		this.Samedi = samedi;
		this.conge=conge;
	}
	
	
	
	public String getConge() {
		return conge;
	}



	public void setConge(String conge) {
		this.conge = conge;
	}



	public String getDimancheLundi() {
		return DimancheLundi;
	}
	public void setDimancheLundi(String dimancheLundi) {
		DimancheLundi = dimancheLundi;
	}
	public String getMardiVendredi() {
		return MardiVendredi;
	}
	public void setMardiVendredi(String mardiVendredi) {
		MardiVendredi = mardiVendredi;
	}
	public String getSamedi() {
		return Samedi;
	}
	public void setSamedi(String samedi) {
		Samedi = samedi;
	}

	public int getIdInformations() {
		return idInformations;
	}

	public void setIdInformations(int idInformations) {
		this.idInformations = idInformations;
	}
	
	

}
