package modelo;

public class Empresa {

    private int idemp;
    private String nombre;
    private String direccion;
    private int telefono;
    private int codinter;

    public Empresa(int idemp) {
        this.idemp = idemp;
    }
    
    

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCodinter() {
        return codinter;
    }

    public void setCodinter(int codinter) {
        this.codinter = codinter;
    }
    
    
    
}
