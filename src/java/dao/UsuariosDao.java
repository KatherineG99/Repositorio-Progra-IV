
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuarios;


public class UsuariosDao {
    Conexion conn;

    public UsuariosDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean Login(String usuario, String clave) {
        String sql = "Select usuario, clave from usuarios where usuario = ? and clave = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean insert(Usuarios user){
        String sql="insert into usuarios values(?,?,?,?)";

        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
          
            
            ps.setInt(1, user.getIdusuario());
            ps.setString(2, user.getUsuario());
            ps.setString(3, user.getClave());
            ps.setString(4,user.getCorreo());
           
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    /* public Usuarios identificar(Usuarios user)throws Exception{
        Usuarios usuario = null;
       
        ResultSet rs;
        String sql="select u.idusuario,c.nombre from usuarios u inner join tipousuario c on u.idtipo=c.idtipu "
                + "where u.estado=1 and u.usuario='"+user.getUsuario()+"' and u.Clave= '"+user.getClave()+"'";
        
        try{
            System.out.println("pase12");
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            System.out.println("aqui "+ps);
            rs=ps.executeQuery();
            if (rs.next()==true) {
                usuario= new Usuarios();
                usuario.setId(rs.getInt("idusuario"));
                usuario.setUsuario(user.getUsuario());
                usuario.setNombre(new TipUsuario());
                usuario.getNombre().setNombre(rs.getString("nombre"));
                usuario.setEstado(true);
            }
            
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
        
        return usuario;
    }*/
}
