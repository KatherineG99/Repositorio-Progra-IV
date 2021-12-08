
package modelo;


public class Trabajadores {
    private int idtrabajador;
    private Profesion idprofesion;
    private String nombre;
    private String apellidos;
    private String dui;
    private String horastrabaja;

    public Trabajadores(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }
    
    

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Profesion getIdprofesion() {
        return idprofesion;
    }

    public void setIdprofesion(Profesion idprofesion) {
        this.idprofesion = idprofesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getHorastrabaja() {
        return horastrabaja;
    }

    public void setHorastrabaja(String horastrabaja) {
        this.horastrabaja = horastrabaja;
    }
    
    
}
