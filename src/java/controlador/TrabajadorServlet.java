/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.ProfesionDao;
import dao.TrabajadoresDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Profesion;
import modelo.Trabajadores;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TrabajadorServlet", urlPatterns = {"/trabajador"})
public class TrabajadorServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    TrabajadoresDao trabdao = new TrabajadoresDao(conn);
    ProfesionDao profdao = new ProfesionDao(conn);
    List<Trabajadores> lista;
    List<Profesion> listapro;
    RequestDispatcher rd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "borrar":
                delete(request, response);
                break;
            case "mostrar":
                selectAll(request, response);

                break;
            case "seleccionarByid":
                selectByid(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "insertall":
                insertall(request,response);
                break;
        }

    }
    
     protected void insertall(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = trabdao.mostrar();
        listapro = profdao.mostrar();
        request.setAttribute("lista", lista);
        request.setAttribute("listapro", listapro);
        rd = request.getRequestDispatcher("/InsertarTrabajador.jsp");
        rd.forward(request, response);

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idprofesion = Integer.parseInt(request.getParameter("idprofesion"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellidos");
        String dui = request.getParameter("dui");
        String Horastrabaja = request.getParameter("horastrabaja");

        Trabajadores traba = new Trabajadores(0);
        Profesion pro = new Profesion(idprofesion);
        traba.setIdprofesion(pro);

        traba.setNombre(nombre);
        traba.setApellidos(apellido);
        traba.setDui(dui);
        traba.setHorastrabaja(Horastrabaja);

        respuesta = trabdao.inert(traba);
        if (respuesta) {
            msg = "registro guardado";
        } else {
            msg = "registro no guarddao";
        }

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/InsertarTrabajador.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = trabdao.mostrar();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/MostrarTrabajadores.jsp");
        rd.forward(request, response);

    }

    protected void selectByid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idtrabajador"));
        lista = trabdao.selectById(id);

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/ActualizarTrabajador.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idetrabajador"));
        int idprof = Integer.parseInt(request.getParameter("nombrepro"));
        String nombretra = request.getParameter("nombre");
        String apellidotra = request.getParameter("apellidos");
        String dui = request.getParameter("dui");
        String horas = request.getParameter("horas");

        Trabajadores tra = new Trabajadores(id);
        Profesion pro = new Profesion(idprof);
        tra.setIdprofesion(pro);
        tra.setNombre(nombretra);
        tra.setApellidos(apellidotra);
        tra.setDui(dui);
        tra.setHorastrabaja(horas);

        respuesta = trabdao.update(tra);
        if (respuesta) {
            msg = "Actualizado con exito";
        } else {
            msg = "Error al actualizar";
        }

        lista = trabdao.mostrar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarTrabajadores.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idtrabajador"));
        respuesta = trabdao.delete(id);

        if (respuesta) {
            msg = "registro eliminado";
        } else {
            msg = "registro no aeliminado";
        }

        lista = trabdao.mostrar();
        request.setAttribute("lista", lista);

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarTrabajadores.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
