/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

/**
 *
 * @author ierimaruxi
 */

public class OttoCar extends Car { //clasa derivata  
    
    public OttoCar(String name, int speed,String plateNumber) {
        super(name, speed,plateNumber); //apelare constructor din calsa de baza
    }
    
    void accelerate(){ //suprascriere metoda
        speed+=3;
        System.out.println("OttoCar car speed is "+speed);
    }
    
}