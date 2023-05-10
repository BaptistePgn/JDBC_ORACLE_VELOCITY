package dao;

 import bean.Adherent;
 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;

public class AdherentDAO{

    private OracleSession session;

    public AdherentDAO(OracleSession session) {
        this.session = session;
    }

    public List<Adherent> readTable(){
        try{
            List<Adherent> list = new ArrayList<>();
            Statement stmt = this.session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM Adherent");

            while(resultat.next()){
                Adherent element = new Adherent();
                                    element.setNumadh(resultat.getBigDecimal("Numadh"));
                                    element.setNom(resultat.getString("Nom"));
                                    element.setPrenom(resultat.getString("Prenom"));
                                    element.setAdresse(resultat.getString("Adresse"));
                                list.add(element);
            }
            stmt.close();
            resultat.close();
            return list;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteElement(Adherent element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("DELETE FROM Adherent WHERE  Numadh= ?");
                                        stmt.setBigDecimal(1, element.getNumadh());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addElement(Adherent element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("INSERT INTO Adherent( Numadh,  Nom,  Prenom,  Adresse) VALUES ( ?,  ?,  ?,  ?)");
                                        stmt.setBigDecimal(1, element.getNumadh());
                                            stmt.setString(2, element.getNom());
                                            stmt.setString(3, element.getPrenom());
                                            stmt.setString(4, element.getAdresse());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateElement(Adherent element){
        try  {
            PreparedStatement stmt = this.session.getConn().prepareStatement("UPDATE Adherent SET  Numadh = ?,  Nom = ?,  Prenom = ?,  Adresse = ? WHERE  Numadh = ?");
                                        stmt.setBigDecimal(1, element.getNumadh());
                                            stmt.setString(2, element.getNom());
                                            stmt.setString(3, element.getPrenom());
                                            stmt.setString(4, element.getAdresse());
                                                        stmt.setBigDecimal(5, element.getNumadh());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

   }
