package dao;

 import bean.Emprunt;
 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;

public class EmpruntDAO{

    private OracleSession session;

    public EmpruntDAO(OracleSession session) {
        this.session = session;
    }

    public List<Emprunt> readTable(){
        try{
            List<Emprunt> list = new ArrayList<>();
            Statement stmt = this.session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM Emprunt");

            while(resultat.next()){
                Emprunt element = new Emprunt();
                                    element.setNumadh(resultat.getBigDecimal("Numadh"));
                                    element.setDateempr(resultat.getTimestamp("Dateempr"));
                                    element.setDateret(resultat.getTimestamp("Dateret"));
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

    public boolean deleteElement(Emprunt element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("DELETE FROM Emprunt WHERE  Dateempr= ? AND Numadh= ?");
                                        stmt.setTimestamp(1, element.getDateempr());
                                            stmt.setBigDecimal(2, element.getNumadh());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addElement(Emprunt element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("INSERT INTO Emprunt( Numadh,  Dateempr,  Dateret) VALUES ( ?,  ?,  ?)");
                                        stmt.setBigDecimal(1, element.getNumadh());
                                            stmt.setTimestamp(2, element.getDateempr());
                                            stmt.setTimestamp(3, element.getDateret());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateElement(Emprunt element){
        try  {
            PreparedStatement stmt = this.session.getConn().prepareStatement("UPDATE Emprunt SET  Numadh = ?,  Dateempr = ?,  Dateret = ? WHERE  Dateempr = ? AND  Numadh = ?");
                                        stmt.setBigDecimal(1, element.getNumadh());
                                            stmt.setTimestamp(2, element.getDateempr());
                                            stmt.setTimestamp(3, element.getDateret());
                                                        stmt.setTimestamp(4, element.getDateempr());
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
