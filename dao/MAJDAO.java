package dao;

 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;
 import oracle.jdbc.OracleTypes;
 import oracle.xdb.XMLType;


public class MAJDAO {

    private OracleSession session;

    public MAJDAO(OracleSession session){
        this.session = session;
    }
    public boolean ADD_ADHERENT(BigDecimal Le_numadh,String Le_nomadh,String Le_prenomadh,String Le_adresseadh){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.ADD_ADHERENT(?,?,?,?)}");
                                                        cs.setBigDecimal(1, Le_numadh);
                                                                                                cs.setString(2, Le_nomadh);
                                                                                                cs.setString(3, Le_prenomadh);
                                                                                                cs.setString(4, Le_adresseadh);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean ADD_EMPRUNT(BigDecimal Le_numadh,Timestamp La_dateemprunt,Timestamp Ladateretour,Array Les_numinv){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.ADD_EMPRUNT(?,?,?,?)}");
                                                        cs.setBigDecimal(1, Le_numadh);
                                                                                                cs.setTimestamp(2, La_dateemprunt);
                                                                                                cs.setTimestamp(3, Ladateretour);
                                                                                                cs.setArray(4, Les_numinv);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean ADD_EXEMPLAIRES(Array Numinv,BigDecimal Isbn){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.ADD_EXEMPLAIRES(?,?)}");
                                                        cs.setArray(1, Numinv);
                                                                                                cs.setBigDecimal(2, Isbn);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean ADD_LIVRE(BigDecimal Isbn,String Titre,String Editeur,BigDecimal Annee,Array Auteur,Timestamp Datede,BigDecimal Nbempr,String Lieu){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.ADD_LIVRE(?,?,?,?,?,?,?,?)}");
                                                        cs.setBigDecimal(1, Isbn);
                                                                                                cs.setString(2, Titre);
                                                                                                cs.setString(3, Editeur);
                                                                                                cs.setBigDecimal(4, Annee);
                                                                                                cs.setArray(5, Auteur);
                                                                                                cs.setTimestamp(6, Datede);
                                                                                                cs.setBigDecimal(7, Nbempr);
                                                                                                cs.setString(8, Lieu);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean RETOUR_EXEMPLAIRE(Array Numinvs){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.RETOUR_EXEMPLAIRE(?)}");
                                                        cs.setArray(1, Numinvs);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean SUPPR_ADHERENT(BigDecimal Le_numadh){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.SUPPR_ADHERENT(?)}");
                                                        cs.setBigDecimal(1, Le_numadh);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean SUPPR_EXEMPLAIRE(Array Numinvs){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.SUPPR_EXEMPLAIRE(?)}");
                                                        cs.setArray(1, Numinvs);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
    public boolean UPDATE_ADHERENT(BigDecimal Le_numadh,String Le_nomadh,String Le_prenomadh,String Le_adresseadh){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call MAJ.UPDATE_ADHERENT(?,?,?,?)}");
                                                        cs.setBigDecimal(1, Le_numadh);
                                                                                                cs.setString(2, Le_nomadh);
                                                                                                cs.setString(3, Le_prenomadh);
                                                                                                cs.setString(4, Le_adresseadh);
                                                                            cs.execute();

            
                        cs.close();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();}
        return false;
        
    }
}
