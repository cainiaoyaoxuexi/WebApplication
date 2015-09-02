<%-- 
    Document   : AdminModify
    Created on : 31 mars 2015, 14:31:33
    Author     : 21003648
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
                <form>
                        <div class="newaccount" id="seeUser2">
                        </div>
                </form>
            </article>
                            
        </section>

</body>
</html>

