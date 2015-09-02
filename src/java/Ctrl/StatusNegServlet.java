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
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 21103205
 */
@WebServlet(name = "StatusNegServlet", urlPatterns = {"/StatusNegServlet"})
public class StatusNegServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/xml");

//        HttpSession session = request.getSession(true);
//        List<String> list = (List<String>) session.getAttribute("rol");
//        session.getAttribute("rol").toString();
//            System.out.println("session " + session.getAttribute("rol").toString());
//             System.out.println("session " + session.getAttribute("rol"));
////        System.out.println("eeee " + list.get(0) );
//        try {
//             System.out.println("eeee " + list.size() );
//        } catch (Exception e) {
//            System.out.println("rrrrr");
//        }
        try (PrintWriter out = response.getWriter()) {

            out.println("<?xml version=\"1.0\"?>");

            out.println("<listPart>");

            String st = request.getParameter("stat");
            List<Partnegotiation> lstPartNeg = HibernateMain.affParNegStat(st);

            for (Partnegotiation p : lstPartNeg) {

                out.print("<tables>");
                out.print("<negotiation>" + p.getPart().getNumberpart() + "</negotiation>");
                try {
                    out.print("<t>" + p.getPart().getTechnology().getTechnocode() + "</t>");
                } catch (NullPointerException e) {
                    out.print("<t>" + "--" + "</t>");
                }
                out.print("<statu>" + st + "</statu>");
                out.print("<dat>" + p.getFirstdate() + "</dat>");
                try {
                    Date da = HibernateMain.Feasabilitydate(p.getNumberneg(), p.getPart().getTechnology().getTechnocode());
                    out.print("<faisabi>" + da + "</faisabi>");
                } catch (Exception e) {
                    out.print("<faisabi>" + "------" + "</faisabi>");
                }
                try {
                    Date da = HibernateMain.Feasabilitydate(p.getNumberneg(), p.getPart().getTechnology().getTechnocode());
                    out.print("<del>" + HibernateMain.alertecycles(p.getNumberneg(), da) + "</del>");
                } catch (Exception e) {
                    out.print("<del> -- </del>");
                }
                out.print("<notifi>" + "------" + "</notifi>");
//                if (list.contains("Preparator") && !list.contains("Consultor") && !list.contains("Negotiator"))
//                {
//                   out.print("<price> -- </price>"); 
//                }
//                else
//                {
                try {
                    out.print("<pric>" + HibernateMain.infoPrixNego(p.getNumberneg()) + "</pric>");
                } catch (Exception e) {
                    out.print("<pric>" + "--" + "</pric>");
                }

//                }
//                try {
//                if (list.contains("Preparator") && !list.contains("Consultor") && !list.contains("Negotiator")) {
//                    
//                    out.print("<price> -- </price>");
//                }
//                }catch (NullPointerException e) {
//                    out.print("<price> price </price>");
//                }
                out.print("</tables>");

            }
            out.println("</listPart>");
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
