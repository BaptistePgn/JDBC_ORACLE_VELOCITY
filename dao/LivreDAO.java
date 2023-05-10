package dao;

 import bean.Livre;
 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;

public class LivreDAO{

    private OracleSession session;

    public LivreDAO(OracleSession session) {
        this.session = session;
    }

    public List<Livre> readTable(){
        try{
            List<Livre> list = new ArrayList<>();
            Statement stmt = this.session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM Livre");

            while(resultat.next()){
                Livre element = new Livre();
                                    element.setIsbn(resultat.getBigDecimal("Isbn"));
                                    element.setTitre(resultat.getString("Titre"));
                                    element.setEditeur(resultat.getString("Editeur"));
                                    element.setAnnee(resultat.getBigDecimal("Annee"));
                                    element.setAuteur(resultat.getString("Auteur"));
                                    element.setDatede(resultat.getTimestamp("Datede"));
                                    element.setNbempr(resultat.getBigDecimal("Nbempr"));
                                    element.setLieu(resultat.getString("Lieu"));
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

    public boolean deleteElement(Livre element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("DELETE FROM Livre WHERE  Isbn= ?");
                                        stmt.setBigDecimal(1, element.getIsbn());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addElement(Livre element){
        try{
            PreparedStatement stmt = this.session.getConn().prepareStatement("INSERT INTO Livre( Isbn,  Titre,  Editeur,  Annee,  Auteur,  Datede,  Nbempr,  Lieu) VALUES ( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)");
                                        stmt.setBigDecimal(1, element.getIsbn());
                                            stmt.setString(2, element.getTitre());
                                            stmt.setString(3, element.getEditeur());
                                            stmt.setBigDecimal(4, element.getAnnee());
                                            stmt.setString(5, element.getAuteur());
                                            stmt.setTimestamp(6, element.getDatede());
                                            stmt.setBigDecimal(7, element.getNbempr());
                                            stmt.setString(8, element.getLieu());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateElement(Livre element){
        try  {
            PreparedStatement stmt = this.session.getConn().prepareStatement("UPDATE Livre SET  Isbn = ?,  Titre = ?,  Editeur = ?,  Annee = ?,  Auteur = ?,  Datede = ?,  Nbempr = ?,  Lieu = ? WHERE  Isbn = ?");
                                        stmt.setBigDecimal(1, element.getIsbn());
                                            stmt.setString(2, element.getTitre());
                                            stmt.setString(3, element.getEditeur());
                                            stmt.setBigDecimal(4, element.getAnnee());
                                            stmt.setString(5, element.getAuteur());
                                            stmt.setTimestamp(6, element.getDatede());
                                            stmt.setBigDecimal(7, element.getNbempr());
                                            stmt.setString(8, element.getLieu());
                                                        stmt.setBigDecimal(9, element.getIsbn());
                                        stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

   }
