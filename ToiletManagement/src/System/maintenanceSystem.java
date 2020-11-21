/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import javax.swing.JPanel;

import java.awt.Graphics;  

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;



import System.maintenanceSystem;
import System.cleaningSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
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
        import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author thead
 */
public class maintenanceSystem extends javax.swing.JFrame {

    /**
     * Creates new form maintenanceSystem
     */
    public maintenanceSystem() {
        initComponents();
        
           time_delay=1;
      init_time_hours=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);;
     init_time_minutes=Calendar.getInstance().get(Calendar.MINUTE);
System.out.println(init_time_hours);  
System.out.println(init_time_minutes);   

           DatabaseHandler databaseHandler= new DatabaseHandler();   
           
           
    String ok="OK";
 String notok="NOT OK";

                 String DB_URL = "jdbc:derby:database;create=true";
   conobj = null;
        String query="SELECT * FROM MAINTENANCE";
 try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conobj = DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        try {  

            resobj=databaseHandler.execQuery(query);  
       
        while(resobj.next()){
                String number= resobj.getString(1);
                double trashvalue = resobj.getDouble(2);
                double tissue=resobj.getDouble(3);
                double toilet = resobj.getDouble(4);
                double soapx = resobj.getDouble(5);               
                String statusx = resobj.getString(6); 
      
         
                if(trashvalue<90.00 && tissue>10 && toilet>10 && soapx>10)                               
               {
       query="UPDATE MAINTENANCE SET STATUS=? WHERE TOILET_NUMBER=?";
       PreparedStatement statement =conobj.prepareStatement(query);
       statement.setString(1,ok);
       statement.setString(2,number);
       int rows=statement.executeUpdate();
                   if(rows>0)
                       System.out.println("OK");
                }
                else{
            query="UPDATE MAINTENANCE SET STATUS=? WHERE TOILET_NUMBER=?";
       PreparedStatement statement =conobj.prepareStatement(query);
       statement.setString(1,notok);
       statement.setString(2,number);
       int rows=statement.executeUpdate();
                   if(rows>0)
                       System.out.println("NOT OK");    
            }    
         }           
query="   SELECT * FROM MAINTENANCE ORDER BY STATUS ASC";
             resobj=databaseHandler.execQuery(query);  
          jTable1.setModel(DbUtils.resultSetToTableModel(resobj));
         resobj.close();}
        
        catch (SQLException e){
            e.printStackTrace();
        }
        
        
                query="SELECT * FROM TL01M";
                   resobj=databaseHandler.execQuery(query);  
          jTable2.setModel(DbUtils.resultSetToTableModel(resobj));

        
        
   
        
