<%@page import="Hibernate.Users"%>
<%@page import="Hibernate.HibernateMain"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Hibernate.Partnegotiation"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

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

        <%--<meta http-equiv="refresh" content="5" url="LoginServlet">--%>
        <script type="text/javascript" src="js/FonctionXml.js"></script>
        <script language="javascript">
            today = new Date;
            day = today.getDay();
            number = today.getDate();
            if (number < 10)
                number = "0" + number;
            month = today.getMonth();
            year = today.getFullYear();
            TabDay = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
            TabMonth = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
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
                    <li><form><a href="Index">Log out</a></form></li>
                    <li><a href="ConnServlet">Negotiation module</a></li>
                    <li><a href="Report">Reporting module</a></li>
                        <%   ArrayList<String> list = (ArrayList<String>) session.getAttribute("rol");
                            if (list.contains("Administrator")) {
                                out.print("<li><a href=\"AdminList\">Administration module</a></li>");
                            }%>
                </ul>
            </nav>
        </header>

        <section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Negotiation spaces list</h3>
                <h4>Please choose a negotation space to consult it.</h4> 
            </hgroup> 
            <article> 
                <form>
                    <table border="0" width="700" cellspacing="0" cellpadding="5px">
                        <tr>
                           <td width="147px" align="center">Part Number</td>
                            <td width="88px" align="center">Technocode</td>
                            <td width="176px" align="center">Negotiation Status</td>
                            <td width="149px" align="center">First need date</td>
                            <td width="149px" align="center">Feasability date</td>
                            <td width="149px" align="center">Feasability alert</td>
                            <td width="96px" align="center">Notification</td>
                            <td width="95px" align="center">Price</td>
                            <td width="" align="center">&nbsp;</td>

                        </tr>
                        <%
                            List<Partnegotiation> lst = (List<Partnegotiation>) request.getAttribute("lstN");

                            out.print("<tr>");
                            out.print(" <td width=\"147px\" align=\"center\"></td>");
                        %>
                        <td width="88px" align="center"><select id="techno" onchange="techs()">
                                <%
                                    for (Partnegotiation p : lst) {
                                        try {
                                            out.print("<option>" + p.getPart().getTechnology().getTechnocode() + "</option>");
                                        } catch (Exception e) {

                                        }
                                    }
                                %>
                            </select></td>
                            <%
                                out.print("<td width=\"176px\" align=\"center\"><select id=\"status\" name=\"stat\" onchange=\"negoStat()\">");

                                out.print("<option>new</option>");
                                out.print("<option>in progress</option>");
                                out.print("<option>validated</option>");

                                out.print("</select></td>");

                                out.print("<td width=\"149px\" align=\"center\">"
                                        + //                                     "<select id=\"fnd\" name=\"date\">");
                                        //                            for (Partnegotiation p : lst) {
                                        //                                out.print("<option>" + p.getFirstdate() + "</option>");
                                        //                            }
                                        //                            out.print("</select>"
                                        "</td>");

                                out.print("<td width=\"96px\" align=\"center\"><select id=\"notif\" name=\"not\">");
                                for (Partnegotiation p : lst) {
                                    out.print("<option> notification</option>");
                                }
                                out.print("</select></td>");

                                out.print("<td width=\"95px\" align=\"center\" >&nbsp;</td>");
                                out.print("<td width=\"\" align=\"center\">&nbsp;</td>");

                                out.print("</tr>");
                            %>

                    </table>
                    <div class="negolist" id="ListPartNeg"> 

                        <%
                            list = (ArrayList<String>) session.getAttribute("rol");

                            lst = (List<Partnegotiation>) request.getAttribute("lstN");

                            for (Partnegotiation p : lst) {
                                Date da = HibernateMain.Feasabilitydate(p.getNumberneg(), p.getPart().getTechnology().getTechnocode());

                                out.print("<a href=\"Negotiation.jsp?numParNeg=" + p.getNumberneg() + "\"><submit>");
                                out.print("<table border=\"0\" border-collapse=\"collapse\" width=\"680\" cellspacing=\"0\" cellpadding=\"5px\">");
                                out.print("<tr>");

                                out.print("<td width=\"16%\" align=\"center\">" + p.getPart().getNumberpart() + "</td>");
                                try {
                                    out.print("<td width=\"12%\" align=\"center\">" + p.getPart().getTechnology().getTechnocode() + "</td>");
                                } catch (NullPointerException e) {
                                    out.print("<td width=\"12%\" align=\"center\"> -- </td>");
                                }

                                out.print("<td width=\"19%\" align=\"center\">" + p.getNegostatus() + "</td>");
                                out.print("<td width=\"15%\" align=\"center\">" + p.getFirstdate() + "</td>");
                                
                                out.print("<td width=\"15%\" align=\"center\">" + da + "</td>");
                                try {
                                    out.print("<td width=\"15%\" align=\"center\">" + HibernateMain.alertecycles(p.getNumberneg(), da) + " </td>");
                                } catch (Exception e) {
                                    out.print("<td width=\"15%\" align=\"center\">" + e.getMessage() + "</td>");
                                }
                                try {
                                    String mail = session.getAttribute("email").toString();
                                    System.out.println("mail" + mail);
                                    Users u = HibernateMain.infoUserEmail(mail);

                                    String id = u.getIduser();
                                    System.out.println("id" + id);
                                    out.print("<td width=\"15%\" align=\"center\">" + HibernateMain.getnotification(id, p.getNumberneg()) + " </td>");
                                } catch (Exception e) {

                                    out.print("<td width=\"15%\" align=\"center\">" + e.getMessage() + "</td>");
                                }

                                if (list.contains("Preparator") && !list.contains("Consultor") && !list.contains("Negotiator")) {
                                    out.print("<td width=\"15%\" align=\"center\">   </td>");
                                } else {
                                    try {
                                        out.print("<td width=\"15%\" align=\"center\">" + HibernateMain.infoPrixNego(p.getNumberneg()) + " </td>");
                                    } catch (Exception e) {
                                        out.print("<td width=\"15%\" align=\"center\">-  </td>");

                                    }
                                }


                                out.print("</tr>");
                                out.print("</table>");
                                out.print("</submit></a>");

                            }

                        %>                           

                    </div>
                </form>

            </article>

        </section>
    </body>

</html>
