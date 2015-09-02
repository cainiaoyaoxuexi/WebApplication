<%-- 
    Document   : AdminNew
    Created on : 1 avr. 2015, 11:56:36
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
                <form acction="NewUserServlet">
                	<div class="newaccount">
                        <table>
                            <tr>
                                <td width="250px">User ID (*)</td>
                                <td><input type="text" style="width: 200px;" id="accountid" name="idu" onkeyup="idExist()" requiered/></td>
                                 <td width="150px" id="messId"></td>
                            </tr>
                        </table>
                        <hr>
                        <table>
                            <tr>
                                <td><b>Account holder information</b></td>
                                <td> </td>
                            </tr>
                            <tr>
                                <td width="250px">Last name (*)</td>
                                <td><input type="text" style="width: 200px;" id="lastname" name="last" requiered/></td>
                                 <td width="150px" ></td>
                            </tr>
                            <tr>
                                <td width="250px">First name (*)</td>
                                <td><input type="text" style="width: 200px;" id="firstname" name="first" requiered/></td>
                                 <td width="150px" ></td>
                            </tr>
                            <tr>
                                <td width="250px">E-mail (*)</td>
                                <td><input type="email" style="width: 200px;" id="mail" name="email" onkeyup="verifMailExist()" requiered/></td>
                                 <td width="150px" id="verMailExiste"></td>
                            </tr>
                            <tr>
                                <td width="250px">E-mail confirmation (*)</td>
                                <td><input type="email" style="width: 200px;" id="mail2" name="email2" onkeyup="verifMail()" requiered/></td>
                                <td width="150px" id="verMail"></td>
                            </tr>
                            <tr>
                                <td width="250px">Password (*)</td>
                                <td><input type="password" style="width: 200px;" id="password" name="psw" requiered/></td>
                                <td width="150px" ></td>
                            </tr>
                            <tr>
                                <td width="250px">Password confirmation (*)</td>
                                <td><input type="password" style="width: 200px;" id="password2" name="psw2" onkeyup="verifPsw()" requiered/></td>
                                <td width="150px" id="verPass"></td>
                            </tr>
                        </table>
                        <hr>
                        <table>
                            <tr>
                                <td><b>Account holder roles</b></td>
                            </tr>
                            <tr>
                            	<td>
                                    <INPUT type="checkbox" id="role1" name="rol1" onchange="this.value = this.checked ? 'y' : 'n'"> Negotiator    
                                    <INPUT type="checkbox" id="role2" name="rol2" onchange="this.value = this.checked ? 'y' : 'n'"> Preparator 
                                    <INPUT type="checkbox" id="role3" name="rol3" onchange="this.value = this.checked ? 'y' : 'n'"> Consultant
                                    <INPUT type="checkbox" id="role4" name="rol4" onchange="this.value = this.checked ? 'y' : 'n'"> Administrator
                                </td>
                            </tr>
                        </table></td></br>
                        <table>
                            <tr>
                                <td width="750px"></td>
                                <td><input type="submit" id="submitadminnew" value="Create" onclick="newUser()" /></td>
                            </tr>
                       <!--       <b> Lancement servlet New</b> <a href="NewUserServlet?idu=PROC_AI100&last=Ber&first=Carol&mail=ber.carole@airbus.fr&mail2=ber.carole@airbus.fr&psw=codev&psw2=codev&rol1=y"> Go! </a>-->
                        </table>
                	</div>
                </form>
            </article>
        </section>

</body>
</html>