  //button     1   
        try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL01'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a1.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL01'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a1.setBackground(new java.awt.Color(0, 255, 64));      }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
        
        
        
        
        
        
  //button     2   
           try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL02'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a2.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL02'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a2.setBackground(new java.awt.Color(0, 255, 64));      }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
      //button     3  
           try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL03'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a3.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL03'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a3.setBackground(new java.awt.Color(0, 255, 64));     }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
          //button     4  
        try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL04'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a4.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL04'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a4.setBackground(new java.awt.Color(0, 255, 64));       }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
          //button     5  
       try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL11'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a5.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL11'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a5.setBackground(new java.awt.Color(0, 255, 64));      }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
        
        
          //button     6   
          try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL12'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a6.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL12'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a6.setBackground(new java.awt.Color(0, 255, 64));     }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
               //button     7   
           try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL13'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a7.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL13'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a7.setBackground(new java.awt.Color(0, 255, 64));        }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
               //button     8   
         try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL14'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a8.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL14'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a8.setBackground(new java.awt.Color(0, 255, 64));       }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
               //button     9   
         try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL21'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a9.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL21'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a9.setBackground(new java.awt.Color(0, 255, 64));       }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
               //button     10   
        try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL22'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a10.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL22'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a10.setBackground(new java.awt.Color(0, 255, 64));       }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
        
               //button     11   
       try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL23'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a11.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL23'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a11.setBackground(new java.awt.Color(0, 255, 64));      }   
        catch (SQLException e){
            e.printStackTrace();                }
        
        
        
        
        
               //button     12   
        try {    resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL24'and MAINTENANCE.STATUS='NOT OK'");
            if(resobj.next())
               a12.setBackground(new java.awt.Color(255, 0, 0));
            resobj=databaseHandler.execQuery("SELECT * FROM MAINTENANCE where MAINTENANCE.TOILET_NUMBER='TL24'and MAINTENANCE.STATUS='OK'");
            if(resobj.next())
               a12.setBackground(new java.awt.Color(0, 255, 64));     }   
        catch (SQLException e){
            e.printStackTrace();                }

        
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
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        a1 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        a4 = new javax.swing.JButton();
        a5 = new javax.swing.JButton();
        a6 = new javax.swing.JButton();
        a7 = new javax.swing.JButton();
        a8 = new javax.swing.JButton();
        a9 = new javax.swing.JButton();
        a10 = new javax.swing.JButton();
        a11 = new javax.swing.JButton();
        a12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jPanel2.setBackground(new java.awt.Color(70, 70, 70));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/home.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(70, 70, 70));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Maintenance System");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Home");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cleaning System");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Update Info");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Login");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Menu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Hygiene Config");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addComponent(jLabel12)
                .addGap(37, 37, 37))
        );

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/menu.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/mainten.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/clean.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/loginsmall.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/updatesmall.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/settings.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setVisible(false);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(23, 35, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Maintenance System");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/quit.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Toilet Number", "trwash", "tissue", "troll", "soap", "time"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Toilet Number", "trwash", "tissue", "troll", "soap"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jPanel5.setBackground(new java.awt.Color(0, 204, 153));

        a1.setBackground(new java.awt.Color(0, 0, 0));
        a1.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a1.setText("TL01");
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });

        a2.setBackground(new java.awt.Color(0, 0, 0));
        a2.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a2.setText("TL02");
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });

        a3.setBackground(new java.awt.Color(0, 0, 0));
        a3.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a3.setText("TL03");
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });

        a4.setBackground(new java.awt.Color(0, 0, 0));
        a4.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a4.setText("TL04");
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });

        a5.setBackground(new java.awt.Color(0, 0, 0));
        a5.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a5.setText("TL11");
        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });

        a6.setBackground(new java.awt.Color(0, 0, 0));
        a6.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a6.setText("TL12");
        a6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a6ActionPerformed(evt);
            }
        });

        a7.setBackground(new java.awt.Color(0, 0, 0));
        a7.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a7.setText("TL13");
        a7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a7ActionPerformed(evt);
            }
        });

        a8.setBackground(new java.awt.Color(0, 0, 0));
        a8.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a8.setText("TL14");
        a8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a8ActionPerformed(evt);
            }
        });

        a9.setBackground(new java.awt.Color(0, 0, 0));
        a9.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a9.setText("TL21");
        a9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a9ActionPerformed(evt);
            }
        });

        a10.setBackground(new java.awt.Color(0, 0, 0));
        a10.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a10.setText("TL22");
        a10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a10ActionPerformed(evt);
            }
        });

        a11.setBackground(new java.awt.Color(0, 0, 0));
        a11.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a11.setText("TL23");
        a11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a11ActionPerformed(evt);
            }
        });

        a12.setBackground(new java.awt.Color(0, 0, 0));
        a12.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        a12.setText("TL24");
        a12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a12ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ground Floor");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("1st Floor");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2nd Floor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(a10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(a7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(a8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(a7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(a12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(a11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(a10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(a9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("NOTIFY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(98, 98, 98)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setBackground(new java.awt.Color(67,80,76));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);
        mainpage obj=new mainpage();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(jPanel3.isVisible()==false)
        {jPanel3.setVisible(true);}

        else if (jPanel3.isVisible()==true)
        {jPanel3.setVisible(false);}
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.setVisible(false);
        cleaningSystem obj=new cleaningSystem();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        this.setVisible(false);
        login obj=new login();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        this.setVisible(false);
        updateinfo2 obj=new updateinfo2();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.setVisible(false);
        hygieneConfig obj=new hygieneConfig();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL01M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL02M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL03M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
      DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL04M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a4ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL11M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a5ActionPerformed

    private void a6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a6ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL12M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a6ActionPerformed

    private void a7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a7ActionPerformed
       DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL13M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a7ActionPerformed

    private void a8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a8ActionPerformed
   DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL14M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a8ActionPerformed

    private void a9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a9ActionPerformed
       DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL21M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a9ActionPerformed

    private void a10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a10ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL22M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a10ActionPerformed

    private void a11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a11ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL23M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a11ActionPerformed

    private void a12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a12ActionPerformed
  DatabaseHandler databaseHandler= new DatabaseHandler();   
    String query="SELECT * FROM TL24M";
    resobj=databaseHandler.execQuery(query);
    jTable2.setModel(DbUtils.resultSetToTableModel(resobj));
    }//GEN-LAST:event_a12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JOptionPane.showMessageDialog(this,"STAFF NOTIFIED");
        try{ Thread.sleep(1500);  }
        catch(Exception e){}

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        //change color of buttions
        a1.setBackground(new java.awt.Color(0, 255, 64));

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        a2.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(100);  }
        catch(Exception e){}
        a3.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(2500);  }
        catch(Exception e){}
        a4.setBackground(new java.awt.Color(0, 255, 64));

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        a5.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(100);  }
        catch(Exception e){}
        a6.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(1000);  }
        catch(Exception e){}
        a7.setBackground(new java.awt.Color(0, 255, 64));

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        a8.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(100);  }
        catch(Exception e){}
        a9.setBackground(new java.awt.Color(0, 255, 64));

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        a10.setBackground(new java.awt.Color(0, 255, 64));
        try{ Thread.sleep(1000);  }
        catch(Exception e){}
        a11.setBackground(new java.awt.Color(0, 255, 64));

        try{ Thread.sleep(55);  }
        catch(Exception e){}
        a12.setBackground(new java.awt.Color(0, 255, 64));
        
        
                  DatabaseHandler databaseHandler= new DatabaseHandler();   
           
           
    String ok="OK";
 String notok="NOT OK";

                 String DB_URL = "jdbc:derby:database;create=true";
   conobj = null;
        String query="SELECT * FROM MAINTENANCE";
 try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conobj = DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        try {  

            resobj=databaseHandler.execQuery(query);  
       
        while(resobj.next()){
                String number= resobj.getString(1);
                double trashvalue = resobj.getDouble(2);
                double tissue=resobj.getDouble(3);
                double toilet = resobj.getDouble(4);
                double soapx = resobj.getDouble(5);               
                String statusx = resobj.getString(6); 
         System.out.println(number+"   "+tissue+"    "+toilet+"     "+soapx);
         
                if(true)                               
               {         Random rand = new Random();  int z=0; 
       query="UPDATE MAINTENANCE SET STATUS=? , TRASH=? , TISSUE_PAPER =? , TOILET_PAPER =? , SOAP =? WHERE TOILET_NUMBER=?";
       PreparedStatement statement =conobj.prepareStatement(query);
       statement.setString(1,ok);
       statement.setInt(2,0);
       statement.setInt(3,200);
       statement.setInt(4,300);
       statement.setInt(5,70);
       statement.setString(6,number);
       int rows=statement.executeUpdate();
                   if(rows>0)
                       System.out.println("OK");
                }
    
         }           
query="   SELECT * FROM MAINTENANCE ORDER BY STATUS ASC";
             resobj=databaseHandler.execQuery(query);  
          jTable1.setModel(DbUtils.resultSetToTableModel(resobj));
        
         query="insert into TL01M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
        query="insert into TL02M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL03M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL04M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL11M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL12M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL13M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL14M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL21M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL22M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL23M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
                
                
        query="insert into TL24M values(0,0,0,0,0,'TOILET REFRESHED')";
                databaseHandler.execAction(query) ;
        
        
        
        
        
        
        
        }
        
        catch (SQLException e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
         if(jPanel3.isVisible()==true)
                {jPanel3.setVisible(true);}
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
       if(jPanel3.isVisible()==true)
                {jPanel3.setVisible(false);}
    }//GEN-LAST:event_jPanel3MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DatabaseHandler databaseHandler= new DatabaseHandler();  
     
     
     ref_time_hours=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);;
     ref_time_minutes=Calendar.getInstance().get(Calendar.MINUTE);
     System.out.println(ref_time_hours);  
