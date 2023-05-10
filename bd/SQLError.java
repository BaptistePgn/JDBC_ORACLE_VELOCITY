package bd;

public class SQLError extends Exception {

	private static final long serialVersionUID = -7068315156287948965L;
	private int codeErreur;
	private String messageErreur;
	
	public SQLError (int codeErreur, String messageErreur) {
		super(codeErreur+" "+messageErreur);
		this.codeErreur = codeErreur;
		this.messageErreur = messageErreur;
	}
	
	public int getCodeErreur() {
		return codeErreur;
	}

	public String getMessageErreur() {
		return messageErreur;
	}

}
