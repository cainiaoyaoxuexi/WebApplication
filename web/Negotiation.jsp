<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Hibernate.Users"%>
<%@page import="Hibernate.Propose"%>
<%@page import="Hibernate.HibernateMain"%>
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
        <script type="text/JavaScript" src="js/FonctionXml.js"></script>
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
                    <li><a href="index.jsp">Log out</a></li>
                    <li><a href="ConnServlet">Negotiation module</a></li>
                    <li><a href="Report">Reporting module</a></li>
                </ul>
            </nav>
        </header>

        <section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Negotiation space</h3>
                <h4>Let comments and negotiate the price.</h4> 
            </hgroup>
            <article>
                <div class="information">

                    <%
                        short numPartNeg;
                        try {
                            numPartNeg = Short.parseShort(request.getParameter("numParNeg"));
                            session.setAttribute("numPartNeg", numPartNeg);
                        } catch (Exception e) {
                            try{
                            numPartNeg = Short.parseShort(session.getAttribute("numPartNeg").toString());
                            }catch (Exception ex) {
                                numPartNeg =Short.parseShort(request.getAttribute("numPartNeg").toString());
                            }
                        }

//                        try {
                        out.print("<input type='hidden' id='nbg' name='numberNeg' value='" + numPartNeg + "' >");

                        try {
//                            try {
//                                numPartNeg = Short.parseShort(request.getParameter("numParNeg"));
//                                session.setAttribute("numPartNeg", numPartNeg);
//                            } catch (Exception e) {
//                                numPartNeg = Short.parseShort(session.getAttribute("numPartNeg").toString());
//                            }
                            Partnegotiation pnego = HibernateMain.infoNegotiation((short) numPartNeg);

                            out.println("Negotiation number: " + pnego.getNumberneg() + "</br>");
                            out.println("Quantity: " + pnego.getFirstquantity() + "</br>");
                            out.println("First Date Need: " + pnego.getFirstdate() + "</br>");
                        } catch (Exception e) {

                        }
//                        } catch (NullPointerException e) {
//                            out.println(" The negotiation n° " + request.getParameter("numParNeg") + " hasn't any information");
//                        }
//                            if (pnego.getFinalprice() != null) {
//                                if (pnego.getDevises().equals("USD")) {
//                                    out.println("Final Price: " + pnego.getFinalprice() + " $</br>");
//                                } else {
//                                    out.println("Final Price: " + pnego.getFinalprice() + " €</br>");
//                                }
//
//                            } else {
//                                out.println("Price: No price. </br>");
//                            }

