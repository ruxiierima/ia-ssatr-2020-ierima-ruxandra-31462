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
public class Sensor {
    private int value;
    public  String location;


Sensor( int value, String location){
        this.value = value;
        this.location = location; 
    }

 public int getValue() {
        return value;
    }
 
 public void setValue(int value) {
        this.value=value;
    }

    public String getLocation() {
        return location;
    }
public void setLocation(String location) {
        this.location=location;
    }

public boolean equals(Object obj) {
            if(obj instanceof Person){
                  Person p = (Person)obj;
                  return p.firstname.equalsIgnoreCase(firstname)&&p.lastname.equalsIgnoreCase(lastname);          
            }
            else return false;
      }
    

}
