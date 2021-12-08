/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Profesion;

/**
 *
 * @author Dell
 */
public class ProfesionDao {
    Conexion conn; 

    public ProfesionDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insert(Profesion prof){
        String sql="insert into profesion values(?,?)";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            ps.setInt(1, prof.getIdprofesion());
            ps.setString(2, prof.getNombreprofesion());
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Profesion> mostrar(){
        String sql="select*from profesion";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Profesion prof;
            List<Profesion> lista = new LinkedList<>();
            
            while(rs.next()){
                prof= new Profesion(rs.getInt("idprofesion"));
                prof.setNombreprofesion(rs.getString("nombreprofesion"));
                lista.add(prof);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean update(Profesion prof){
         String sql="update profesion set nombreprofesion=? where idprofesion=?";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            
            ps.setString(1, prof.getNombreprofesion());
            ps.setInt(2, prof.getIdprofesion());
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Profesion > selectByid(int id){
        String sql="select*from profesion where idprofesion=?";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            Profesion prof;
            List<Profesion> lista = new LinkedList<>();
            
            while(rs.next()){
                prof= new Profesion(rs.getInt("idprofesion"));
                prof.setNombreprofesion(rs.getString("nombreprofesion"));
                lista.add(prof);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean delete (int id){
         String sql = "delete  from  profesion where idprofesion = ?";
            try{  

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
            }catch (Exception e){
                return false;
            }
    }
}
