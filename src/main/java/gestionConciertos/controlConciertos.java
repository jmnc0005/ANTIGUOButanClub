/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionConciertos;

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
public class controlConciertos extends HttpServlet {

    private List<Concierto> conciertos;
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
    public void init(ServletConfig servletConfig) throws ServletException{
        super.init(servletConfig);
        svlURL = servletConfig.getServletContext().getContextPath() + "/conciertos";
        
        
        
        conciertos=new ArrayList<>();
        conciertos.add(new Concierto("Blunk", "21:00", "2018-7-4", 10,"Rock","concierto1.jpg"));        
        conciertos.add(new Concierto("Mesu", "24:00", "2018-4-10", 15,"Indie","concierto2.jpg"));
        conciertos.add(new Concierto("50penny","9:00", "2018-6-4", 5,"Rap","concierto3.jpg"));
    
       
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setAttribute("svlURL", svlURL);

        request.setAttribute("conciertos", conciertos);
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
        switch(action){
            default:
                rd=request.getRequestDispatcher(srvViewPath+"/conciertos.jsp");
                rd.forward(request, response);
                break;    
          
        }
        
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
