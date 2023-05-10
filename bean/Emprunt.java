package bean;

public class Emprunt {
 
  	private java.math.BigDecimal numadh;
  	private java.sql.Timestamp dateempr;
  	private java.sql.Timestamp dateret;
    
   	public Emprunt() {;}
   	
   	public Emprunt(java.math.BigDecimal numadh, java.sql.Timestamp dateempr, java.sql.Timestamp dateret) {
    	this.numadh = numadh; 
    	this.dateempr = dateempr; 
    	this.dateret = dateret; 
    }
  
  	public java.math.BigDecimal getNumadh() {
		return this.numadh;
	}
    public void setNumadh(java.math.BigDecimal numadh) {
        this.numadh = numadh;
    }
  	public java.sql.Timestamp getDateempr() {
		return this.dateempr;
	}
    public void setDateempr(java.sql.Timestamp dateempr) {
        this.dateempr = dateempr;
    }
  	public java.sql.Timestamp getDateret() {
		return this.dateret;
	}
    public void setDateret(java.sql.Timestamp dateret) {
        this.dateret = dateret;
    }
    public String toString() {
  		String ret = "";
        ret += "Numadh: "+this.numadh;
        ret += " - Dateempr: "+this.dateempr;
        ret += " - Dateret: "+this.dateret;
          ret += "\n";
  return ret;
	}
}