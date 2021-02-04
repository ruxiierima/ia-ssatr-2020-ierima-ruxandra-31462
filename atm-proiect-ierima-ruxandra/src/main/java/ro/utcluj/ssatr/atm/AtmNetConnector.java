/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.atm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


public class AtmNetConnector {
    
    AtmService aService;

    public AtmNetConnector() throws ClassNotFoundException, SQLException {
        aService = new AtmService();
    }
    
    public void startServer(){
        
        try{
        
        ServerSocket ss =new ServerSocket(4050);
        
        while(true){
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");
            //...... 
            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
            //......
            String line = "";
            //while(!line.equals("close connection")){
                String name = fluxIn.readLine();
                String cardNumber = fluxIn.readLine();
                double sold = Double.parseDouble(fluxIn.readLine());
                String result = aService.handleNameRegister(name,cardNumber,sold);
                fluxOut.println(result);
            //}

            s.close();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AtmNetConnector netCon = new AtmNetConnector();
        netCon.startServer();
    }
}