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
@WebServlet(name = "ModifyUserServlet", urlPatterns = {"/ModifyUserServlet"})
public class ModifyUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");

        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");

            /*----- Récupération des paramètres -----*/
            String id = request.getParameter("idu");
            System.out.println("id" + id);
            String lastname = request.getParameter("last");
            System.out.println("lastname" + lastname);

            String firstname = request.getParameter("first");
            System.out.println("firstname" + firstname);
            String mail = request.getParameter("mail");
            System.out.println("email" + mail);
            String password = request.getParameter("psw");
            System.out.println("password" + password);
            String rol1 = null;
            String rol2 = null;
            String rol3 = null;
            String rol4 = null;
            rol1 = request.getParameter("rol1");
            System.out.println("rol1" + rol1);
            rol2 = request.getParameter("rol2");
            System.out.println("rol2" + rol2);
            rol3 = request.getParameter("rol3");
            System.out.println("rol3" + rol3);
            rol4 = request.getParameter("rol4");
            System.out.println("rol4" + rol4);
            

            
            try{
            HibernateMain.modifyUser(id, lastname, firstname, mail, password);
            ConnectionBd.ModifyRole(id,rol1,rol2,rol3,rol4);
            }
            catch (ExceptionBd e){
                out.println("erreur modif role");
            }

            Users u = HibernateMain.infoUser(id);

            RequestDispatcher rd = request.getRequestDispatcher("AdminManage");
            request.setAttribute("user", u);
            rd.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
    }

}