//                            BigDecimal lastprice = HibernateMain.inforPropose(numPartNeg).getPrice();
//                            if (lastprice != null) {
//                            String priceG;
                        try {
//                            if (!request.getParameter("pr").isEmpty())
//                                 priceG = request.getParameter("pr");

                            Partnegotiation pnego = HibernateMain.infoNegotiation((short) numPartNeg);//                            
                            BigDecimal lastprice = HibernateMain.inforPropose(numPartNeg).getPrice();

                            if (pnego.getDevises().equals("USD")) {
                                out.println("last price: " + lastprice + " $</br>");
                            } else {
                                out.println("last price: " + lastprice + " €</br>");
                            }

                            out.println("<form id='validation' method='post' action='updatePriceServlet?part=" + numPartNeg + "&price=" + lastprice + "'>");
                            if (pnego.getNegostatus().equals("validated")) {
                                out.println("<input type=\"submit\" id=\"validation\" value=\"Validate price\" disabled >");
                            } else {
                                out.println("<input type=\"submit\" id=\"validation\" value=\"Validate price\"  >");
                            }
                            out.println("</form>");
//                            } else {
                        } catch (Exception e) {
                            out.println("last price: No price");
                        }
                    %>

                    <form action="acceptFile" method="post" enctype="multipart/form-data">
                        </br><b>Select the file to upload:</b>
                        <input type="file" name="upload" siez="16">
                        <input type="submit" value="Validate"> 
                    </form>

                    </br><b>Select the file to download:</b><br>
                    <div class="depot">
                        <%                            File file = new File("f:/serveur/file");
                            File[] list = file.listFiles();
                            for (File f : list) {
                                out.println("<a href=\"downloadFileServlet?nameFile=" + f.getName() + "\">" + f.getName() + "</a></br>");
                            }

                        %>
                    </div>
                    </br>  


                </div>
                <div class="private" id="secretzone">
                    <!--<b>Lancement direct d'une servlet. </b><a href="RefPriComment">Go !</a><br/>-->
                    <table>
                        <%                            try {
                                List<Propose> prop2 = new ArrayList();
//                                prop2 = HibernateMain.privateComments(Integer.parseInt(session.getAttribute("numPartNeg").toString()));
                                prop2 = HibernateMain.privateComments(numPartNeg);
//                                prop2 = HibernateMain.privateComments(Integer.parseInt(session.getAttribute("numPartNeg").toString()),session.getAttribute("email").toString());
                                String idUser = HibernateMain.infoUserEmail(session.getAttribute("email").toString()).getIduser();
                                if (prop2.size() == 0) {
                                    out.println("<b><center><div class='secretM'> No private comment avalible!</b></div></center>");

                                } else {
                                    for (Propose propose : prop2) {
                                        if (propose.getUsers().getIduser().equals("idUser")) {
                                            out.println("<div class='secretM'>");
                                            out.println("<b>You: </b>(" + propose.getId().getDatepro() + ")</br>");
                                            out.println(propose.getCommentpart() + "</br></br>");
                                            out.println("</div>");
                                        } else {
                                            out.println("<div class='secretO'>");
                                            out.println("<b>" + propose.getUsers().getFirstname() + " " + propose.getUsers().getLastname() + "</b> (" + propose.getId().getDatepro() + ")</br>");
                                            out.println(propose.getCommentpart() + "</br></br>");
                                            out.println("</div>");
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                out.println("<div class='secretO'>");
                                out.println("Unreachable comment. Please try again." + e.getMessage());
                                out.println("</div>");
                            }

                        %>
                    </table>                        
                </div>                        
                <script>
                    document.getElementById('secretzone').scrollTop = document.getElementById('secretzone').scrollHeight;
                </script>              

                <div class="letprivate">
                    <form action="privateCommentServelet" method="GET">
                        <input type="text" placeholder="Your private comment..." name="priComment" size="40" required/>
                        <input type="submit"  value="Send"/>
                    </form>
                </div>
                <hr>
                <div class="public" id="publiczone">
                    <!--<b>Lancement direct d'une servlet. </b><a href="RefPubComment">Go !</a><br/>-->

                    <%                        try {

//                            List<Propose> prop = HibernateMain.publicComments(Short.parseShort(session.getAttribute("numPartNeg").toString()));
                            List<Propose> prop = HibernateMain.publicComments(numPartNeg);
                            if (prop.size() == 0) {
                                out.println("<b><center><div class='commentA'> No public comment  avalible!</b></div></center>");

                            } else {
                                for (Propose propose : prop) {
                                    if (propose.getUsers().getCompany().getName().equals("Airbus")) {
                                        out.println("<div class='commentA'>");
                                    } else if (propose.getUsers().getCompany().getName().equals("Stelia")) {
                                        out.println("<div class='commentS'>");
                                    }

                                    out.println("<b>" + propose.getUsers().getFirstname() + " " + propose.getUsers().getLastname() + "</b> (" + propose.getId().getDatepro() + ")</br>");
                                    out.println(propose.getCommentpart() + "</br>");
                                    out.println("<b><p>");

                                    //      pnego = HibernateMain.infoNegotiation(Integer.parseInt(session.getAttribute("numPartNeg").toString()));
                                    String d = "";
                                    try {
                                        Partnegotiation pnego = HibernateMain.infoNegotiation((short) numPartNeg);
                                        if (pnego.getDevises().equals("USD")) {
                                            d = "$";
                                        } else {
                                            d = "€";
                                        }
                                    } catch (Exception e) {
                                        d = "€";
                                    }

                                    if (propose.getMatprice() != null) {
                                        out.println("Matprice: " + propose.getMatprice() + d + " | ");
                                    }
                                    if (propose.getLabprice() != null) {
                                        out.println("Labprice: " + propose.getLabprice() + d + " | ");
                                    }
                                    if (propose.getOtherprice() != null) {
                                        out.println("Other: " + propose.getOtherprice() + d + " | ");
                                    }
                                    if (propose.getPrice() != null) {
                                        out.println("Price: " + propose.getPrice() + d + " |");
                                    }

                                    out.println("</p></b></div>");
                                }
                            }
                        } catch (Exception e) {
                            out.println("<div class='commentS'>");
                            out.println("exception " + e.getMessage());
                            out.println("Unreachable comment. Please try again." + e.getMessage());
                            out.println("</div>");
                        }
                    %>
                </div>                
                <div class="letpublic">
                    Comment:</br>
                    <form id="pubCom" method="get" action="publicCommentServlet">
                        <textarea rows="10" name="comment" cols="85" /><%
//                            try {
//                                out.print(session.getAttribute("comment"));
//                            } catch (Exception e) {
//
//                            }
                        %></textarea>
                        Price:<input type="text"  name="price" size="10" placeholder="
                                     <%//                            try {
//                                out.print(session.getAttribute("price"));
//                            } catch (Exception e) {
//                                out.print("");
//                            }
////                                     %>
                                     "/>
                        Matprice:<input type="text" name="matprice"size="10" placeholder="
                                        <%
//                            try {
//                                out.print(session.getAttribute("matprice"));
//                            } catch (Exception e) {
//                                out.print("");
//                            }
                                        %>
                                        "/>
                        Labprice:<input type="text"  name="labprice" size="10" placeholder="
                                        <%//                            try {
//                                out.print(session.getAttribute("labprice"));
//                            } catch (Exception e) {
//                                out.print("");
//                            }
                                        %>
                                        "/>
                        Other:<input type="text" name="other" size="10" placeholder="
                                     <%//                            try {
//                                out.print(session.getAttribute("other"));
//                            } catch (Exception e) {
//                                out.print("");
//                            }
%>
                                     "/>
                        <input type="submit" value="Send"/>
                    </form>
                </div>
                <script>
                    document.getElementById('publiczone').scrollTop = document.getElementById('publiczone').scrollHeight;
                </script>
                <script type="text/javascript">
//                    setInterval('publicComments()', 5000);
//                    setInterval('privateComments()', 5000);
                </script>
            </article>
        </section>
    </body>

</html>
