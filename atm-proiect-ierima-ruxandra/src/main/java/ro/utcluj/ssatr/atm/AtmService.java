/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

import java.sql.SQLException;

public class AtmService {
    
    private DBAccess db;
    public static final int UNIT_PRICE = 2; 

    public AtmService() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }
  
    public synchronized String handleNameRegister(String name,String cardNumber, double sold) throws SQLException{
        PersonRegisterEntity c = db.findByName(name);
        System.out.println("cardNumb egal: "+!c.getCardNumber().equals(cardNumber));
        if(c==null){
            PersonRegisterEntity p = new PersonRegisterEntity(name, sold,cardNumber);
            db.insertRegister(p);
            return "New person entry: "+p.getName()+ " cardNumber: "+ p.getCardNumber()+" sold"+ p.getSold();
        }
        if (!c.getCardNumber().equals(cardNumber) || c.getSold()!=sold){
              c.setCardNumber(cardNumber);
              c.setSold(sold);
              db.updateRegister(c);
              
              return "All infos UPDATED! Name: "+ c.getName() +" cardNumb: "+ c.getCardNumber()+" Sold: "+c.getSold();
        }
        
        else{
             return "Person already registreted, no other updates need to be done";
        }
    }
    
    private int computeParkingStayPrice(long entryTime){
        //1 LEU / secunda 
        
        long crt = System.currentTimeMillis();
        return (int)(((crt - entryTime)/1000)* UNIT_PRICE);
        
    }
    
    public static void main(String[] args) throws Exception {
        AtmService a = new AtmService();
        System.out.println(a.handleNameRegister("Pop David","526987445231",250069));
 
    }
    
}