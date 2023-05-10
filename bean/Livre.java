package bean;

public class Livre {
 
  	private java.math.BigDecimal isbn;
  	private java.lang.String titre;
  	private java.lang.String editeur;
  	private java.math.BigDecimal annee;
  	private java.lang.String auteur;
  	private java.sql.Timestamp datede;
  	private java.math.BigDecimal nbempr;
  	private java.lang.String lieu;
    
   	public Livre() {;}
   	
   	public Livre(java.math.BigDecimal isbn, java.lang.String titre, java.lang.String editeur, java.math.BigDecimal annee, java.lang.String auteur, java.sql.Timestamp datede, java.math.BigDecimal nbempr, java.lang.String lieu) {
    	this.isbn = isbn; 
    	this.titre = titre; 
    	this.editeur = editeur; 
    	this.annee = annee; 
    	this.auteur = auteur; 
    	this.datede = datede; 
    	this.nbempr = nbempr; 
    	this.lieu = lieu; 
    }
  
  	public java.math.BigDecimal getIsbn() {
		return this.isbn;
	}
    public void setIsbn(java.math.BigDecimal isbn) {
        this.isbn = isbn;
    }
  	public java.lang.String getTitre() {
		return this.titre;
	}
    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }
  	public java.lang.String getEditeur() {
		return this.editeur;
	}
    public void setEditeur(java.lang.String editeur) {
        this.editeur = editeur;
    }
  	public java.math.BigDecimal getAnnee() {
		return this.annee;
	}
    public void setAnnee(java.math.BigDecimal annee) {
        this.annee = annee;
    }
  	public java.lang.String getAuteur() {
		return this.auteur;
	}
    public void setAuteur(java.lang.String auteur) {
        this.auteur = auteur;
    }
  	public java.sql.Timestamp getDatede() {
		return this.datede;
	}
    public void setDatede(java.sql.Timestamp datede) {
        this.datede = datede;
    }
  	public java.math.BigDecimal getNbempr() {
		return this.nbempr;
	}
    public void setNbempr(java.math.BigDecimal nbempr) {
        this.nbempr = nbempr;
    }
  	public java.lang.String getLieu() {
		return this.lieu;
	}
    public void setLieu(java.lang.String lieu) {
        this.lieu = lieu;
    }
    public String toString() {
  		String ret = "";
        ret += "Isbn: "+this.isbn;
        ret += " - Titre: "+this.titre;
        ret += " - Editeur: "+this.editeur;
        ret += " - Annee: "+this.annee;
        ret += " - Auteur: "+this.auteur;
        ret += " - Datede: "+this.datede;
        ret += " - Nbempr: "+this.nbempr;
        ret += " - Lieu: "+this.lieu;
          ret += "\n";
  return ret;
	}
}