/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub;

import com.butanclub.dao.UsuarioDAO;
import com.butanclub.jdbc.UsuarioDAOjdbc;
import com.butanclub.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.butanclub.ConciertoController;

/**
 *
 * @author Pedro Luis
 */
@WebServlet(urlPatterns = {"/usuarios/*"})
public class UsuarioController extends HttpServlet {

//    List<Usuario> usuarios;
    private UsuarioDAO usuarios;
    String svlURL;
    final String srvViewPath = "/WEB-INF/usuarios";

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
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        svlURL = servletConfig.getServletContext().getContextPath() + "/usuarios";

        usuarios = new UsuarioDAOjdbc();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html");
        request.setAttribute("svlURL", svlURL);
        request.setCharacterEncoding("UTF-8");

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

        processRequest(request, response);
        RequestDispatcher rd = null;
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

        switch (action) {

            case "/edita": {
                String usuarioEdita = request.getParameter("usuario-edita");
                Usuario usu = usuarios.buscaUsuario(usuarioEdita);
                request.setAttribute("usuario", usu);
                rd = request.getRequestDispatcher(srvViewPath + "/EditaUsuario.jsp");
                break;
            }
            case "/borra": {
                String usuarioBorra = request.getParameter("usuario-borra");
                usuarios.borra(usuarioBorra);
                //response.sendRedirect(svlURL);
                //response.sendRedirect(srvViewPath + "/infoUsuario.jsp");
                List<Usuario> lu = usuarios.buscaTodos();
                request.setAttribute("listadoUsuarios", lu);
                rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                break;
            }
            case "/RegistroUsuario": {
                Usuario usu = new Usuario();
                request.setAttribute("usuario", usu);
                rd = request.getRequestDispatcher(srvViewPath + "/RegistroUsuario.jsp");
                break;
            }
            case "/borraconcierto": {

                response.sendRedirect("/ButanClub/conciertos");
                return;
//request.getRequestDispatcher("ConciertoController").forward(request, response);
            }
            case "/respuestaConciertos":
                if (request.getSession().getAttribute("log") != null) {
                    List<Usuario> lu = usuarios.buscaTodos();
                    request.setAttribute("listadoUsuarios", lu);
                    //response.sendRedirect(svlURL + "infoUsuario.jsp");
                    //return;
                    rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                } else {
                    rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                }
                break;
            default:
                response.sendRedirect("/ButanClub/conciertos/listado");
                return;
        }

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
        RequestDispatcher rd = request.getRequestDispatcher("");

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        switch (action) {
            case "/respuestaConciertos": {
                Usuario usu = usuarios.buscaUsuario(request.getParameter("usuario"));

                if (usu == null) {
                    String msg = "Credenciales incorrectas.";
                    request.setAttribute("msjErrorAlta", msg);
                    rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                } else {
                    if (usu.getContraseña().equals(request.getParameter("pass"))) {

                        request.getSession().setAttribute("log", usu);
                        List<Usuario> lu = usuarios.buscaTodos();
                        request.setAttribute("listadoUsuarios", lu);
                        rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                    } else {
                        String msg = "Credenciales incorrectas.";
                        request.setAttribute("msjErrorAlta", msg);
                        rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                    }
                }
                break;
            }
            case "/edita": {
                Usuario usu = new Usuario();
                if (validaUsuario(request, usu)) {
                    usu.setTipoUsuario(request.getParameter("tipoUsuario"));
                    usuarios.guarda(usu);
                    List<Usuario> lu = usuarios.buscaTodos();
                    request.setAttribute("listadoUsuarios", lu);
                    rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                    break;
                }
            }

            case "/RegistroUsuario": {
                Usuario usu = new Usuario();
                if (validaUsuario(request, usu)) {
                    usuarios.crea(usu);
                    rd = request.getRequestDispatcher(srvViewPath + "/NuevoUsuario.jsp");
                    break;
                }
            }
        }
        rd.forward(request, response);
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

    private boolean validaUsuario(HttpServletRequest request, Usuario usu) {
        usu.setApellidos(request.getParameter("apellidos"));
        usu.setContraseña(request.getParameter("pass"));
        usu.setCorreo(request.getParameter("email"));
        usu.setNombre(request.getParameter("nombre"));
        usu.setTelefono(request.getParameter("tlfn"));
        usu.setTipoUsuario("Registrado");
        usu.setUsuario(request.getParameter("usuario"));
        usu.setfNacimiento(request.getParameter("fecha"));

        return true;
    }
}
