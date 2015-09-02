/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 21003648
 */
@WebServlet(name = "publicCommentServlet", urlPatterns = {"/publicCommentServlet"})
public class publicCommentServlet extends HttpServlet {

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
//        response.setContentType("application/xml");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(true);
            String iduser = HibernateMain.infoUserEmail(session.getAttribute("email").toString()).getIduser();
            String price, matprice, labprice, other;
            String comment;
//            try {
            comment = request.getParameter("comment");
            //System.out.println("comment" + comment + "comment");
            price = request.getParameter("price");
            // System.out.println("price" + price);
            matprice = request.getParameter("matprice");
            //System.out.println("matprice" + matprice);
            labprice = request.getParameter("labprice");
            //System.out.println("labprice" + labprice);
            other = request.getParameter("other");
            //System.out.println("other" + other);
            if (comment.isEmpty() && price.isEmpty() && labprice.isEmpty() && other.isEmpty() && matprice.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input at least a information");
                RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                rd.forward(request, response);
            } else {
                if (price.isEmpty()) {
                    price = "";
                }

                if (matprice.isEmpty()) {
                    matprice = "";
                }
                if (labprice.isEmpty()) {

                    labprice = "";
                }
                if (other.isEmpty()) {

                    other = "";
                }
                ArrayList<Float> listPrice = new ArrayList();
                try {

                    if (!price.isEmpty()) {
                        listPrice.add(Float.parseFloat(price));
                    }

                    if (!matprice.isEmpty()) {
                        listPrice.add(Float.parseFloat(matprice));
                    }
                    if (!labprice.isEmpty()) {
                        listPrice.add(Float.parseFloat(labprice));
                    }
                    if (!other.isEmpty()) {
                        listPrice.add(Float.parseFloat(other));
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "the prices must in numbers");
                    RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                    rd.forward(request, response);
                }

                if (listPrice.size() > 1) {
                    float pricetotal = 0;
                    for (int i = 1; i < listPrice.size(); i++) {
                        pricetotal = pricetotal + (float) listPrice.get(i);
                    }
                    System.out.println("jinle7");
                    if (Float.parseFloat(price) < pricetotal) {
                        JOptionPane.showMessageDialog(null, "The total price must be more than the sum of the sub-prices");
                        RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                        rd.forward(request, response);
                    } else {
                        System.out.println("insert try");
                        HibernateMain.insertPublicComment(iduser, Short.parseShort(session.getAttribute("numPartNeg").toString()), comment, price, matprice, labprice, other, null, null);
                        System.out.println("insert success");
                        RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                        rd.forward(request, response);
                    }
                } else {
                    System.out.println("jinle8");
                    HibernateMain.insertPublicComment(iduser, Short.parseShort(session.getAttribute("numPartNeg").toString()), comment, price, matprice, labprice, other, null, null);
                    RequestDispatcher rd = request.getRequestDispatcher("Negotiation");
                    rd.forward(request, response);
                    System.out.println("insert success");
                }
            }
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e.getMessage());
            //out.print(e.getMessage());

            RequestDispatcher rd = request.getRequestDispatcher("Negotiation.jsp");
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
