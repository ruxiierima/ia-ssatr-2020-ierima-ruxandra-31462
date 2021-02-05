/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

import java.sql.SQLException;

public class AtmService {
    
    private DBAccess db;

    public AtmService() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }
  
    public synchronized String handleNameRegister(String name,String cardNumber, double sold) throws SQLException{
        BankAccount c = db.findByName(name);
        
        if(c==null){
            BankAccount p = new BankAccount(name, sold,cardNumber);
            db.insertRegister(p);
            return "Bank Account created, name: "+p.getName()+ " cardNumber: "+ p.getCardNumber()+" sold: "+ p.getSold();
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
    public synchronized String deletEntity(String name) throws SQLException{
           BankAccount c = db.findByName(name);
           if(c!=null){
           db.deleteByName(name);
           return "Bank account DELETED";
           }
           else{
           return " Banck account with name: "+name+" does NOT exist!";
           }
        
    }
    
     public synchronized String updateSold(String name, double sold, boolean add_money) throws SQLException{
           BankAccount c = db.findByName(name);
           if(c!=null){
               double currentSold=c.getSold();
            if(add_money){
                c.setSold(currentSold+sold);
            }
            else{
                if(sold<=currentSold){
                    c.setSold(currentSold-sold);
                }
                else{
                    return "NOT ENOUGH MONEY! Current Sold:"+ currentSold;
                        }
            }
           db.updateSold(c);
           return "SOLD UPDATED";
           }
           else{
           return "BANK ACCOUNT NOT REGISTERED!";
           }
        
    }
    
    
    
    
    public static void main(String[] args) throws Exception {
        AtmService a = new AtmService();
        System.out.println(a.handleNameRegister("Pop David","526987445231",250069));
    }
    
}