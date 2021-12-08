package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Empresa;

public class EmpresaDao {

    Conexion conn;

    public EmpresaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Empresa emp) {
        String sql = "insert into Empresa values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setInt(1, emp.getIdemp());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getDireccion());
            ps.setInt(4, emp.getTelefono());
            ps.setInt(5, emp.getCodinter());
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Empresa> selectAll() {
        String sql = "select*from Empresa";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Empresa emp;
            List<Empresa> lista = new LinkedList<>();

            while (rs.next()) {
                emp = new Empresa(rs.getInt("idemp"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setDireccion(rs.getString("Direccion"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setCodinter(rs.getInt("codinter"));
                lista.add(emp);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Empresa emp) {
        String sql = "update Empresa set Nombre=?,Direccion=?,telefono=?,codinter=? where idemp=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getDireccion());
            ps.setInt(3, emp.getTelefono());
            ps.setInt(4, emp.getCodinter());
            ps.setInt(5, emp.getIdemp());
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Empresa> SelectByid(int id) {
        String sql = "select*from Empresa where idemp=?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Empresa emp;
            List<Empresa> lista = new LinkedList<>();

            while (rs.next()) {
                emp = new Empresa(rs.getInt("idemp"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setDireccion(rs.getString("Direccion"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setCodinter(rs.getInt("codinter"));
                lista.add(emp);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean delete (int id){
        String sql="delete from Empresa where idemp=?";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
}
