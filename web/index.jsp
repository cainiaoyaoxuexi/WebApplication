

<%@page import="Hibernate.HibernateMain"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html >
    <h:head>
        <title>Negotiation Platform</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <!--specific Meta data to employee portal-->
        <meta name="Owner.corporateName" content="AIRBUS"/>
        <meta name="Aircraft.type" content=""/>
        <meta name="Aircraft.series" content=""/>
        <meta name="Aircraft.family" content=""/>
        <meta name="Rights" content="AIRBUS"/>
        <meta name="Type.category" content="eSite"/>
        <meta name="Type.aggregationLevel" content="collection"/>
        <meta name="Subject.keywords" content=""/>
        <meta name="Description" content=""/>
        <link rel="stylesheet" href="css/app_css.css" type="text/css"/>
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
<!--                    <li><a href="Index">Deconnection</a></li>-->
                </ul>
            </nav>
        </header>

        <section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Identification</h3>
                <h4> Please fill in the fields to connect. </h4> 
            </hgroup> 
            <article> 
                <form method="post" action="ConnServlet">
                    <table width="80" border="0" cellpadding="5px" cellspacing="0">
                        <tr> 
                            <td height="18" align="right">Login:</td>
                            <td><input id="log" type="email" name="login" onkeyup="role()" required >
                            </td>
                        </tr>
                        <tr>
                            <td height="18" align="right">Password:</td>
                            <td><input type="password" name="password" required></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td align="center"><input type="submit" value="Validate"></td>
                        </tr>

                    </table>
                </form>

                <%
                    /*----- Affichage du message d'erreur (éventuel) -----*/
                    String msg_erreur = (String) request.getAttribute("msg_erreur");

                    if (msg_erreur != null) {
                        out.println("<p>" + msg_erreur + "</p>");
                    }
                     session.removeAttribute("email");                    
                     session.removeAttribute("password");
                     session.removeAttribute("rol");
                     //HibernateMain.FermerSession();
//                     HibernateMain.OpenSession();
                %>
                <br/> 
<!--                <b> Lancement servlet </b> <a href="RoleServlet?email=dupont.gerard@airbus.fr"> Go! </a>
                <b> Lancement servlet </b> <a href="StatusNegServlet?stat=validated"> Go! </a>
                <b> Lancement servlet </b> <a href="RefPubComment?"> Go! </a>-->
           
            
            </article>
        </section>

        </h:body>
        </html>


