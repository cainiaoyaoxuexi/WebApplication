/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Partnegotiation;
import Hibernate.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author Tramb
 */
@WebServlet(name = "RefreshNegServlet", urlPatterns = {"/RefreshNegServlet"})
public class RefreshNegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/xml");

//        HttpSession session = request.getSession(true);
//        List<String> list = (List<String>) session.getAttribute("rol");
////        System.out.println("eeee " + list.get(0) );
//        try {
//             System.out.println("eeee " + list.size() );
//        } catch (Exception e) {
//            System.out.println("rrrrr");
//        }
//            HttpSession session = request.getSession(true);
            /*----- Récupération des paramètres -----*/
//            String m = session.getAttribute("email").toString();
//            Users u = HibernateMain.infoUserEmail(m);
//            String id = u.getIduser();
        try (PrintWriter out = response.getWriter()) {

            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");

            out.println("<listPart>");

            String technol = request.getParameter("tech");
            List<Partnegotiation> lstPartNeg = HibernateMain.affParNegTech(technol);

            for (Partnegotiation p : lstPartNeg) {
                Date da = HibernateMain.Feasabilitydate(p.getNumberneg(), p.getPart().getTechnology().getTechnocode());

                out.print("<tables>");
                out.print("<negotiation>" + p.getPart().getNumberpart() + "</negotiation>");
                try {
                    out.print("<t>" + p.getPart().getTechnology().getTechnocode() + "</t>");
                } catch (NullPointerException e) {
                    out.print("<t>" + "--" + "</t>");
                }
                out.print("<statu>" + p.getNegostatus() + "</statu>");
                out.print("<dat>" + p.getFirstdate() + "</dat>");
                try{
                   out.print("<faisabi>" + da + "</faisabi>"); 
                }
                catch(Exception e)
                {
                    out.print("<faisabi> pas de date</faisabi>");
                }
                
                try {
                    out.print("<delai>" + HibernateMain.alertecycles(p.getNumberneg(), da) + "</delai>");
                } catch (NullPointerException e) {
                    out.print("<delai>" + "--" + "</delai>");
                }
                out.print("<notif>" + "------" + "</notif>");
                try {
                    out.print("<pric>" + HibernateMain.infoPrixNego(p.getNumberneg()) + "</pric>");
                } catch (NullPointerException e) {
                    out.print("<pric>" + "--" + "</pric>");
                }
//                out.print("<notifi>" + HibernateMain.getnotification(id,p.getNumberneg())+ "</notifi>");

//                if (list.contains("Preparator") && !list.contains("Consultor") && !list.contains("Negotiator"))
//                {
//                   out.print("<price> -- </price>"); 
//                }
//                else
//                {
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
