/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

public class PersonRegisterEntity {
    private String name;
    private double sold;
    private String cardNumber;

    public PersonRegisterEntity(String name, double sold,String cardNumber) {
        this.name = name;
        this.sold = sold;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public double getSold() {
        return sold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setSold(double sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "PersonRegisterEntity{" + "name=" + name + ", cardNumber=" + cardNumber + ", sold=" + sold + '}';
    }
}