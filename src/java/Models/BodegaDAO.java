/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class BodegaDAO {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    CallableStatement cs;
    
    public List listar(){
        ArrayList<Bodega> d = new ArrayList<>();
        sql = "SELECT * FROM BODEGAS";
        try {
            Connection conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Bodega b = new Bodega();
                b.setId(rs.getInt("id"));
                b.setNombre(rs.getString("nombre"));
                b.setExterna(rs.getBoolean("externa"));
                b.setEstantes(rs.getInt("estantes"));
                d.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
    
    public Bodega consultarbodega(int id){
        Bodega b = new Bodega();
        sql = "SELECT * FROM BODEGAS WHERE ID ="+id;
        try {
            Connection conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                b.setId(rs.getInt("id"));
                b.setNombre(rs.getString("nombre"));
                b.setExterna(rs.getBoolean("externa"));
                b.setEstantes(rs.getInt("estantes"));
            }
        } catch (Exception e) {
        }
        return b;
    }
    
    public String addBodega(Bodega b){
        String msj="";
        try {
            Connection conn = con.getConnection();
            cs = conn.prepareCall("{call spOperacionesBodegas(?,?,?,?)}");
            cs.setString("op","agregarbodega");
            cs.setString("nombre",b.getNombre());
            cs.setBoolean("externa", b.isExterna());
            cs.setInt("estantes", b.getEstantes());
            
            rs = cs.executeQuery();
            while(rs.next()){
                msj = rs.getString("Msj");    
            }
            rs.close();
            cs.close();
        } catch (Exception e) {
        }
        return msj;
    }
    
    public String deleteBodega (int id){
        String msj="";
        try {
            Connection conn = con.getConnection();
//            cs = conn.prepareCall("{call spOperacionesBodegas (?,?,?,?,?)}");
//            cs.setString("op", "eliminarbodega");
//            cs.setString("nombre", "");
//            cs.setString("externa", "0");
//            cs.setString("estantes", "");
//            cs.setInt("id", id);
            
            ps = conn.prepareStatement("exec spOperacionesBodegas");
            rs = ps.executeQuery();
            while(rs.next()){
                msj = rs.getString("Msj");    
            }
            rs.close();
            cs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msj;
    }
}
