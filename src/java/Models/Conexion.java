/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private String Host="";
    private String Database="";
    private String User="";    
    private String Password="";
    Connection Con;
    
    public Conexion(){
        
        try {
            Properties p = new Properties();
            InputStream file = new FileInputStream("D:\\Projectos\\Java\\Servicio\\Configuration.properties");
            p.load(file);
            System.out.println("Carga Archivo..." );
            this.Host = p.getProperty("HOST");
            this.Database = p.getProperty("DATABASE");
            this.User = p.getProperty("USER");
            this.Password = p.getProperty("PASSWORD");
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String ConnectionDb = "jdbc:sqlserver://"+this.Host+";databaseName="+this.Database+";user="+this.User+";password="+this.Password+";";
            Con = DriverManager.getConnection(ConnectionDb);
            
            if(Con != null){
                System.out.println("Conexion Establecida Correctamente..." );
            }else{
                System.out.println("Error Al Conectarse A La Base De Datos..." );
            }
        } catch (SQLException | FileNotFoundException e) {
            e.getMessage();
        } catch (IOException | ClassNotFoundException e){
            e.getMessage();
        }
    }
    
    public Connection getConnection(){
        return Con;
    }
    
//    public ResultSet Procedure(String sp){
//        PreparedStatement ps;
//        ps = this.Con.prepareStatement(sp,columnNames);
//        ResultSet rs = null;
//        return rs;
//    }
//    
}
