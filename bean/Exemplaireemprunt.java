package bean;

public class Exemplaireemprunt {
 
  	private java.math.BigDecimal numinv;
  	private java.math.BigDecimal numadh;
  	private java.sql.Timestamp dateempr;
    
   	public Exemplaireemprunt() {;}
   	
   	public Exemplaireemprunt(java.math.BigDecimal numinv, java.math.BigDecimal numadh, java.sql.Timestamp dateempr) {
    	this.numinv = numinv; 
    	this.numadh = numadh; 
    	this.dateempr = dateempr; 
    }
  
  	public java.math.BigDecimal getNuminv() {
		return this.numinv;
	}
    public void setNuminv(java.math.BigDecimal numinv) {
        this.numinv = numinv;
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
    public String toString() {
  		String ret = "";
        ret += "Numinv: "+this.numinv;
        ret += " - Numadh: "+this.numadh;
        ret += " - Dateempr: "+this.dateempr;
          ret += "\n";
  return ret;
	}
}