System.out.println(ref_time_minutes);  

int time_elapsed =(ref_time_hours-init_time_hours)*60+ Math.abs(ref_time_minutes-init_time_minutes);
int rows_add=time_elapsed/time_delay;

int htemp=init_time_hours;
int mtemp=init_time_minutes;
//******CODE FOR TABLE INSERTION STARTS HERE*************************
int rows=0;
      String query = "select count(*) from TL01M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
    //instance of random class
       Random rand = new Random(); 
 //CHANGE HERE********************************//    
      int upperboundtr = 100; int upperboundti=200; int upperboundto=300; int upperbounds=70;   
      int int_random;
     
            
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
     if(i+1==rows_add){
         mttr1=tr;
         mtti1=ti;
         mtto1=to;
         mtso1=sp;
    }
        query="insert into TL01M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
      //query="insert into TL02M values("+rows+","+n+","+m+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************


//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL02M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
   
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     if(i+1==rows_add){
         mttr2=tr;
         mtti2=ti;
         mtto2=to;
         mtso2=sp;
    }
  query="insert into TL02M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************



//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL03M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
            
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
   
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
   if(i+1==rows_add){
         mttr3=tr;
         mtti3=ti;
         mtto3=to;
         mtso3=sp;
    }  
  query="insert into TL03M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************




