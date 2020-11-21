/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assistant.database;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author thead
 */
public class DatabaseHandler {
    
    private static DatabaseHandler handler = null;

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    
    
    public DatabaseHandler() {
        createConnection();
        setupBookTable();
        loginTable();
        maintenancetable();
        cleantable();
        threshold();
        TL01C();
        TL02C();
        TL03C();
        TL04C();
        TL11C();
        TL12C();
        TL13C();
        TL14C();
        TL21C();
        TL22C();
        TL23C();
        TL24C();
        TL01M();
        TL02M();
        TL03M();
        TL04M();
        TL11M();
        TL12M();
        TL13M();
        TL14M();
        TL21M();
        TL22M();
        TL23M();
        TL24M();
        
    }
    
        private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
        
    
        
        
        
        
//*************CREATE TABLE  **********************************************************   
        
        void setupBookTable(){
            String TABLE_NAME="BOOK1";
            
            try{
                stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("BOOOK Exists");
                }
                else
                {
                    stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     id varchar(200) primary key,\n"
                    + "     title varchar(200),\n"
                    + "     author varchar(200),\n"
                    + "     publisher varchar(200),\n"

                    + "     isAvail boolean default true"
                    + " )");
                }
                }
            catch(SQLException e){
                System.err.println(e.getMessage() + " ..... setupDatabase");
            }   finally {
                
            }
        }
        
        
        
            void loginTable(){
            String TABLE_NAME="LOGIN";
            
            try{
                stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("LOGIN Exists");
                }
                else
                {
                    stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     Name char(30),\n"
                    + "     ID char(30) primary key,\n"
                    + "     Email_ID char(200),\n"
                    + "     Contact_Number char(200)"
                    + " )");
                }
                }
            catch(SQLException e){
                System.err.println(e.getMessage() + " ..... setupDatabase");
            }   finally {
                
            }
        }
        
            
            
                      void cleantable(){
            String TABLE_NAME="TOILET";
            
            try{
                stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TOILET Exists");
                }
                else
                {
                    stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TOILET_NUMBER char(30),\n"
                    + "     NTU_VALUES double ,\n"
                    + "     MQ2_VALUES double,\n"
                    + "     STATUS char(30)"
                    + " )");
                }
                }
            catch(SQLException e){
                System.err.println(e.getMessage() + " ..... setupDatabase");
            }   finally {
                
            }
        }  
                      
                      
                          
            
                      void maintenancetable(){
            String TABLE_NAME="MAINTENANCE";
            
            try{
                stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("MAINTENANCE Exists");
                }
                else
                {
                    stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TOILET_NUMBER char(30),\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     STATUS char(30)"
                    + " )");
                }
                }
            catch(SQLException e){
                System.err.println(e.getMessage() + " ..... setupDatabase");
            }   finally {
                
            }
        } 
        
                      
                      
            void threshold(){
            String TABLE_NAME="THRESHOLD";
            
            try{
                stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("THRESHOLD Exists");
                }
                else
                {
                    stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     MAX_NTU float,\n"
                    + "     MAX_MQ2 float"
                    + " )");
                }
                }
            catch(SQLException e){
                System.err.println(e.getMessage() + " ..... setupDatabase");
            }   finally {
                
            }
        } 
            
            
                      void TL01C(){
            String TABLE_NAME="TL01";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL01 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL01 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
        

            
                      void TL02C(){
            String TABLE_NAME="TL02";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL02 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL02 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}  
                      
  
            
                      void TL03C(){
            String TABLE_NAME="TL03";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL03 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL03 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
             
                      
     
            
                      void TL04C(){
            String TABLE_NAME="TL04";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL04 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL04 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}                  
                      
                      
 
            
                      void TL11C(){
            String TABLE_NAME="TL11";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL11 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL11 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}                      
     
  
            
                      void TL12C(){
            String TABLE_NAME="TL12";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL12 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL12 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
                      
  
            
                      void TL13C(){
            String TABLE_NAME="TL13";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL13 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL13 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
                      
    
            
                      void TL14C(){
            String TABLE_NAME="TL14";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL14 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL14 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
       
            
                      void TL21C(){
            String TABLE_NAME="TL21";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL21 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL21 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      

            
                      void TL22C(){
            String TABLE_NAME="TL22";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL22 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL22 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
  
            
                      void TL23C(){
            String TABLE_NAME="TL23";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL23 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL23 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
  
            
                      void TL24C(){
            String TABLE_NAME="TL24";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL24 Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL24 Integer,\n"
                    + "     NTU_VALUES float ,\n"
                    + "     MQ2_VALUES float,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
                      
                      
                      
                      
                      void TL01M(){
            String TABLE_NAME="TL01M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL01M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL01 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
                      
                      
                      void TL02M(){
            String TABLE_NAME="TL02M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL02M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL02 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}                       
                      
                      
                      
                       void TL03M(){
            String TABLE_NAME="TL03M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL03M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL03 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}                      
                      
                      
                        void TL04M(){
            String TABLE_NAME="TL04M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL04M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL04 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                        
                        void TL11M(){
            String TABLE_NAME="TL11M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL11M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL11 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                        
                        
                         void TL12M(){
            String TABLE_NAME="TL12M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL12M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL12 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}}                      
                      
                          void TL13M(){
            String TABLE_NAME="TL13M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL13M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL13 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                          
                        void TL14M(){
            String TABLE_NAME="TL14M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL14M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL14 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 

                      void TL21M(){
            String TABLE_NAME="TL21M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL21M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL21 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                      
                        void TL22M(){
            String TABLE_NAME="TL22M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL22M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL22 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                        
                        
                         void TL23M(){
            String TABLE_NAME="TL23M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL23M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL22 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                         
                      void TL24M(){
            String TABLE_NAME="TL24M";
            try{stmt=conn.createStatement();
                DatabaseMetaData dbm =conn.getMetaData();
                ResultSet tables =dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);
                if(tables.next()){
                    System.out.println("TL24M Exists");}
                else{stmt.execute("CREATE TABLE "+ TABLE_NAME + "(" 
                    + "     TL24 Integer,\n"
                    + "     TRASH Integer ,\n"
                    + "     TISSUE_PAPER Integer,\n"
                    + "     TOILET_PAPER Integer,\n"
                    + "     SOAP Integer,\n"
                    + "     TIME char(30)"
                    + " )");}}catch(SQLException e){System.err.println(e.getMessage() + " ..... setupDatabase");}   finally {}} 
                        
                        
//***********CREATE TABLE  **********************************************************   
   
    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }

    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        }
        finally {
        }
    }
    
    
    
    
    
    
    
    
}
