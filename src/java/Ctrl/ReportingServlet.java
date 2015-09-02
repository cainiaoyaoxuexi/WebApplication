/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Partnegotiation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21000330
 */
@WebServlet(name = "ReportingServlet", urlPatterns = {"/ReportingServlet"})
public class ReportingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/xml");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<?xml version=\"1.0\"?>");
            out.println("<numberNegotiations>");
            
            float nbVal = HibernateMain.numberNegoVal();
            float nbCan = HibernateMain.numberNegoCan();
            float nbRef = HibernateMain.numberNegoRef();
            float nbInProg = HibernateMain.numberNegoInProg();
            float nbNew = HibernateMain.numberNegoNew();
            float nbProv = HibernateMain.numberNegoProv();
            
            /* TODO output your page here. You may use following sample code. */
            try {
                out.println("<Graphic>");
                out.println("<NbVal>" + nbVal + "</NbVal>");
                out.println("<NbCan>" + nbCan + "</NbCan>");
                out.println("<NbRef>" + nbRef + "</NbRef>");            
                out.println("<NbInProg>" + nbInProg + "</NbInProg>");
                out.println("<NbNew>" + nbNew + "</NbNew>");
                out.println("<NbProv>" + nbProv + "</NbProv>");
                out.println("</Graphic>");
            }
            catch(Exception e) {
                out.println("<Graphic>");
                out.println("<NbVal></NbVal>");
                out.println("<NbCan></NbCan>");
                out.println("<NbRef></NbRef>");            
                out.println("<NbInProg></NbInProg>");
                out.println("<NbNew></NbNew>");
                out.println("<NbProv></NbProv>");
                out.println("</Graphic>");
            }
            
            out.println("</numberNegotiations>");
            
        }
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
