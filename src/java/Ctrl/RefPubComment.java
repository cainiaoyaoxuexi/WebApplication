/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Propose;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 21204711
 */
@WebServlet(name = "RefPubComment", urlPatterns = {"/RefPubComment"})
public class RefPubComment extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
//            HibernateMain.FermerSession();
//            HibernateMain.OpenSession();
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_publicComments>");
            String numberneg = request.getParameter("numberN");
            //HttpSession session = request.getSession(true);
            List<Propose> listPro = HibernateMain.publicComments(Short.parseShort(numberneg));
            
            for (Propose pro : listPro) {
                out.print("<publicComment>");
                out.print("<user>" + pro.getUsers().getFirstname()+" "+pro.getUsers().getLastname() + "</user>");
                out.print("<company>" + pro.getUsers().getCompany().getName() + "</company>");
                out.print("<datePro>" + pro.getId().getDatepro() + "</datePro>");
                out.print("<publicCom>" + pro.getCommentpart() + "</publicCom>");

                if (pro.getPrice() != null) {
                    out.print("<price>" + pro.getPrice() + "</price>");
                }
                else{
                    out.print("<price> </price>");
                }
//                
                if (pro.getMatprice() != null) {
                    out.print("<matprice>" + pro.getMatprice() + "</matprice>");
                }
                else{
                    out.print("<matprice> </matprice>");
                }
                
                if (pro.getLabprice() != null) {
                    out.print("<labprice>" + pro.getLabprice() + "</labprice>");
                }
                else{
                    out.print("<labprice> </labprice>");
                }
                
                if (pro.getOtherprice() != null) {
                    out.print("<otherprice>" + pro.getOtherprice() + "</otherprice>");
                }
                else{
                    out.print("<otherprice> </otherprice>");
                }
                out.print("</publicComment>");
            }
            out.println("</liste_publicComments>");
//            processRequest(request, response);
            //session.removeAttribute("numPartNeg");
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
