/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;
import java.util.Objects;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ierimaruxi
 */
public class CarAccess {
    private String plateNumber;
    private long accessTime; 
 
    //constructor
    CarAccess(String plateNumber, long accessTime){
        this.plateNumber = plateNumber;
        this.accessTime = accessTime; 
    }
    
    
    public String getPlateNumber(){
        return plateNumber;
      }
    public long getAccessTime(){
        return accessTime;
      }
    
    @Override
    public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    if(obj == null){
        return false;
    }
    
    if (getClass()!=obj.getClass()){
        return false;
    }
    
    final CarAccess other =(CarAccess) obj;
    if(!Objects.equals(this.plateNumber, other.plateNumber)){
        return false;
    }
    return true;
    }
    
    public boolean verifyCar(ArrayList<CarAccess> list , String plateNumber){
        for(CarAccess car:  list){
            if (plateNumber.equals(car.getPlateNumber()))
                return true;
        }
        return false;
    }
   
}