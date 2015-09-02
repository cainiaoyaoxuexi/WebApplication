<%-- 
    Document   : AdminList
    Created on : 30 mars 2015, 14:51:24
    Author     : 21000330
--%>

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
            </ul>
        </nav>
    </header>

	<section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Administration space</h3>
                <h4>Choose an account to manage it or create one.</h4> 
            </hgroup>
            <article>
                <div class="selectadmin">
                	<form id="formadmin" action="seeUserServlet">
                        <div class="selectrole">
                            <select id="roles" onchange="user()">
                                <option>Select role...</option>
                                <option>Negotiator</option>&
                                <option>Preparator</option>
                                <option>Consultant</option>
                                <option>Administrator</option>
                            </select>
                        </div>
                		<div class="selectaccount">
                            <select id="account" name="accountId">
                                <option>--</option>
                            </select>
                        </div>
                        <div class="submitadmin">
                        	<input type="submit" id="submit" value="Submit">
                        </div>
                    </form>
                </div>
                <div class="createadmin">
                	<a href="AdminNew"><input type="submit" value="New... "  /></a>
                </div>
<!--                <b> Lancement servlet See</b> <a href="SeeUserServlet?accountId=AI_PREP13"> Go! </a>
                <b> Lancement servlet Modify</b> <a href="ModifyUserServlet?id=PROC_AI1&last=Bale&first=Chritiane&mail=bale.christian@airbus.fr&psw=codeva12"> Go! </a>-->
            </article>
        </section>

</body>
</html>
