/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
    private Connection conn;
    
    public DBAccess() throws ClassNotFoundException, SQLException {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection("jdbc:derby://localhost/atm;create=false","APP","APP");
    }
   
    public void insertRegister(PersonRegisterEntity e) throws SQLException{
        Statement s = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BANKCARD " 
    + "(NAME, CARDNUMBER, SOLD) VALUES (?, ?, ?)");
        pstmt.setString(1, e.getName());
        pstmt.setString(2, e.getCardNumber());
        pstmt.setDouble(3, e.getSold());
        pstmt.executeUpdate();
       // s.executeUpdate("INSERT INTO BANKCARD VALUES ('"+e.getName()+"','"+e.getCardNumber()+"', "+e.getSold()+")");        
        s.close();
    }
    
    public void updateRegister(PersonRegisterEntity e) throws SQLException{
        Statement s = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE BANKCARD "+ "SET CARDNUMBER = ?, SOLD=?"+"WHERE NAME = ?");
        pstmt.setString(1, e.getCardNumber());
        pstmt.setDouble(2, e.getSold());
        pstmt.setString(3, e.getName());
        pstmt.executeUpdate();
        s.close();
    }
    
    public void updateSold(PersonRegisterEntity e) throws SQLException{
        Statement s = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE BANKCARD "+ "SET SOLD=?"+"WHERE NAME = ?");
        pstmt.setDouble(1, e.getSold());
        pstmt.setString(2, e.getName());
        pstmt.executeUpdate();
        s.close();
    }
    
    public PersonRegisterEntity findByName(String name) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM BANKCARD WHERE NAME='"+name+"'");
        if(rs.next()){
            return new PersonRegisterEntity(rs.getString("name"), rs.getDouble("sold"), rs.getString("cardNumber"));
        }else{
            return null;
        }           
    }
    
    public void deleteByName(String name) throws SQLException{
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM BANKCARD WHERE NAME='"+name+"'");   
        s.close();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBAccess db = new DBAccess();
        PersonRegisterEntity result = db.findByName("Pop David");
        System.out.println(result);
        if(result!=null){
            db.deleteByName(result.getName());
            System.out.println("Entry deleted!");
        }else{
            System.out.println("Entry not found!");
        }
        
    }
}