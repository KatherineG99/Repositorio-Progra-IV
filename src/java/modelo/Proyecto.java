
package modelo;

import java.sql.Date;


public class Proyecto {
    private int idproyecto;
    private String nombre;
    private String descripcion;
    private Empresa idemp;
    private Date fecha_inicia,fecha_estimada,fecha_finaliza;

    public Proyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

   /* public Proyecto(int idproyecto, String nombre, String descripcion, Empresa idemp, Date fecha_inicia, Date fecha_estimada, Date fecha_finaliza) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idemp = idemp;
        this.fecha_inicia = fecha_inicia;
        this.fecha_estimada = fecha_estimada;
        this.fecha_finaliza = fecha_finaliza;
    }
    
    public Proyecto(int id,String nombre,String descripcion, int idempresa,Date fechainicia, Date fechaestimada,Date fechafinaliza){
        this.idproyecto=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.idemp=new Empresa(idempresa);
        this.fecha_inicia=fechainicia;
        this.fecha_estimada=fechaestimada;
        this.fecha_finaliza=fechafinaliza;
    }*/
    

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getIdemp() {
        return idemp;
    }

    public void setIdemp(Empresa idemp) {
        this.idemp = idemp;
    }

    public Date getFecha_inicia() {
        return fecha_inicia;
    }

    public void setFecha_inicia(Date fecha_inicia) {
        this.fecha_inicia = fecha_inicia;
    }

    public Date getFecha_estimada() {
        return fecha_estimada;
    }

    public void setFecha_estimada(Date fecha_estimada) {
        this.fecha_estimada = fecha_estimada;
    }

    public Date getFecha_finaliza() {
        return fecha_finaliza;
    }

    public void setFecha_finaliza(Date fecha_finaliza) {
        this.fecha_finaliza = fecha_finaliza;
    }
    
    
    
}
