package dao;

 import bean.Exemplaireemprunt;
 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;

public class ExemplaireempruntDAO{

    private OracleSession session;

    public ExemplaireempruntDAO(OracleSession session) {
        this.session = session;
    }

    public List<Exemplaireemprunt> readTable(){
        try{
            List<Exemplaireemprunt> list = new ArrayList<>();
            Statement stmt = this.session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM Exemplaireemprunt");

            while(resultat.next()){
                Exemplaireemprunt element = new Exemplaireemprunt();
                                    element.setNuminv(resultat.getBigDecimal("Numinv"));
                                    element.setNumadh(resultat.getBigDecimal("Numadh"));
                                    element.setDateempr(resultat.getTimestamp("Dateempr"));
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

    public boolean deleteElement(Exemplaireemprunt element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("DELETE FROM Exemplaireemprunt WHERE  Numinv= ?");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addElement(Exemplaireemprunt element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("INSERT INTO Exemplaireemprunt( Numinv,  Numadh,  Dateempr) VALUES ( ?,  ?,  ?)");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                            stmt.setBigDecimal(2, element.getNumadh());
                                            stmt.setTimestamp(3, element.getDateempr());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateElement(Exemplaireemprunt element){
        try  {
            PreparedStatement stmt = this.session.getConn().prepareStatement("UPDATE Exemplaireemprunt SET  Numinv = ?,  Numadh = ?,  Dateempr = ? WHERE  Numinv = ?");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                            stmt.setBigDecimal(2, element.getNumadh());
                                            stmt.setTimestamp(3, element.getDateempr());
                                                        stmt.setBigDecimal(4, element.getNuminv());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

   }
