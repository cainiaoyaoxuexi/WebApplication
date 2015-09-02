<%-- 
    Document   : reporting
    Created on : 2 avr. 2015, 15:20:31
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
        <script type="text/JavaScript" src="js/FonctionXml.js"></script>
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
                <li><a href="ConnServlet">Negotiation module</a></li>
                <li><a href="Report">Reporting module</a></li>
            </ul>
        </nav>
    </header>

	<section>
            <hgroup>
                <div class="logo"><img src="html/img/plane02.gif" width="75" height="70"></div>
                <h3>Reporting</h3>
                <h4>Make your own steering reports.</h4> 
            </hgroup>
            <article>
            <form method="POST" action="">
            	<select id="month" onchange="reporting();return false;">
                    <option>Breakdown...</option>
                    <option>By negotiation status</option>
                </select>
                
<!--            	<select id="month" onchange="reporting();return false;">
                	<option>Month...</option>
                	<option>January</option>
                	<option>February</option>
                	<option>March</option>
                	<option>April</option>
                	<option>May</option>
                	<option>June</option>
                	<option>July</option>
                	<option>August</option>
                	<option>September</option>
                	<option>October</option>
                	<option>November</option>
                	<option>December</option>
                </select>
            	<select id="year">
                	<option>Year...</option>
                	<option>2015</option>
                	<option>2014</option>
                	<option>2013</option>
                	<option>2012</option>
                	<option>2011</option>
                	<option>2010</option>
                	<option>2009</option>
                	<option>2008</option>
                	<option>2007</option>
                	<option>2006</option>
                	<option>2005</option>
                	<option>2004</option>
                </select>
            	<select id="price">
                	<option>Price...</option>
                	<option>Under 10k</option>
                	<option>Between 10k & 100k</option>
                	<option>Over 100k</option>
                </select>
            	<select id="pricestatus">
                	<option>Price status...</option>
                	<option>Normal</option>
                	<option>Temporary</option>
                </select>
            	<select id="entreprise">
                	<option>Company validating...</option>
                	<option>Airbus</option>
                	<option>Stelia</option>
                </select>
            	<select id="technology">
                	<option>Technology...</option>
                	<option>Techno 1</option>
                	<option>Techno 2</option>
                </select>
                </br></br>
            	<select id="display">
                	<option>Display type...</option>
                	<option>Sectors diagram</option>
                	<option>Ring diagram</option>
                	<option>Histogram</option>
                </select>
                <input type="submit" value="Submit" onclick="reporting();return false;"/>-->
                </br></br>
                <button style="button">Export</button>
                </br></br>
                <div id="graf" width="700px" height="500px"></div>
                </form>
                <!--<b> Lancement servlet </b> <a href="ReportingServlet"> Go! </a>-->
                </article>
        </section>

</body>
</html>