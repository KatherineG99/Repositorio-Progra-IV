/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import modelo.Empresa;
import modelo.Proyecto;

/**
 *
 * @author Dell
 */
public class ProyectoDao {
    Conexion conn;

    public ProyectoDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insert(Proyecto pro){
        String sql="insert into Proyecto values(?,?,?,?,?,?,?)";
        SimpleDateFormat formato = new SimpleDateFormat("YY-MM-dd");
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
           
            
            ps.setInt(1, pro.getIdproyecto());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getIdemp().getIdemp());
            ps.setString(5, formato.format(pro.getFecha_inicia()));
            ps.setString(6, formato.format(pro.getFecha_estimada()));
            ps.setString(7, formato.format(pro.getFecha_finaliza()));
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Proyecto> mostrar(){
        String sql="select*from Proyecto";
        try{
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Proyecto pro;
            List<Proyecto> lista= new LinkedList<>();
            
            while(rs.next()){
                Empresa emp = new Empresa(rs.getInt("idemp"));
                
                pro= new Proyecto(rs.getInt("idproyecto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setIdemp(emp);
                pro.setFecha_inicia(rs.getDate("fecha_inicia"));
                pro.setFecha_estimada(rs.getDate("fecha_estimada"));
                pro.setFecha_finaliza(rs.getDate("fecha_finaliza"));
                
                lista.add(pro);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean update(Proyecto pro){
         String sql="update Proyecto set nombre=?,descripcion=?,idemp=?,fecha_inicia=?,fecha_estimada=?,fecha_finaliza=? where idproyecto=? ";
        SimpleDateFormat formato = new SimpleDateFormat("YY-MM-dd");
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            Empresa emp = pro.getIdemp();
            
            
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, emp.getIdemp());
            ps.setString(4, formato.format(pro.getFecha_inicia()));
            ps.setString(5, formato.format(pro.getFecha_estimada()));
            ps.setString(6, formato.format(pro.getFecha_finaliza()));
            ps.setInt(7, pro.getIdproyecto());
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Proyecto>selectById(int id){
        String sql="select*from Proyecto where idproyecto=?";
        try{
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
           ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Proyecto pro;
            List<Proyecto> lista= new LinkedList<>();
            
            while(rs.next()){
                Empresa emp = new Empresa(rs.getInt("idemp"));
                
                pro= new Proyecto(rs.getInt("idproyecto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setIdemp(emp);
                pro.setFecha_inicia(rs.getDate("fecha_inicia"));
                pro.setFecha_estimada(rs.getDate("fecha_estimada"));
                pro.setFecha_finaliza(rs.getDate("fecha_finaliza"));
                
                lista.add(pro);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean delete(int id){
         String sql = "delete  from  Proyecto where idproyecto = ?";
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
