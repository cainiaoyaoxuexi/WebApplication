/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import Hibernate.HibernateMain;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author 21103205
 */
@WebServlet(name = "updatePriceServlet", urlPatterns = {"/updatePriceServlet"})
public class updatePriceServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession session = request.getSession();
                String nego = request.getParameter("part");
//                session.removeAttribute("numParNeg");
                session.setAttribute("numParNeg", nego);
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa " + nego);
                
                String pr = request.getParameter("price");
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa " + pr);
//                int choice = JOptionPane.showOptionDialog(null, "Do you want to validate the price?", "Price validation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "Yes");
//                int idNego = (int) session.getAttribute("numPartNeg");
//                 float Price = (float) session.getAttribute("priceNego");

//                int idNego = Integer.parseInt(request.getParameter("numPartNeg"));
//                float Price = Float.parseFloat(request.getParameter("priceNego"));
//                String logique;
//                if (choice == 0) {
//                    logique = "yes";

                    HibernateMain.updatePriceNego(Short.parseShort(nego), Float.parseFloat(pr));
                    //System.out.println("gggggggggghhhhhhhhhhhhh");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                    
                    request.setAttribute("numParNeg", nego);
//                    request.setAttribute("lp", pr);
                    rd.forward(request, response);
//                } else {
//                    logique = "no";
//                    RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
//                    rd.forward(request, response);
//                }
//                session.setAttribute("logi", logique);
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                rd.forward(request, response);
            }
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