//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL04M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
            
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
    if(i+1==rows_add){
         mttr4=tr;
         mtti4=ti;
         mtto4=to;
         mtso4=sp;
    } 
  query="insert into TL04M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************




//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL11M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
     if(i+1==rows_add){
         mttr5=tr;
         mtti5=ti;
         mtto5=to;
         mtso5=sp;
    }
  query="insert into TL11M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************


//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL12M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;

//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
    if(i+1==rows_add){
         mttr6=tr;
         mtti6=ti;
         mtto6=to;
         mtso6=sp;
    } 
  query="insert into TL12M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************



//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL13M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
            
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
     if(i+1==rows_add){
         mttr7=tr;
         mtti7=ti;
         mtto7=to;
         mtso7=sp;
    }
  query="insert into TL13M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************




//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL14M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
    if(i+1==rows_add){
         mttr8=tr;
         mtti8=ti;
         mtto8=to;
         mtso8=sp;
    } 
  query="insert into TL14M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************


//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL21M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
    if(i+1==rows_add){
         mttr9=tr;
         mtti9=ti;
         mtto9=to;
         mtso9=sp;
    } 
  query="insert into TL21M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************



//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL22M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;

//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
   if(i+1==rows_add){
         mttr10=tr;
         mtti10=ti;
         mtto10=to;
         mtso10=sp;
    }  
  query="insert into TL22M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************


//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL23M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 

//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
     if(i+1==rows_add){
         mttr11=tr;
         mtti11=ti;
         mtto11=to;
         mtso11=sp;
    } 
  query="insert into TL23M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************




//******CODE FOR TABLE INSERTION STARTS HERE*************************
 rows=0;
       query = "select count(*) from TL24M";
      try{
      ResultSet rs =databaseHandler.execQuery(query);
      rs.next();
       rows = rs.getInt(1);}   catch (SQLException e){e.printStackTrace();}
      rows=rows+1;
 
        
//=======================NUMBER OF ROWS ADDITION======================
for(int i=0;i<rows_add;i++){
    
//--------------TIME VARIAABLE--------------------------
     String time=""; 
      String h=String.valueOf(init_time_hours) ;
   time=time.concat(h);
time=time+":";
String mi=String.valueOf(init_time_minutes) ;
time=time.concat(mi);
time=time+":";
String s=String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    time=time.concat(s);
    
 time=time+"  ";   
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date dateobj = new Date();
      time=time.concat(df.format(dateobj)); 
//--------------TIME VARIAABLE--------------------------
    
  
      int_random = rand.nextInt(upperboundtr); 
      int tr=int_random;
                       
      int_random = rand.nextInt(upperboundti); 
      int ti=int_random;
   
      int_random = rand.nextInt(upperboundto); 
      int to=int_random; 
      
      int_random = rand.nextInt(upperbounds); 
      int sp=int_random; 
     
   if(i+1==rows_add){
         mttr12=tr;
         mtti12=ti;
         mtto12=to;
         mtso12=sp;
    }   
  query="insert into TL24M values("+rows+","+tr+","+ti+","+to+","+sp+",'"+time+"')";
   databaseHandler.execAction(query) ;
    
     rows=rows+1;
    if(init_time_minutes+time_delay<59)
         init_time_minutes=init_time_minutes+time_delay;
    else
    {init_time_minutes=0;  init_time_hours=init_time_hours+1;}
}
init_time_hours=htemp;
init_time_minutes=mtemp;
//=======================NUMBER OF ROWS ADDITION======================
//******CODE FOR TABLE ENDS HERE*************************************



