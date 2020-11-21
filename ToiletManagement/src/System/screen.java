/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.sql.ResultSet;
import java.sql.SQLException;
import library.assistant.database.DatabaseHandler;

/**
 *
 * @author shiva
 */
public class screen {
    public static void main(String[] args){
        logo Logo=new logo();
        Logo.setVisible(true);
        mainpage obj=new mainpage();
    try{
            for(int i=0;i<=100;i++){
                Thread.sleep(30);
                Logo.loadingnum.setText(Integer.toString(i)+"%");
                Logo.loadingbar.setValue(i);
                if(i==100){
                    Logo.setVisible(false);
                obj.setVisible(true);
                }
            }
        }catch(Exception e){
        }
    
    
    
    
    
    
    
    
    
    
    
}
}