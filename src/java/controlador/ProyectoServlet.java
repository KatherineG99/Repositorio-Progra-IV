/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.EmpresaDao;
import dao.ProyectoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Proyecto;

@WebServlet(name = "ProyectoServlet", urlPatterns = {"/proyecto"})
public class ProyectoServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ProyectoDao proda = new ProyectoDao(conn);
    EmpresaDao empd = new EmpresaDao(conn);
    String msg;
    RequestDispatcher rd;
    boolean respuesta;
    List<Proyecto> lista;
    List<Empresa> listaemp;

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
                System.out.println("Entre 1");
                break;
            case "seleccionarByid":
                selectByid(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "insertal":
                insertal(request, response);
                break;
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int idemp = Integer.parseInt(request.getParameter("nombre de la empresa"));
        Date fecha_inicia = Date.valueOf(request.getParameter("inicio"));
        Date fecha_estimada = Date.valueOf(request.getParameter("estimada"));
        Date fecha_finaliza = Date.valueOf(request.getParameter("finalizacion"));

        Proyecto pro = new Proyecto(0);
        Empresa emp = new Empresa(idemp);
        pro.setNombre(nombre);
        pro.setDescripcion(descripcion);
        pro.setIdemp(emp);
        pro.setFecha_inicia(fecha_inicia);
        pro.setFecha_estimada(fecha_estimada);
        pro.setFecha_finaliza(fecha_finaliza);

        respuesta = proda.insert(pro);

        if (respuesta) {
            msg = "registro guardado";
        } else {
            msg = "registro no guarddao";
        }

        lista = proda.mostrar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarProyectos.jsp");
        rd.forward(request, response);

    }

    protected void insertal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = proda.mostrar();
        listaemp = empd.selectAll();
        request.setAttribute("listaemp", listaemp);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/InsertarProyecto.jsp");

        rd.forward(request, response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = proda.mostrar();
        listaemp = empd.selectAll();
        request.setAttribute("listaemp", listaemp);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/MostrarProyectos.jsp");

        rd.forward(request, response);
    }

    protected void selectByid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idproyecto"));
        lista = proda.selectById(id);
        listaemp = empd.selectAll();
        request.setAttribute("listaemp", listaemp);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/ActualizarProyecto.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idproyecto = Integer.parseInt(request.getParameter("idproyecto"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int idemp = Integer.parseInt(request.getParameter("idemp"));
        Date fecha_inicia = Date.valueOf(request.getParameter("fecha_inicia"));
        Date fecha_estimada = Date.valueOf(request.getParameter("fecha_estimada"));
        Date fecha_finaliza = Date.valueOf(request.getParameter("fecha_finaliza"));

        Proyecto pro = new Proyecto(idproyecto);
        Empresa emp = new Empresa(idemp);
        pro.setNombre(nombre);
        pro.setDescripcion(descripcion);
        pro.setIdemp(emp);
        pro.setFecha_inicia(fecha_inicia);
        pro.setFecha_estimada(fecha_estimada);
        pro.setFecha_finaliza(fecha_finaliza);

        respuesta = proda.update(pro);
        if (respuesta) {
            msg = "Actualizado con exito";
        } else {
            msg = "Error al actualizar";
        }

        lista = proda.mostrar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarProyectos.jsp");
        rd.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idproyecto"));
        respuesta = proda.delete(id);
        if (respuesta) {
            msg = "registro eliminado";
        } else {
            msg = "registro no aeliminado";
        }

        lista = proda.mostrar();
        request.setAttribute("lista", lista);

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/MostrarProyectos.jsp");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