//UPDATE CLEAN TABLE AFTER REFRESHING

      
                 String DB_URL = "jdbc:derby:database;create=true";
   conobj = null;
         query="SELECT * FROM MAINTENANCE";
 try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conobj = DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
 
 String number="";

 
 int  replacemttr=0;
 int  replacemtti=0;
 int  replacemtto=0;
 int  replacemtso=0;
 

        try {  
      
          resobj=databaseHandler.execQuery(query);  
            int i=1;   
           
        while(resobj.next()){
            
            if(i==1)
            { number="TL01";
            replacemttr=mttr1;
            replacemtti=mtti1;
            replacemtto=mtto1;
            replacemtso=mtso1;
            }
            
            else if(i==2)
            { number="TL02";
            replacemttr=mttr2;
            replacemtti=mtti2;
            replacemtto=mtto2;
            replacemtso=mtso2;
            }
            else if(i==3)
            { number="TL03";
            replacemttr=mttr3;
            replacemtti=mtti3;
            replacemtto=mtto3;
            replacemtso=mtso3;
            }
            else if(i==4)
            { number="TL04";
            replacemttr=mttr4;
            replacemtti=mtti4;
            replacemtto=mtto4;
            replacemtso=mtso4;
            }
            else if(i==5)
            { number="TL11";
            replacemttr=mttr5;
            replacemtti=mtti5;
            replacemtto=mtto5;
            replacemtso=mtso5;
            }
            else if(i==6)
            { number="TL12";
            replacemttr=mttr6;
            replacemtti=mtti6;
            replacemtto=mtto6;
            replacemtso=mtso6;
            }
            else if(i==7)
            { number="TL13";
            replacemttr=mttr7;
            replacemtti=mtti7;
            replacemtto=mtto7;
            replacemtso=mtso7;
            }
            else if(i==8)
            { number="TL14";
            replacemttr=mttr8;
            replacemtti=mtti8;
            replacemtto=mtto8;
            replacemtso=mtso8;
            }
            else if(i==9)
            { number="TL21";
            replacemttr=mttr9;
            replacemtti=mtti9;
            replacemtto=mtto9;
            replacemtso=mtso9;
            }
            else if(i==10)
            { number="TL22";
            replacemttr=mttr10;
            replacemtti=mtti10;
            replacemtto=mtto10;
            replacemtso=mtso10;
            }
            else if(i==11)
            { number="TL23";
            replacemttr=mttr11;
            replacemtti=mtti11;
            replacemtto=mtto11;
            replacemtso=mtso11;
            }
            else if(i==12)
            { number="TL24";
            replacemttr=mttr12;
            replacemtti=mtti12;
            replacemtto=mtto12;
            replacemtso=mtso12;
            }
            
       
        
       query="UPDATE MAINTENANCE SET TRASH=? , TISSUE_PAPER =? , TOILET_PAPER =? , SOAP =? WHERE TOILET_NUMBER=?";
       PreparedStatement statement =conobj.prepareStatement(query);
       statement.setInt(1,replacemttr);
       statement.setInt(2,replacemtti);
       statement.setInt(3,replacemtto);
       statement.setInt(4,replacemtso);
       statement.setString(5,number);
       rows=statement.executeUpdate();
                   if(rows>0)
                       System.out.println("OK");

            i=i+1; 
         }
             
        }
        
        catch (SQLException e){
            e.printStackTrace();
        }






init_time_hours=ref_time_hours;
init_time_minutes=ref_time_minutes;

this.setVisible(false); new maintenanceSystem().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(maintenanceSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maintenanceSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maintenanceSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maintenanceSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maintenanceSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a1;
    private javax.swing.JButton a10;
    private javax.swing.JButton a11;
    private javax.swing.JButton a12;
    private javax.swing.JButton a2;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton a5;
    private javax.swing.JButton a6;
    private javax.swing.JButton a7;
    private javax.swing.JButton a8;
    private javax.swing.JButton a9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

 public  Connection conobj ; 
 public  Statement statobj ;
 public  ResultSet  resobj;

 
  
 public double tn;
     
 public double tm;
     
 public int init_time_hours;
public int init_time_minutes;

public int ref_time_hours;
public int ref_time_minutes;

public int time_delay ;

public int mttr1;
public int mtti1;
public int mtto1;
public int mtso1;
 
public int mttr2;
public int mtti2;
public int mtto2;
public int mtso2;
 
public int mttr3;
public int mtti3;
public int mtto3;
public int mtso3;
 
public int mttr4;
public int mtti4;
public int mtto4;
public int mtso4;
 
public int mttr5;
public int mtti5;
public int mtto5;
public int mtso5;

public int mttr6;
public int mtti6;
public int mtto6;
public int mtso6;
 
public int mttr7;
public int mtti7;
public int mtto7;
public int mtso7;
 
public int mttr8;
public int mtti8;
public int mtto8;
public int mtso8;
 
public int mttr9;
public int mtti9;
public int mtto9;
public int mtso9;
 
public int mttr10;
public int mtti10;
public int mtto10;
public int mtso10;
 
public int mttr11;
public int mtti11;
public int mtto11;
public int mtso11;
 
public int mttr12;
public int mtti12;
public int mtto12;
public int mtso12;
 

 
 

}
