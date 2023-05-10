package bean;

public class Exemplaire {
 
  	private java.math.BigDecimal numinv;
  	private java.math.BigDecimal isbn;
    
   	public Exemplaire() {;}
   	
   	public Exemplaire(java.math.BigDecimal numinv, java.math.BigDecimal isbn) {
    	this.numinv = numinv; 
    	this.isbn = isbn; 
    }
  
  	public java.math.BigDecimal getNuminv() {
		return this.numinv;
	}
    public void setNuminv(java.math.BigDecimal numinv) {
        this.numinv = numinv;
    }
  	public java.math.BigDecimal getIsbn() {
		return this.isbn;
	}
    public void setIsbn(java.math.BigDecimal isbn) {
        this.isbn = isbn;
    }
    public String toString() {
  		String ret = "";
        ret += "Numinv: "+this.numinv;
        ret += " - Isbn: "+this.isbn;
          ret += "\n";
  return ret;
	}
}