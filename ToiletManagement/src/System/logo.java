/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.TimerTask;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.awt.Graphics;  

import java.awt.*;
import java.awt.event.*;

import java.awt.Graphics;  

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library.assistant.database.DatabaseHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.proteanit.sql.DbUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.mainpage;
import library.assistant.database.DatabaseHandler;
        import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author thead
 */
public class logo extends javax.swing.JFrame {

    /**
     * Creates new form logo
     */
    public logo() {
        initComponents();
   
        
      
     DatabaseHandler databaseHandler= new DatabaseHandler();    
     
     
     
     //THRESHOLLD TABLE
int rows=0;
      String query = "select count(*) from THRESHOLD";
      //Executing the query
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      //Retrieving the result
      rs.next();
       rows = rs.getInt(1);}   
  catch (SQLException e){
            e.printStackTrace();
        }

     if(rows==0){
        float defaultntu=75;
        float defaultmq2=3000;
       
         query="insert into THRESHOLD values("+defaultntu+","+defaultmq2+")";
        System.out.println(query);
        if(databaseHandler.execAction(query)){
                       System.out.println("threshold default OK");
        }
        else{
              System.out.println("threshold default not OK");
        }
     }
     if(rows!=0)
        System.out.println("threshold table ok rows:"+rows);
    
        
      
    //TOILET TABLE 
     
   query = "select count(*) from TOILET";
     try{
      ResultSet rs =databaseHandler.execQuery(query);
      //Retrieving the result
      rs.next();
       rows = rs.getInt(1);}   
  catch (SQLException e){
            e.printStackTrace();
        }
        String name="TL01";
        double ntu=0;
        double mq2=0;
        String stat="OK";
       
        query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
     if(rows==0){
         System.out.println("TOILET TABLE NOT PRESENT CREATING........");

         name="TL01";
         ntu=53;
         mq2=999;
         stat="OK";
         query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL02";
         ntu=43;
         mq2=914;
         stat="OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL03";
         ntu=84;
         mq2=5450;
         stat="NOT OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL04";
         ntu=24;
         mq2=2908;
         stat="OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL11";
         ntu=83;
         mq2=1869;
         stat="NOT OK"; query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL12";
         ntu=97;
         mq2=6508.776;
         stat="NOT OK"; query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL13";
         ntu=23;
         mq2=3908;
         stat="NOT OK"; query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL14";
         ntu=12;
         mq2=769;
         stat="OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL21";
         ntu=67;
         mq2=5799;
         stat="NOT OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL22";
         ntu=70;
         mq2=2901;
         stat="OK";  query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL23";
         ntu=178;
         mq2=1954;
         stat="NOT OK"; query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL24";
         ntu=66;
         mq2=2353;
         stat="OK"; query="insert into TOILET values('"+name+"',"+ntu+","+mq2+",'"+stat+"')";
         databaseHandler.execAction(query);
     }
     if(rows!=0)
        System.out.println("TOILET table ok rows:"+rows);
    
     
    //Maintenance TABLE 
    
     query = "select count(*) from MAINTENANCE";
     try{
      ResultSet rs =databaseHandler.execQuery(query);
      //Retrieving the result
      rs.next();
       rows = rs.getInt(1);}   
  catch (SQLException e){
            e.printStackTrace();
        }
         
int tr=0;
int ti=0;
int to=0;
int s=0;

        
        query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
     if(rows==0){
         System.out.println("MAINTENANCE TABLE NOT PRESENT CREATING........");

         name="TL01";
         tr=73;
         ti=46;
         to=23;
         s=28;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL02";
         tr=21;
         ti=23;
         to=38;
         s=76;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL03";
         tr=056;
         ti=045;
         to=89;
         s=024;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL04";
         tr=99;
         ti=9;
         to=5;
         s=35;
         stat="NOT OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL11";
         tr=67;
         ti=23;
         to=42;
         s=89;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL12";
         tr=45;
         ti=78;
         to=78;
         s=94;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL13";
         tr=67;
         ti=13;
         to=71;
         s=41;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL14";
         tr=34;
         ti=6;
         to=71;
         s=75;
         stat="NOT OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL21";
         tr=3;
         ti=55;
         to=94;
         s=11;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL22";
         tr=100;
         ti=89;
         to=45;
         s=32;
         stat="NOT OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         
         name="TL23";
         tr=94;
         ti=93;
         to=82;
         s=20;
         stat="NOT OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
         
         name="TL24";
         tr=34;
         ti=51;
         to=26;
         s=60;
         stat="OK";
         query="insert into  MAINTENANCE values('"+name+"',"+tr+","+ti+","+to+","+s+",'"+stat+"')";
         databaseHandler.execAction(query);
     }
     if(rows!=0)
        System.out.println("MAINTENANCE table ok rows:"+rows);
    
    
     
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        loadingnum = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 0, 153));

        loadingnum.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        loadingnum.setForeground(new java.awt.Color(255, 255, 255));
        loadingnum.setText("99%");
        loadingnum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        loadingbar.setBackground(new java.awt.Color(255, 255, 255));
        loadingbar.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/logo795,770white.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(641, 641, 641)
                .addComponent(loadingnum)
                .addContainerGap(1219, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1184, 1184, 1184))
            .addComponent(loadingbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1907, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(150, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(401, 401, 401)))
                .addComponent(loadingnum, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1312, 765));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                logo x= new logo();
                x.setVisible(true);
                
            int i=0;
            int y=0;
            while(y<100000000){
while(i<1000000){
    for(int j=0;j<100000000;j++){}
    i++;
}
y++;}


            x.setVisible(false);

mainpage obj= new mainpage();
obj.setVisible(true);

            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    public javax.swing.JProgressBar loadingbar;
    public javax.swing.JLabel loadingnum;
    // End of variables declaration//GEN-END:variables
}
