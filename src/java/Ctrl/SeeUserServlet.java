/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import Hibernate.Partnegotiation;
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
 * @author 21000330
 */
@WebServlet(name = "seeUserServlet", urlPatterns = {"/seeUserServlet"})
public class SeeUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");

        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_user>");

            /*----- Récupération des paramètres -----*/
            String id = request.getParameter("accountId");
            session.setAttribute("accountId", id);
//            out.println("id"+id);

            try {
                Users u = HibernateMain.infoUser(id);

                out.println("<user>");
                out.println("<id>" + u.getIduser() + "</id>");
                out.println("<prenom>" + u.getFirstname() + "</prenom>");
                out.println("<nom>" + u.getLastname() + "</nom>");
                out.println("<email>" + u.getEmail() + "</email>");
                out.println("<password>" + u.getPassword() + "</password>");
                ArrayList<String> lstRole = ConnectionBd.retourneRole(u.getEmail());
                System.out.println("role" + lstRole.size());
                for (String role : lstRole) {
                    out.println("<role>" + role + "</role>");
                }
                out.println("</user>");

                RequestDispatcher rd = request.getRequestDispatcher("AdminManage");
                request.setAttribute("user", u);
                rd.forward(request, response);

            } catch (ExceptionBd e) {

                out.println("<user> - </user>");
            }

            out.println("</liste_user>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
    }
}
