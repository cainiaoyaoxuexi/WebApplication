/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 21003648
 */
@WebServlet(name = "VerifPasswordServlet", urlPatterns = {"/VerifPasswordServlet"})
public class VerifPasswordServlet extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");

        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");

            /*----- Récupération des paramètres -----*/
          
           String ps = request.getParameter("psw");
            System.out.println("passw" + ps);
            String ps2 = request.getParameter("psw2");
            System.out.println("passw2" + ps2);
           
            out.println("<liste_mess>");

            if (ps.equals(ps2))
            {
                out.println("<messPass>ok!</messPass>");
            }else
                out.println("<messPass>password not good !!</messPass>");
            
            out.println("</liste_mess>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
    }
}
