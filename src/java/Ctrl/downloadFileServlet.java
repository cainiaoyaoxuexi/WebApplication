/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21204711
 */
@WebServlet(name = "downloadFileServlet", urlPatterns = {"/downloadFileServlet"})
public class downloadFileServlet extends HttpServlet {


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
        
        OutputStream o = response.getOutputStream();
       byte b[] = new byte[1024];

       // the file to download.
       File fileLoad = new File("f:/serveur/file",request.getParameter("nameFile") );

       // the dialogbox of download file.
       response.setHeader("Content-disposition", "attachment;filename="+ request.getParameter("nameFile"));

       // set the MIME type.
       response.setContentType("application/x-tar");

       // get the file length.
       long fileLength = fileLoad.length();
       String length = String.valueOf(fileLength);
       response.setHeader("Content_Length", length);

       // download the file.
       FileInputStream in = new FileInputStream(fileLoad);
       int n = 0;
       while ((n = in.read(b)) != -1) {
           o.write(b, 0, n);
       }
        
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
        doGet(request, response);
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
