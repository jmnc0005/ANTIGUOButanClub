/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionUsuarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Pedro Luis
 */
@WebServlet(name = "gestionUsuario", urlPatterns = {"/usuarios/*"})
public class gestionUsuario extends HttpServlet {

    List<Usuario> usuarios;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
        super.init();
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("juan1", "juan", "juan", "garcia", "juan@correo.es", "953682451", "Registrado", "1985-05-21"));
        usuarios.add(new Usuario("ana1", "ana", "ana", "martinez", "ana@correo.es", "953645251", "Artista", "1972-02-12"));
        usuarios.add(new Usuario("SH", "sh", "Stephen", "Hawking", "SH@butan.es", "953682451", "Administrador", "1942-01-08"));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
                request.setAttribute("usuario", usuario);
        RequestDispatcher rd;
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        switch (action) {
            default:
                rd = request.getRequestDispatcher("/WEB-INF/usuarios/Acceso.jsp");
                break;
        }
        processRequest(request, response);
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String Login = (String)request.getSession().getAttribute("Login");
        String altausuario = request.getParameter("altaUsuario");
        if(0==Login.compareTo("Login")){
            Boolean log=true;
            if (log==true){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuarios/NuevoUsuario.jsp");
            rd.forward(request, response);
            }
        }
        if (altausuario != null) {
            Usuario usu =new Usuario();
            usu.setApellidos(request.getParameter("apellidos"));
            usu.setContraseña(request.getParameter("password"));
            usu.setCorreo(request.getParameter("email"));
            usu.setNombre(request.getParameter("nombre"));
            usu.setTelefono(request.getParameter("tlfn"));
            usu.setTipoUsuario("Registrado");
            usu.setUsuario(request.getParameter("usuario"));
            usu.setfNacimiento(request.getParameter("fecha"));

            usuarios.add(usu);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuarios/NuevoUsuario.jsp");
            rd.forward(request, response);
        }
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
