/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Partnegotiation;
import bd.ConnectionBd;
import bd.ExceptionBd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 21002215
 */
@WebServlet(name = "ConnServlet", urlPatterns = {"/ConnServlet"})
public class ConnServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String m, p, r;
        ArrayList<String> lstRole = new ArrayList();
        HttpSession session = request.getSession(true);
//        if (!"".equals(request.getParameter("login"))) {
//            m = request.getParameter("login");
//            p = request.getParameter("password");           
//            try {
//                lstRole = ConnectionBd.retourneRole(m);
//            } catch (ExceptionBd ex) {
//                Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            session.setAttribute("email", m);
//            session.setAttribute("password", p);
//            session.setAttribute("rol", lstRole);
//
//        } else {
//            m = session.getAttribute("email").toString();
//            p = session.getAttribute("password").toString();
//        }
         try {
            m = request.getParameter("login");
            p = request.getParameter("password");           
            try {
                lstRole = ConnectionBd.retourneRole(m.toString());
            } catch (ExceptionBd ex) {
                Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            session.setAttribute("email", m);
            session.setAttribute("password", p);
            session.setAttribute("rol", lstRole);

        } catch(Exception e) {
            m = session.getAttribute("email").toString();
            p = session.getAttribute("password").toString();
        }

        //String l = "";
        String l = HibernateMain.connexion(m, p);

        if ("ok".equals(l) && lstRole.contains("Administrator") && lstRole.size() == 1) {
            RequestDispatcher rd = request.getRequestDispatcher("AdminList");
            rd.forward(request, response);
        } else if ("ok".equals(l)) {
            List<Partnegotiation> lstNeg = HibernateMain.affParNeg();
            RequestDispatcher rd = request.getRequestDispatcher("NegoList");
            request.setAttribute("lstN", lstNeg);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("Index");
            request.setAttribute("msg_erreur", "Wrong login or password");
            rd.forward(request, response);
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
