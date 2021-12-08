/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.UsuariosDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuarios;

@WebServlet(name = "UsuariosServlet", urlPatterns = {"/usuarios"})
public class UsuariosServlet extends HttpServlet {

    String mensaje;
    Conexion conn = new Conexion();
    UsuariosDao userd = new UsuariosDao(conn);
    List<Usuarios> lista;
    Usuarios usu;
    RequestDispatcher rd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {

            if (action != null) {

                switch (action) {
                    case "Registrar":
                        Registrar(request, response);
                        break;
                    case "iniciar":
                        Iniciar(request, response);
                        break;
                    case "logout":
                        logout(request, response);
                        break;
                    case "mostrar":
                        mostrar(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error 1" + e);
        }
    }

    protected void Registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String correo = request.getParameter("correo");

        Usuarios user = new Usuarios(0);
        user.setUsuario(usuario);
        user.setClave(clave);
        user.setCorreo(correo);
        boolean respuesta = userd.insert(user);
        if (respuesta) {
            mensaje = "Registro guardado con exito";
            rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        } else {
            mensaje = "Error al registrarse";
            rd = request.getRequestDispatcher("InsertarUsuario.jsp");
            rd.forward(request, response);

        }
    }

    protected void Iniciar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String Usuario = request.getParameter("usuario");
        String Password = request.getParameter("pass");

        if (userd.Login(Usuario, Password)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", Usuario);
            rd = request.getRequestDispatcher("/adminlte.jsp");
            rd.forward(request, response);
        } else {
            mensaje = "error";
            request.setAttribute("mensaje", mensaje);
            rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession sesion = request.getSession();
        sesion.invalidate();
        // response.sendRedirect("/Login.jsp");
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
