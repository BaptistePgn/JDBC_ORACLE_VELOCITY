package dao;

 import bean.Exemplaire;
 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;

public class ExemplaireDAO{

    private OracleSession session;

    public ExemplaireDAO(OracleSession session) {
        this.session = session;
    }

    public List<Exemplaire> readTable(){
        try{
            List<Exemplaire> list = new ArrayList<>();
            Statement stmt = this.session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM Exemplaire");

            while(resultat.next()){
                Exemplaire element = new Exemplaire();
                                    element.setNuminv(resultat.getBigDecimal("Numinv"));
                                    element.setIsbn(resultat.getBigDecimal("Isbn"));
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

    public boolean deleteElement(Exemplaire element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("DELETE FROM Exemplaire WHERE  Numinv= ?");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addElement(Exemplaire element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("INSERT INTO Exemplaire( Numinv,  Isbn) VALUES ( ?,  ?)");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                            stmt.setBigDecimal(2, element.getIsbn());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateElement(Exemplaire element){
        try  {
            PreparedStatement stmt = this.session.getConn().prepareStatement("UPDATE Exemplaire SET  Numinv = ?,  Isbn = ? WHERE  Numinv = ?");
                                        stmt.setBigDecimal(1, element.getNuminv());
                                            stmt.setBigDecimal(2, element.getIsbn());
                                                        stmt.setBigDecimal(3, element.getNuminv());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

   }
