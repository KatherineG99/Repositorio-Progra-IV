/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.EmpresaDao;
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

/**
 *
 * @author Dell
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/empresa"})
public class EmpresaServlet extends HttpServlet {

    String msg;
    boolean respuesta;
    Conexion conn = new Conexion();
    EmpresaDao empd = new EmpresaDao(conn);
    List<Empresa> lista;
    RequestDispatcher rd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insertar(request, response);
                break;
            case "mostrar":
                mostrar(request, response);
                break;
            case "borrar":
                delete(request, response);
                break;
            case "seleccionar":
                mostrar(request, response);
                break;
            case "seleccionarByid":
                System.out.println("entre por dios ");
                selectByid(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
        }
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int codinter = Integer.parseInt(request.getParameter("codinterno"));

        Empresa emp = new Empresa(0);
        emp.setNombre(nombre);
        emp.setDireccion(direccion);
        emp.setTelefono(telefono);
        emp.setCodinter(codinter);

        respuesta = empd.insert(emp);
        if (respuesta) {
            msg = "Datos Guardados";
        } else {
            msg = "Error al guardar";
        }
        request.setAttribute("msg", msg);
        lista = empd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("MostrarEmpresas.jsp");
        rd.forward(request, response);

    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = empd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("MostrarEmpresas.jsp");
        rd.forward(request, response);

    }

    protected void selectByid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idemp"));
        lista = empd.SelectByid(id);

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("ActualizarEmpresa.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idemp"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int codinter = Integer.parseInt(request.getParameter("codinter"));
        
        Empresa emp = new Empresa(id);
        emp.setNombre(nombre);
        emp.setDireccion(direccion);
        emp.setTelefono(telefono);
        emp.setCodinter(codinter);

        respuesta = empd.update(emp);
        if (respuesta) {
            msg = "Guardado con exito";
        } else {
            msg = "Error al guardar";
        }

        lista = empd.selectAll();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        System.out.println(msg);
        rd = request.getRequestDispatcher("MostrarEmpresas.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idemp"));
        respuesta = empd.delete(id);
        if (respuesta) {
            msg = "registro eliminado";
        } else {
            msg = "registro no aeliminado";
        }

        lista = empd.selectAll();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("MostrarEmpresas.jsp");
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
