/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.EmpresaDao;
import dao.ProfesionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Profesion;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ProfesionServlet", urlPatterns = {"/profesion"})
public class ProfesionServlet extends HttpServlet {

     String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    ProfesionDao prodao = new ProfesionDao(conn);
    
    List<Profesion> lista;
    
    RequestDispatcher rd;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "mostrar":
                selectAll(request, response);
                break;
            case "borrar":
                delete(request, response);
                break;

            case "actualizar":
                update(request, response);
                break;
            case "seleccionarByid":
                selectByid(request, response);
                break;
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreprofesion = request.getParameter("nombre");
        Profesion pro = new Profesion(0);
        pro.setNombreprofesion(nombreprofesion);

        respuesta = prodao.insert(pro);
        if (respuesta) {
            msg = "registro guardado";
        } else {
            msg = "registro no guarddao";
        }
        prodao.mostrar();
        request.setAttribute("lista", lista);

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/adminlte.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = prodao.mostrar();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/MostrarProfesiones.jsp");
        rd.forward(request, response);

    }

    protected void selectByid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idprofesion"));
        lista = prodao.selectByid(id);

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/ActualizarProfesion.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idprofesion"));
        String nombre = request.getParameter("nombreprofesion");

        Profesion pro = new Profesion(id);
        pro.setNombreprofesion(nombre);

        respuesta = prodao.update(pro);

        if (respuesta) {
            msg = "registro actualizado";
        } else {
            msg = "registro no actualizado";
        }

        lista = prodao.mostrar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarProfesiones.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idprofesion"));
        respuesta = prodao.delete(id);
        if (respuesta) {
            msg = "registro eliminado";
        } else {
            msg = "registro no aeliminado";
        }

        lista = prodao.mostrar();
        request.setAttribute("lista", lista);
        
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarProfesiones.jsp");
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
