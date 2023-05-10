package bean;

/**
 * @author hadjrabia-n
 *
 */
public class Attribut {
	
	private String name ;
	private String type ;

	private String inOut ;
	

	public Attribut(String name2, String type2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.type = type2;
	}

	public Attribut(String name2, String type2, String inOut) {
		this.name = name2;
		this.type = type2;
		this.inOut = inOut;
	}
	public String toString() {
		return "Attribut [name=" + name + ", type=" + type + "]";
	}
	
	public String getName() {
		return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
	}
	
	public String getFormat() {
		return name.toLowerCase();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return type.substring(type.lastIndexOf(".")+1);
	}

	public String getInOut() {
		return inOut;
	}


}

