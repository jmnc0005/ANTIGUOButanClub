/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub;

import com.butanclub.dao.ConciertoDAO;
import com.butanclub.jdbc.ConciertoDAOjdbc;
import com.butanclub.model.Concierto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "controlConciertos", urlPatterns = {"/conciertos/*"})
public class ConciertoController extends HttpServlet {

    private ConciertoDAO conciertos;
    String svlURL;
    final String srvViewPath = "/WEB-INF/conciertos";

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

        svlURL = servletConfig.getServletContext().getContextPath() + "/conciertos";

        conciertos = (ConciertoDAO) new ConciertoDAOjdbc();

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
        RequestDispatcher rd;
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        switch (action) {
            case "/listado": {
                List<Concierto> lc = conciertos.buscaTodos();
                request.getSession().setAttribute("listadoConciertos", lc);
                response.sendRedirect("/ButanClub/usuarios/respuestaConciertos");
                return;
            }

            default:
                List<Concierto> lc = conciertos.buscaTodos();
                request.setAttribute("listadoConciertos", lc);
                rd = request.getRequestDispatcher(srvViewPath + "/conciertos.jsp");
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
