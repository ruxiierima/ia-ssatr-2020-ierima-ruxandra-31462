/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

/**
 *
 * @author ierimaruxi
 */
public class CarLog {
    private String plateNumber;
    private long entryTime;
    private long exitTime;
    
    public CarLog(String plateNumber, long entryTime,long exitTime){
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
    
    public long getExitTime() {
        return exitTime;
    }


}
