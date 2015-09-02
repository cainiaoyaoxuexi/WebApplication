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
@WebServlet(name = "NewUserServlet", urlPatterns = {"/NewUserServlet"})
public class NewUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");

        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            
            /*----- Récupération de la personne connectée -----*/
          //  String idUserConn=session.getAttribute("accountId").toString();

            /*----- Récupération des paramètres -----*/
            String id = request.getParameter("idu");
            System.out.println("id" + id);
            String lastname = request.getParameter("last");
            System.out.println("lastname" + lastname);

            String firstname = request.getParameter("first");
            System.out.println("firstname" + firstname);
            String mail = request.getParameter("mail");
            System.out.println("email" + mail);
            String mail2 = request.getParameter("mail2");
            System.out.println("email2" + mail2);
            String password = request.getParameter("psw");
            System.out.println("password" + password);
            String password2 = request.getParameter("psw2");
            System.out.println("password2" + password2);
            String roly1 = null;
            String roly2 = null;
            String roly3 = null;
            String roly4 = null;
            roly1= request.getParameter("rol1");
            System.out.println("rol1" + roly1);
            roly2 = request.getParameter("rol2");
            System.out.println("rol2" + roly2);
            roly3 = request.getParameter("rol3");
            System.out.println("rol3" + roly3);
            roly4 = request.getParameter("rol4");
            System.out.println("rol4" + roly4);
            

          //  Users u = HibernateMain.infoUser(idUserConn);

            try{
            //if (u.getCompany().getNumbercompany()==1){ 
            ConnectionBd.insertUserAirbus(id, lastname, firstname, password, mail);
            System.out.println("inséré");
            //}else if(u.getCompany().getNumbercompany()==2){
              //  ConnectionBd.insertUserStelia(id, lastname, firstname, password, mail);
            //}
            System.out.println("rol1" + roly1);
            System.out.println("rol2" + roly2);
            System.out.println("rol3" + roly3);
            System.out.println("rol4" + roly4);
           ConnectionBd.ModifyRole(id, roly1, roly2, roly3, roly4);
           System.out.println("modifie");
          Users uCreate=HibernateMain.infoUser(id);
            RequestDispatcher rd = request.getRequestDispatcher("AdminList");
            request.setAttribute("user", uCreate);
            rd.forward(request, response);
            }
            catch (ExceptionBd e){
                out.println("erreur new role");
            }

            

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
////         HttpSession session = request.getSession(true);
//        /*----- Type de la réponse -----*/
//        response.setContentType("application/xml");
//
//        try (PrintWriter out = response.getWriter()) {
//            /*----- Ecriture de la page XML -----*/
//            out.println("<?xml version=\"1.0\"?>");
//            
//            /*----- Récupération de la personne connectée -----*/
//          //  String idUserConn=session.getAttribute("accountId").toString();
//
//            /*----- Récupération des paramètres -----*/
//            String id = request.getParameter("idu");
//            System.out.println("id" + id);
//            String lastname = request.getParameter("last");
//            System.out.println("lastname" + lastname);
//
//            String firstname = request.getParameter("first");
//            System.out.println("firstname" + firstname);
//            String mail = request.getParameter("mail");
//            System.out.println("email" + mail);
//            String mail2 = request.getParameter("mail2");
//            System.out.println("email2" + mail2);
//            String password = request.getParameter("psw");
//            System.out.println("password" + password);
//            String password2 = request.getParameter("psw2");
//            System.out.println("password2" + password2);
//            String rol1 = request.getParameter("rol1");
//            System.out.println("roly1" + rol1);
//            String rol2 = request.getParameter("rol2");
//            System.out.println("roly2" + rol2);
//            String rol3 = request.getParameter("rol3");
//            System.out.println("roly3" + rol3);
//            String rol4 = request.getParameter("rol4");
//            System.out.println("roly4" + rol4);
//            
//
//          //  Users u = HibernateMain.infoUser(idUserConn);
//
//            try{
//            //if (u.getCompany().getNumbercompany()==1){ 
//            ConnectionBd.insertUserAirbus(id, lastname, firstname, password, mail);
//            System.out.println("inséré");
//            //}else if(u.getCompany().getNumbercompany()==2){
//              //  ConnectionBd.insertUserStelia(id, lastname, firstname, password, mail);
//            //}
//           ConnectionBd.ModifyRole(id,rol1,rol2,rol3,rol4);
//            System.out.println("modifie");
//          Users uCreate=HibernateMain.infoUser(id);
//            RequestDispatcher rd = request.getRequestDispatcher("AdminList");
//            request.setAttribute("user", uCreate);
//            rd.forward(request, response);
//            }
//            catch (ExceptionBd e){
//                out.println("erreur new role");
//            }
//
//            
//
//        }
    }
}
