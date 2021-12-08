
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Profesion;
import modelo.Trabajadores;


public class TrabajadoresDao {
    Conexion conn;

    public TrabajadoresDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean inert(Trabajadores tra){
        String sql="insert into Trabajadores values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.conectar().prepareStatement(sql);
            Profesion profesion = tra.getIdprofesion();
            
            ps.setInt(1,tra.getIdtrabajador());
            ps.setInt(2, profesion.getIdprofesion());
             ps.setString(3, tra.getNombre());
            ps.setString(4, tra.getApellidos());
            ps.setString(5 , tra.getDui());
            ps.setString(6,tra.getHorastrabaja());
            
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Trabajadores> mostrar(){
        String sql="select*from Trabajadores";
        
        try{
            PreparedStatement ps= conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Trabajadores tra;
            List<Trabajadores> lista= new LinkedList<>();
            
            while(rs.next()){
                Profesion pro= new Profesion(rs.getInt("idprofesion"));
                
                tra = new Trabajadores(rs.getInt("idtrabajador"));
                tra.setIdprofesion(pro);
                tra.setNombre(rs.getString("nombre"));
                tra.setApellidos(rs.getString("apellidos"));
                tra.setDui(rs.getString("dui"));
                tra.setHorastrabaja(rs.getString("horastrabaja"));
                lista.add(tra);
                
            }
            return lista;
            
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean update(Trabajadores tra){
        String sql="update Trabajadores set idprofesion=?,nombre=?,apellidos=?,dui=?,horastrabaja=? where idtrabajador=?";
        try{
            PreparedStatement ps=conn.conectar().prepareStatement(sql);
            Profesion profesion = tra.getIdprofesion();
            
            
            ps.setInt(1, profesion.getIdprofesion());
             ps.setString(2, tra.getNombre());
            ps.setString(3, tra.getApellidos());
            ps.setString(4 , tra.getDui());
            ps.setString(5,tra.getHorastrabaja());
            ps.setInt(6,tra.getIdtrabajador());
            
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Trabajadores> selectById(int id){
        String sql="select*from Trabajadores where idtrabajador=?";
        
        try{
            PreparedStatement ps= conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Trabajadores tra;
            List<Trabajadores> lista= new LinkedList<>();
            
            while(rs.next()){
                Profesion pro= new Profesion(rs.getInt("idprofesion"));
                
                tra = new Trabajadores(rs.getInt("idtrabajador"));
                tra.setIdprofesion(pro);
                 tra.setNombre(rs.getString("nombre"));
                tra.setApellidos(rs.getString("apellidos"));
                tra.setDui(rs.getString("dui"));
                tra.setHorastrabaja(rs.getString("horastrabaja"));
                lista.add(tra);
                
            }
            return lista;
            
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean delete(int id){
         String sql = "delete  from  Trabajadores where idtrabajador = ?";
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
