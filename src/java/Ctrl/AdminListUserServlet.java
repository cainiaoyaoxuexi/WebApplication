/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import Hibernate.Users;
import bd.ConnectionBd;
import bd.ExceptionBd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21000330
 */
@WebServlet(name = "AdminListUserServlet", urlPatterns = {"/AdminListUserServlet"})
public class AdminListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");
     
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_user>");

            /*----- Récupération des paramètres -----*/
            String role = request.getParameter("role");

            //if(!email.isEmpty())
            try {
                /*----- Lecture de liste de mots dans la BD -----*/
                //ArrayList<String> lstUserFirst = ConnectionBd.retourneUserFirstName(role);
               // ArrayList<String> lstUserLast = ConnectionBd.retourneUserLastName(role);
                ArrayList<Users> lstUser = ConnectionBd.retourneUser(role);
                
               
//                for (int i=0;i<lstUserFirst.size();i++) {
//                    out.println("<user>");
//                    out.println("<nom>" + lstUserFirst.get(i) + "</nom>");
//                    out.println("<prenom>" + lstUserLast.get(i) + "</prenom>");
//                    out.println("</user>");
//                }
                for (Users u : lstUser) {
                    out.println("<user>");
                            out.println("<id>" + u.getIduser() + "</id>");
                            out.println("<prenom>" + u.getFirstname() + "</prenom>");
                            out.println("<nom>" + u.getLastname() + "</nom>");
                    out.println("</user>");
                }
            }
            catch (ExceptionBd e)
                    {
                    
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
