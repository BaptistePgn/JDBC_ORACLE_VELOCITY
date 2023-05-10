package main;

import bd.OracleSession;
import bd.SQLError;
import bean.Adherent;
import bean.Exemplaireemprunt;
import dao.*;

import java.math.BigDecimal;

public class Main {

	
	
	public static void main(String[] args) {
		try {

			//BeanGeneratorVelocity.generateAll();
			//StatementGeneratorVelocity.generateAll();
			//ProcedureGeneratorVelocity.generateAll();

			OracleSession session = new OracleSession();



			System.out.println("Adherent :");
			AdherentDAO adherentDAO = new AdherentDAO(session);
			System.out.println(adherentDAO.readTable());
			System.out.println("---------------- AVEC PROCEDURE ----------------");


			System.out.println("Ajout Element :");
			MAJDAO majDAO = new MAJDAO(session);
			majDAO.ADD_ADHERENT(new BigDecimal(55), "nom", "prenom", "adresse");
			System.out.println(adherentDAO.readTable());

			System.out.println("Update Element :");
			majDAO.UPDATE_ADHERENT(new BigDecimal(55), "nom2", "prenom2", "adresse2");
			System.out.println(adherentDAO.readTable());

			System.out.println("Delete Element :");
			majDAO.SUPPR_ADHERENT(new BigDecimal(55));
			System.out.println(adherentDAO.readTable());

			System.out.println("---------------- SANS PROCEDURE ----------------");

			System.out.println("Ajout Element :");
			adherentDAO.addElement(new Adherent(new BigDecimal(55), "nom", "prenom", "adresse"));
			System.out.println(adherentDAO.readTable());
			System.out.println("Update Element :");
			adherentDAO.updateElement(new Adherent(new BigDecimal(55), "nom2", "prenom2", "adresse2"));
			System.out.println(adherentDAO.readTable());
			System.out.println("Delete Element :");
			adherentDAO.deleteElement(new Adherent(new BigDecimal(55), "nom2", "prenom2", "adresse2"));
			System.out.println(adherentDAO.readTable());

			System.out.println("Emprunt :");
			EmpruntDAO empruntDAO = new EmpruntDAO(session);
			System.out.println(empruntDAO.readTable());

			System.out.println("Livre :");
			LivreDAO livreDAO = new LivreDAO(session);
			System.out.println(livreDAO.readTable());

			System.out.println("Exemplaire :");
			ExemplaireDAO exemplaireDAO = new ExemplaireDAO(session);
			System.out.println(exemplaireDAO.readTable());

			System.out.println("Exemplaireemprunt :");
			ExemplaireempruntDAO exemplaireempruntDAO = new ExemplaireempruntDAO(session);
			System.out.println(exemplaireempruntDAO.readTable());


			System.out.println("Liste des adherents XML:");
			LECTUREDAO lectureDAO = new LECTUREDAO(session);
			System.out.println(lectureDAO.LISTE_DES_ADHERENTS_XML());
			session.closeConn();

		} catch (SQLError e) {
			e.printStackTrace();
		}
	}
	

}
