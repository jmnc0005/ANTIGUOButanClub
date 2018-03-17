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

/**
 *
 * @author Pedro Luis
 */
@WebServlet(name = "gestionUsuario", urlPatterns = {"/usuarios/*"})
public class gestionUsuario extends HttpServlet {

    List<Usuario> usuarios;
    String svlURL, borrar;
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
        borrar = " ";

        svlURL = servletConfig.getServletContext().getContextPath() + "/usuarios";

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("juan1", "juan", "juan", "garcia", "juan@correo.es", "953682451", "Registrado", "1985-05-21"));
        usuarios.add(new Usuario("ana1", "ana", "ana", "martinez", "ana@correo.es", "953645251", "Artista", "1972-02-12"));
        usuarios.add(new Usuario("SH", "sh", "Stephen", "Hawking", "SH@butan.es", "953682451", "Administrador", "1942-01-08"));

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("svlURL", svlURL);

        request.setAttribute("usuarios", usuarios);

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
        Usuario usuario = new Usuario();
        request.setAttribute("usuario", usuario);
        RequestDispatcher rd;
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

        switch (action) {
            case "/logOut": {
                //Erase session data
                request.getSession().invalidate();
                //Redirect user to index page
                rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                break;
            }
            case "/edita": {
                String usuarioEdita = request.getParameter("usuario-edita");
                Usuario usu = busca(usuarioEdita);
                request.setAttribute("usuario", usu);
                rd = request.getRequestDispatcher(srvViewPath + "/EditaUsuario.jsp");
                break;
            }
            case "/borra": {
                String usuarioBorra = request.getParameter("usuario-borra");
                borra(usuarioBorra);
                //response.sendRedirect(svlURL);
                rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                break;
            }
            case "/RegistroUsuario": {
                Usuario usu = new Usuario();
                request.setAttribute("usuario", usu);
                rd = request.getRequestDispatcher(srvViewPath + "/RegistroUsuario.jsp");
                break;
            }
            default:
                if (request.getSession().getAttribute("log") != null) {

                    rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");

                } else {
                    rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                }
                break;
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
            case "": {
                Usuario usu = busca(request.getParameter("usuario"));
                if (" ".equals(usu.usuario)) {
                    String msg = "Credenciales incorrectas.";
                    request.setAttribute("msjErrorAlta", msg);
                    rd = request.getRequestDispatcher(srvViewPath + "/Acceso.jsp");
                } else {
                    if (usu.contraseña.equals(request.getParameter("pass"))) {
                        request.getSession().setAttribute("log", usu);

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
                    guarda(usu);
                    rd = request.getRequestDispatcher(srvViewPath + "/infoUsuario.jsp");
                    break;
                }
            }
            case "/RegistroUsuario": {
                Usuario usu = new Usuario();
                if (validaUsuario(request, usu)) {
                    usuarios.add(usu);
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

    // metodo de busqueda en List
    private Usuario busca(String usuario) {
        Usuario ret = new Usuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)) {
                ret = usuarios.get(i);
            }

        }
        return ret;
    }

    private boolean guarda(Usuario usu) {
        for (int i = 0; i < usuarios.size(); ++i) {
            if (usuarios.get(i).usuario.equals(usu.usuario)) {
                usuarios.set(i, usu);
                return true;
            }
        }
        return false;
    }

    private void borra(String usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)) {
                usuarios.remove(i);
                break;
            }

        }
    }

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
