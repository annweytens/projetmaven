package projet100h.pojos;

public class Suggestion {
	
	private Integer idsuggestion;
	private String text;
	private String titre;
	private String soustitre;
	
	
	
		public Suggestion(Integer idsuggestion, String text, String titre, String soustitre) {
		super();
		this.idsuggestion = idsuggestion;
		this.text = text;
		this.titre = titre;
		this.soustitre = soustitre;
	}
		
		
	public Integer getIdsuggestion() {
		return idsuggestion;
	}
	public void setIdsuggestion(Integer idsuggestion) {
		this.idsuggestion = idsuggestion;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSoustitre() {
		return soustitre;
	}
	public void setSoustitre(String soustitre) {
		this.soustitre = soustitre;
	}
	
	
	

}
