/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;
import static System.register.loginMail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JPanel;

import java.awt.Graphics;  

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
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
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.proteanit.sql.DbUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author thead
 */
public class updateinfo extends javax.swing.JFrame {

    /**
     * Creates new form updateinfo
     */
    public updateinfo() {
        initComponents();
          setBackground(new Color(0, 0,0, 220));
        idconfirm=0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 153, 204));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/quit.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(100, 100, 100));
        jTextField1.setText("Name");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(100, 100, 100));
        jTextField2.setText("ID");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(100, 100, 100));
        jTextField5.setText("Email ID");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/tickwhite.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(23, 35, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Update Info");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/updateinfo.png"))); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(100, 100, 100));
        jTextField4.setText("Contact Number");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(100, 100, 100));
        jTextField3.setText("Email ID");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/goright.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 254, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(101, 101, 101))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(127, 127, 127)))
                    .addComponent(jLabel1))
                .addGap(248, 248, 248))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/resourses/back - Copy.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Update Account");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Update the personal Information ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter your registered ID to verify then  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();

        mainpage back=new mainpage();
        back.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
        jTextField1.setForeground(new  java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
        jTextField2.setForeground(new  java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        jTextField3.setText("");
        jTextField3.setForeground(new  java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setText("");
        jTextField4.setForeground(new  java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      DatabaseHandler databaseHandler= new DatabaseHandler();
     if(idconfirm==1 ){ 
         System.out.println(username+password+email1+cont1); 
           
        String Verify=JOptionPane.showInputDialog("Confirm Update : Enter ID");
        
        int y=0;
         System.out.println("DELETE READY............"+Verify);
      String queryr= "DELETE FROM LOGIN WHERE LOGIN.ID ='"+Verify+"'"; 
     if(databaseHandler.execAction(queryr)){
         y=0;
     }
     else
         y=1;
     
        
     
            

         if(y==0){
         username = jTextField1.getText().trim();          
         email1= jTextField3.getText().trim();
         cont1= jTextField4.getText().trim();
            
         
        String  query="INSERT INTO LOGIN VALUES("
                + "'" + username + "',"
                + "'" + password + "',"
                + "'" + email1 + "',"
                + "'" + cont1 + "'"
               + ")";
      //  query="insert into LOGIN values('"+name+"','"+id+"','"+email+"','"+cont+"')";
        System.out.println(query);
        if(databaseHandler.execAction(query));
       
    
          //SEND MAIL TO USER LOGIN DETAILS
            try {loginMail(email1,username,password,cont1);
                 } catch (Exception ex) {
                      Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);}
       
        JOptionPane.showMessageDialog(this,"Record Updated! Check registered Email ID");            }
         
         else
             JOptionPane.showMessageDialog(this,"Error: Update");    
             
  
     }
        else 
        JOptionPane.showMessageDialog(this,"Not Logged In");   

  
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        DatabaseHandler databaseHandler= new DatabaseHandler(); 
        email1= jTextField5.getText().trim();
        password= jTextField2.getText().trim();
        idconfirm=0;
       
       String query="SELECT * FROM LOGIN where LOGIN.ID='"+password+"' and LOGIN.EMAIL_ID='"+email1+"'";

        try {
         ResultSet resobj=databaseHandler.execQuery(query);
         if(resobj.next()){
                String name = resobj.getString(1).trim();
                String id = resobj.getString(2).trim();
                String email = resobj.getString(3).trim();
                String  cont = resobj.getString(4).trim();

                System.out.println(name+id+email+cont);
                    JOptionPane.showMessageDialog(this,"Logged In Now Update");
                    idconfirm=1;
                    
                     jTextField1.setText(name);
                     
                     jTextField3.setText(email);
                     jTextField4.setText(cont);
                     
                     
             username=jTextField1.getText().trim();          
         email1= jTextField3.getText().trim();
         cont1= jTextField4.getText().trim();
        
       resobj.close();
                }
                
                
                else
        {
         JOptionPane.showMessageDialog(this,"Wrong ID");  idconfirm=0; 
        }
 

            }
        

        catch (SQLException e){
            e.printStackTrace();
        }


        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        jTextField5.setText("");
        jTextField5.setForeground(new  java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(updateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateinfo().setVisible(true);
            }
        });
    }

    
    
       
public static void sendMail(String recepient,String name,int mode) throws Exception
{
    System.out.println(" PREPARING TO SEND EMAIL");
    Properties props=new Properties();
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.port","587");
    String myAccountEmail="stmsystem17@gmail.com";
    String password="STF2019144";
    Session session = Session.getInstance(props,new Authenticator()
    {
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(myAccountEmail,password);
        }
    });
    Message message=prepareMessage(session,myAccountEmail,recepient,name,mode);
    Transport.send(message);
    System.out.println("MESSAGE SENT SUCCESSIVELY");
}
private static Message prepareMessage(Session session,String myAccountEmail,String recepient,String name,int mode){
    try
    {
    Message message= new MimeMessage(session);
    message.setFrom(new InternetAddress(myAccountEmail));
    message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
    message.setText("Dear "+name+",\nThank you for getting in touch!\r\n" + 
    		"We appreciate you on registering into our Smart Toilet Management System.\n\r"+
    		"VERIFICATION CODE : "+ mode + "\r\n" +
    		"\r\n" + 
                "\r\n" +
                "\r\n" +
                "\r\n" +
    		"This project is created by\r\n" + 
    		"IIT2019104 - Harshal Meshram (GROUP REPRESENTATIVE),\r\n" + 
    		"IIT2019107 - Shivansh Gupta,\r\n" +
    		"IIT2019128 - Saloni Thakral ,\r\n" + 
    		"IIT2019144 - Aditya Kumar,\r\n" + 
    		"From IIIT Allahabad.\r\n\n" +
                "Contact Us:stmsystem17@gmail.com\r\n\n" +
    		"Thanking you for your time, Have a great day ahead!");
    message.setSubject("Registration Successfull");
    return  message;
}
 catch (Exception ex)
 {
       Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}





public static void loginMail(String recepient,String name,String id,String cont) throws Exception
{
    System.out.println(" PREPARING TO SEND EMAIL");
    Properties props=new Properties();
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.port","587");
    String myAccountEmail="stmsystem17@gmail.com";
    String password="STF2019144";
    Session session = Session.getInstance(props,new Authenticator()
    {
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(myAccountEmail,password);
        }
    });
    Message message=prepareMessage(session,myAccountEmail,recepient,name,id,cont);
    Transport.send(message);
    System.out.println("MESSAGE SENT SUCCESSIVELY");
}
private static Message prepareMessage(Session session,String myAccountEmail,String recepient,String name,String id,String cont){
    try
    {
    Message message= new MimeMessage(session);
    message.setFrom(new InternetAddress(myAccountEmail));
    message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
    message.setText("Dear "+name+",\nWelcome To Smart Toilet Management System!\r\n" + 
    		"PERSONAL INFORMATIONS.\n\r"+
                "Name: "+ name + "\r\n" +
                "ID: "+ id + "\r\n" +
                "Email ID: "+ recepient + "\r\n" +
                "Contact Number ID: "+ cont + "\r\n" +
    		"\r\n" + 
                "\r\n" +
                "\r\n" +
                "\r\n" +
    		"This project is created by\r\n" + 
    		"IIT2019104 - Harshal Meshram (GROUP REPRESENTATIVE),\r\n" + 
    		"IIT2019107 - Shivansh Gupta,\r\n" +
    		"IIT2019128 - Saloni Thakral ,\r\n" + 
    		"IIT2019144 - Aditya Kumar,\r\n" + 
    		"From IIIT Allahabad.\r\n\n" +
                "Contact Us:stmsystem17@gmail.com\r\n\n" +
    		"Thanking you for your time, Have a great day ahead!");
    message.setSubject("Registration Successfull");
    return  message;
}
 catch (Exception ex)
 {
       Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
public int idconfirm;
public String username;
public String password;
public String email1;
public String cont1;

 public  Connection conobj ; 
 public  Statement statobj ;
 public  ResultSet  resobj;
}
