package bean;

public class Adherent {
 
  	private java.math.BigDecimal numadh;
  	private java.lang.String nom;
  	private java.lang.String prenom;
  	private java.lang.String adresse;
    
   	public Adherent() {;}
   	
   	public Adherent(java.math.BigDecimal numadh, java.lang.String nom, java.lang.String prenom, java.lang.String adresse) {
    	this.numadh = numadh; 
    	this.nom = nom; 
    	this.prenom = prenom; 
    	this.adresse = adresse; 
    }
  
  	public java.math.BigDecimal getNumadh() {
		return this.numadh;
	}
    public void setNumadh(java.math.BigDecimal numadh) {
        this.numadh = numadh;
    }
  	public java.lang.String getNom() {
		return this.nom;
	}
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }
  	public java.lang.String getPrenom() {
		return this.prenom;
	}
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }
  	public java.lang.String getAdresse() {
		return this.adresse;
	}
    public void setAdresse(java.lang.String adresse) {
        this.adresse = adresse;
    }
    public String toString() {
  		String ret = "";
        ret += "Numadh: "+this.numadh;
        ret += " - Nom: "+this.nom;
        ret += " - Prenom: "+this.prenom;
        ret += " - Adresse: "+this.adresse;
          ret += "\n";
  return ret;
	}
}