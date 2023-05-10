package dao;

 import java.util.ArrayList;
 import java.util.List;
 import bd.OracleSession;
 import java.sql.*;
 import java.math.BigDecimal;
 import oracle.jdbc.OracleTypes;
 import oracle.xdb.XMLType;


public class LECTUREDAO {

    private OracleSession session;

    public LECTUREDAO(OracleSession session){
        this.session = session;
    }
    public String AFFICHER_ADHERENT(BigDecimal Le_numadh){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call LECTURE.AFFICHER_ADHERENT(?,?)}");
                                                        cs.setBigDecimal(1, Le_numadh);
                                                                                                                cs.registerOutParameter(2, OracleTypes.CURSOR);
                                                            cs.execute();

                            ResultSet rs = (ResultSet) cs.getObject(1);
                if(rs.next()){
                    try{
                        XMLType xml = (XMLType) rs.getObject(1);
                        return xml.getString();
                    }catch(Exception e){
                        return "La procÃ©dure ne retourne pas de XML";
                    }
                }
            
            
        }catch(SQLException e){
            e.printStackTrace();}
            return null;
    
    }
    public String LISTE_ADHERENTS_RETARD(){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call LECTURE.LISTE_ADHERENTS_RETARD(?)}");
                                                                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                                                            cs.execute();

                            ResultSet rs = (ResultSet) cs.getObject(1);
                if(rs.next()){
                    try{
                        XMLType xml = (XMLType) rs.getObject(1);
                        return xml.getString();
                    }catch(Exception e){
                        return "La procÃ©dure ne retourne pas de XML";
                    }
                }
            
            
        }catch(SQLException e){
            e.printStackTrace();}
            return null;
    
    }
    public String LISTE_DES_ADHERENTS(){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call LECTURE.LISTE_DES_ADHERENTS(?)}");
                                                                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                                                            cs.execute();

                            ResultSet rs = (ResultSet) cs.getObject(1);
                if(rs.next()){
                    try{
                        XMLType xml = (XMLType) rs.getObject(1);
                        return xml.getString();
                    }catch(Exception e){
                        return "La procÃ©dure ne retourne pas de XML";
                    }
                }
            
            
        }catch(SQLException e){
            e.printStackTrace();}
            return null;
    
    }
    public String LISTE_DES_ADHERENTS_XML(){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call LECTURE.LISTE_DES_ADHERENTS_XML(?)}");
                                                                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                                                            cs.execute();

                            ResultSet rs = (ResultSet) cs.getObject(1);
                if(rs.next()){
                    try{
                        XMLType xml = (XMLType) rs.getObject(1);
                        return xml.getString();
                    }catch(Exception e){
                        return "La procÃ©dure ne retourne pas de XML";
                    }
                }
            
            
        }catch(SQLException e){
            e.printStackTrace();}
            return null;
    
    }
    public String LISTE_DES_LIVRES(){
        try{
            CallableStatement cs = session.getConn().prepareCall("{call LECTURE.LISTE_DES_LIVRES(?)}");
                                                                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                                                            cs.execute();

                            ResultSet rs = (ResultSet) cs.getObject(1);
                if(rs.next()){
                    try{
                        XMLType xml = (XMLType) rs.getObject(1);
                        return xml.getString();
                    }catch(Exception e){
                        return "La procÃ©dure ne retourne pas de XML";
                    }
                }
            
            
        }catch(SQLException e){
            e.printStackTrace();}
            return null;
    
    }
}
