/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Users;
import bd.ConnectionBd;
import bd.ExceptionBd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "VerifMailServlet", urlPatterns = {"/VerifMailServlet"})
public class VerifMailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");

        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");

            /*----- Récupération des paramètres -----*/
          
            String email = request.getParameter("mail");
            System.out.println("email" + email);
            String email2 = request.getParameter("mail2");
            System.out.println("email2" + email2);
           
            out.println("<liste_mess>");

            if (email.equals(email2))
            {
                System.out.println("ok");
                out.println("<mess>ok!</mess>");
            }else
                out.println("<mess>mail pas bon !!</mess>");
            
            List<String> l=HibernateMain.recupMail();
            if (l.contains(email))
            {
                out.println("<messExist>Mail already existing !!</messExist>");
                System.out.println("exist");
            }else
                out.println("<messExist>--</messExist>");
            out.println("</liste_mess>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
    }


}
