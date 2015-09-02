<%-- 
    Document   : AdminManage
    Created on : 31 mars 2015, 09:27:11
    Author     : 21000330
--%>

<%@page import="bd.ConnectionBd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Hibernate.Positions"%>
<%@page import="java.util.List"%>
<%@page import="Hibernate.HibernateMain"%>
<%@page import="Hibernate.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
	<head>
        <title>Negotiation Platform</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <!--specific Meta data to employee portal-->
        <meta name="Owner.corporateName" content="AIRBUS">
        <meta name="Aircraft.type" content="">
        <meta name="Aircraft.series" content="">
        <meta name="Aircraft.family" content="">
        <meta name="Rights" content="AIRBUS">
        <meta name="Type.category" content="eSite">
        <meta name="Type.aggregationLevel" content="collection">
        <meta name="Subject.keywords" content="">
        <meta name="Description" content="">
        <link rel="stylesheet" href="css/app_css.css" type="text/css">
        <script type="text/javascript" src="js/FonctionXml.js"></script>
    	<script language="javascript">
            today = new Date;
            day = today.getDay();
            number = today.getDate();
          if (number<10)
            number = "0"+number;
            month = today.getMonth();
            year = today.getFullYear();
            TabDay = new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
            TabMonth = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
            messageDate = TabDay[day] + " " + number + " " + TabMonth[month] + " " + year;
        </script>
    </head>

<body>
    <header>
        <div class="top">
            <div class="topleft">
                Home
            </div>
            <div class="topright">
				<script>document.write(messageDate);</script>
            </div>
        </div>
        <h1>
        	<div class="h1bis"><img src="html/claflib/banner/banner.gif"></div>
        </h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Log out</a></li>
                <li><a href="AdminList.jsp">Admin Module</a></li>
                
            </ul>
        </nav>
    </header>

	<section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Account creation</h3>
                <h4>Create a new user account.</h4> 
            </hgroup>
            <article>
                <form action="ModifyUserServlet">

                	<div class="newaccount" id="seeUser">
                         <%
                            
                            Users u = (Users)request.getAttribute("user");
              
                            out.print(" <table>");
                            out.print("<tr><td width=\"250px\">User ID (*)</td><td><input style=\"width: 200px;\" type=\"text\" id=\"accountid\" name=\"idu\" value=\""
                            +u.getIduser()+"\" /></td></tr>");
                        out.print("</table>");
                        out.print("<hr>");
                        out.print("<table>");
                            out.print("<tr>");
                                out.print("<td><b>Account holder information</b></td>");
                                out.print("<td> </td>");
                            out.print("</tr>");
                            out.print("<tr>");
                                out.print("<td width=\"250px\">Last name (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"text\" id=\"lastname\" name=\"last\" value=\""+u.getLastname()+"\" /></td>");
                            out.print("</tr>");
                            out.print("<tr>");
                                out.print("<td width=\"250px\">First name (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"text\" id=\"firstname\" name=\"first\" value=\""+u.getFirstname()+"\" /></td>");
                            out.print("</tr>");
                            out.print("<tr>");
                                out.print("<td width=\"250px\">E-mail (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"email\" id=\"mail\" name=\"mail\" value=\""+u.getEmail()+"\" /></td>");
                            out.print("</tr>");
                            out.print("<tr>");
                                out.print("<td width=\"250px\">E-mail confirmation (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"email\" id=\"mail2\" name=\"mail2\" value=\""+u.getEmail()+"\" /></td>");
                            out.print("</tr>");
                            out.print("<tr>");
                               out.print("<td width=\"250px\">Password (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"texte\" id=\"password\" name=\"psw\" value=\""+u.getPassword()+"\" /></td>");
                           out.print("</tr>");
                            out.print("<tr>");
                                out.print("<td width=\"250px\">Password confirmation (*)</td>");
                                out.print("<td><input style=\"width: 200px;\" type=\"texte\" id=\"password2\" name=\"psw2\" value=\""+u.getPassword()+"\" /></td>");
                            out.print("</tr>");
                         out.print("</table>");
                         out.print("<hr>");
                        out.print("<table>");
                           out.print(" <tr>");
                               out.print(" <td><b>Account holder roles</b></td>");
                            out.print("</tr>");
                            out.print("<tr>");
                            	out.print("<td>");
                                  ArrayList<String> l = ConnectionBd.retourneRole(u.getEmail());
//                                  for(String r:l){
//                                      out.print("role"+r);
//                                  }
                                  if(l.contains("Negotiator")){
                                      out.print("<INPUT type=\"checkbox\" id=\"role1\" name=\"rol1\" value=\"y\" checked /> Negotiator ");
                                  }else
                                      out.print("<INPUT type=\"checkbox\" id=\"role1\" name=\"rol1\" value=\"n\" /> Negotiator ");
                                  if(l.contains("Preparator")){
                                      out.print("<INPUT type=\"checkbox\" id=\"role2\" name=\"rol2\" value=\"y\" checked /> Preparator ");
                                  }else
                                      out.print("<INPUT type=\"checkbox\" id=\"role2\" name=\"rol2\" value=\"n\" /> Preparator ");
                                  if(l.contains("Consultant")){
                                      out.print("<INPUT type=\"checkbox\" id=\"role3\" name=\"rol3\" value=\"y\" checked /> Consultant ");
                                  }else
                                      out.print("<INPUT type=\"checkbox\" id=\"role3\" name=\"rol3\" value=\"n\" /> Consultant ");
                                  if(l.contains("Administrator")){
                                      out.print("<INPUT type=\"checkbox\" id=\"role4\" name=\"rol4\" value=\"y\" checked /> Administrator ");
                                  }else
                                      out.print("<INPUT type=\"checkbox\" id=\"role4\" name=\"rol4\" value=\"n\" /> Administrator ");
                               out.print(" </td>");
                            out.print("</tr>");
                        out.print("</table></td></br>");
                        out.print("<table>");
                            out.print("<tr>");
                                out.print("<td width=\"500px\"></td>");
                                out.print("<td>");
                                	out.print("<input type=\"submit\" id=\"modifyadmin\" value=\"Modify\" onclick=\"modify()\"/>");
                                    out.print("<input type=\"button\" id=\"deleteadmin\" value=\"Delete\" onclick=\"\"/> ");
                                out.print("</td>");
                            out.print("</tr>");
                       out.print(" </table>"); 
                            %>
                        
                	</div>
                </form>
             
            </article>
                            
        </section>

</body>
</html>

