/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td1;


import java.sql.*;

/**
 *
 * @author fasalles
 */
public class td1 {
    public static void main( String[] args) throws SQLException{
        
        /** Chargement du driver JDBC - Etape 1 */
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch( Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);
        }
        
        try{
            /** connexion à la base */
            String url="jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
            Connection cx = DriverManager.getConnection(url, "fasalles", "apprentis2011pw");
            Statement req = cx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            // Q1
//            String sql = "SELECT * FROM TD1";
//            ResultSet rs = req.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//            }
//            rs.close();
            
            // Q2
//            req.executeUpdate("Insert into TD1 values (masequence.nextval, 'Michel', 'Dufour', 30)");
//            req.executeUpdate("Insert into TD1 values (masequence.nextval, 'Tim', 'Cook', 52)");
           
             // Q3 A
//            String sql = "SELECT * FROM TD1";
//            ResultSet rs = req.executeQuery(sql);
//            Integer age = 0;
//            while(rs.next()){
//                if(age == 0 || rs.getInt("age")<age){
//                    age = rs.getInt("age");
//                }   
//            }
//            rs.beforeFirst();
//            while(rs.next())
//                if(age == rs.getInt("age"))
//                    System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//            rs.close();
//            // Q3 B
//            String sql = "SELECT * FROM TD1 WHERE age IN (SELECT MIN(AGE) FROM TD1)";
//            ResultSet rs = req.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//            }
//            rs.close();
            
            // Q4
//            String sql = "SELECT * FROM TD1";
//            ResultSet rs = req.executeQuery(sql);
//            while(rs.next()){
//                if(rs.getInt("age") == 30){
//                    System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//                }   
//            }
//            rs.beforeFirst();
//             while(rs.next()){
//                if(rs.getInt("age") == 40){
//                    System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//                }   
//            }
//            rs.beforeFirst();
//            while(rs.next()){
//                if(rs.getInt("age") == 50){
//                    System.out.println(rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("age"));
//                }   
//            }
//            rs.close();
            // Q4 avec procédure stocké
            CallableStatement call = cx.prepareCall("{call triAGE(?, ?, ?)}");
            call.setInt(1, 30);
            call.setInt(1, 40);
            call.setInt(1, 50);
            
            req.close();
            call.close();
            cx.close();
        } catch( Exception ex){
            System.err.println("Erreur lors de l'exécution");
            System.exit(1);     
        }
    }
}
