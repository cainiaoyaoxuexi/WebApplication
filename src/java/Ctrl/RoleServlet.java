/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl;

import Hibernate.HibernateMain;
import bd.ConnectionBd;
import bd.ExceptionBd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21004555
 */
@WebServlet(name = "RoleServlet", urlPatterns = {"/RoleServlet"})

public class RoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");
//        HibernateMain.FermerSession();
//        HibernateMain.OpenSession();
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_role>");

            /*----- Récupération des paramètres -----*/
            String email = request.getParameter("email");

            //if(!email.isEmpty())
            try { //System.out.println("tttttttttttttt");
                /*----- Lecture de liste de mots dans la BD -----*/
                ArrayList<String> lstRole = ConnectionBd.retourneRole(email);
                System.out.println("role"+ lstRole.size());
                for (String role : lstRole) {
                    out.println("<role>" + role + "</role>");
                }
            }
            catch (ExceptionBd e)
                    {
                    
                    out.println("<role> - </role>");
                }

            out.println("</liste_role>");
      
    
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
    }

}
