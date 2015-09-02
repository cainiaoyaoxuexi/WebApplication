
//Pour retourner l'objet XMLHttprequest en fonction du navigateur: explorer pour le projet, mais on met aussi pour firefox et autre navigateur

function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}

function role()
{
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
    var log = document.getElementById("log").value;
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("role");
            // On construit les 'options' de notre liste déroulante.
            var texte = "<option>--</option>";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += "<option>" + l_nuplet[i].firstChild.nodeValue + "</option>";

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("lrole");
            elt.innerHTML = texte;
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "RoleServlet?email=" + log, true);
    xhr.send(null);
}

function refreshPartNeg() {

    var xhr = getXMLHttpRequest();
    var elt = document.getElementById("ListPartNeg");
    elt.innerHTML = "";
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Elément html que l'on va mettre à jour.            
            var suggestions = xhr.responseXML.getElementsByTagName("ligne");
            var text;

            for (var i = 0; i < suggestions.length; i++) {

                text += "<a href=\"Negotiation.jsp\"><submit>" +
                        "<table border=\"0\" border-collapse=\"collapse\" width=\"660\" cellspacing=\"0\" cellpadding=\"5px\">" +
                        "<tr>" +
                        "<td width=\"20%\" align=\"center\">" + suggestions[i].getElementsByTagName("negotiation")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"17%\" align=\"center\">" + suggestions[i].getElementsByTagName("status")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"20%\" align=\"center\">" + suggestions[i].getElementsByTagName("daysleft")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"20%\" align=\"center\">" + suggestions[i].getElementsByTagName("notification")[0].firstChild.nodeValue + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "</submit></a>";

            }
            elt.innerHTML = text;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "RefreshNegServlet", true);
    xhr.send(null);
}

function publicComments()
{
    var xhr = getXMLHttpRequest();
    var elt = document.getElementById("publiczone");
    elt.innerHTML = "";
    var user, company, datePro, com, price, matprice, labprice, other;
    var neg = document.getElementById("nbg").value;
    //var saisi=document.getElementById("saisie").value;
    var text = "";

    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
//            try{
            var pc = xhr.responseXML.getElementsByTagName("publicComment");
//            window.alert("bbbbbbbbb");
            if (pc.length > 0) {
                for (var i = 0; i < pc.length; i++) {
                    user = pc[i].getElementsByTagName("user")[0].firstChild.nodeValue;
                    company = pc[i].getElementsByTagName("company")[0].firstChild.nodeValue;
                    datePro = pc[i].getElementsByTagName("datePro")[0].firstChild.nodeValue;
                    com = pc[i].getElementsByTagName("publicCom")[0].firstChild.nodeValue;
                    price = pc[i].getElementsByTagName("price")[0].firstChild.nodeValue;
                    matprice = pc[i].getElementsByTagName("matprice")[0].firstChild.nodeValue;
                    labprice = pc[i].getElementsByTagName("labprice")[0].firstChild.nodeValue;
                    other = pc[i].getElementsByTagName("otherprice")[0].firstChild.nodeValue;


                    if (company == "Airbus") {
                        text = text + "<div class='commentA'>";
                    } else if (company == "Stelia") {
                        text = text + "<div class='commentS'>";
                    }

                    text = text + "<b>" + user + "</b> (" + datePro + ")</br>";
                    text = text + com + "</br></br>";


                    if (matprice != " ") {
                        text = text + "<b>Matprice: " + matprice + " € |</b>";
                    }
                    if (labprice != " ") {
                        text = text + "<b>Labprice: " + labprice + " € |</b>";
                    }
                    if (other != " ") {
                        text = text + "<b>Other: " + other + " € |</b>";
                    }
                    if (price != " ") {
                        text = text + "<b>Price: " + price + " €</b> ";
                    }
                    text = text + "</div>";
                }
//            }catch(e){
            } else {
//                window.alert("aaaaa");
                text = "<center><b><div class='commentA'> No public comment  avalible!</b></div></center>";
            }
            elt.innerHTML = text;

        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "RefPubComment?numberN=" + neg, true);
    xhr.send(null);
}
function privateComments()
{
    var xhr = getXMLHttpRequest();
    var elt = document.getElementById("secretzone");
    elt.innerHTML = "";
    var user, company, datePro, com;
    //var valeurUser, valeurDatePro, valeurCom, valeurPrice, valeurMatPrice, valeurLabPrice, valeurOther;
    var text = "";
    var neg = document.getElementById("nbg").value;

    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Elément html que l'on va mettre à jour.
//            try{
//                window.alert("aaaaaaaaaa");
            var pc = xhr.responseXML.getElementsByTagName("privateComment");
            if (pc.length > 0) {
//                text= "<b><center><div class='secretM'> No private comment avalible!</div></center></b>";
//            }else{
                for (var i = 0; i < pc.length; i++) {
                    user = pc[i].getElementsByTagName("user")[0].firstChild.nodeValue;
                    company = pc[i].getElementsByTagName("company")[0].firstChild.nodeValue;
                    datePro = pc[i].getElementsByTagName("datePro")[0].firstChild.nodeValue;
                    com = pc[i].getElementsByTagName("privateCom")[0].firstChild.nodeValue;

//                if (company == "Airbus") {
//                    text = text + "<div class='commentA'>";
//                } else if (company == "Stelia") {
//                    text = text + "<div class='commentS'>";
//                }

                    text = text + "<div class='secretM'>";
                    text = text + "<b>" + user + "</b> (" + datePro + ")</br>";
                    text = text + com + "</br></br></div>";

                }
//        }catch(e){
            } else {
                text = "<b><center><div class='secretM'> No private comment avalible!</div></center></b>";
            }
            elt.innerHTML = text;

        }
    };


    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "RefPriComment?numberN=" + neg, true);
    xhr.send(null);
}

function VeriComPub() {
    var com = document.getElementById("comment").value;
    var price = document.getElementById("price").value;
    var matprice = document.getElementById("matprice").value;
    var labprice = document.getElementById("labprice").value;
    var other = document.getElementById("other").value;

    if (com==="" & price === "" & matprice ==="" & labprice === "" & other ==="") {
        alert("Input at least a information");
        return false;
    }else{
        return true;
    }
}




function techs() {
   
    var xhr = getXMLHttpRequest();
    //window.alert("2");
    var techo = document.getElementById("techno").value;
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function ()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Elément html que l'on va mettre à jour.
            
            var suggestions = xhr.responseXML.getElementsByTagName("tables");
            var text = "";
            
            for (var i = 0; i < suggestions.length; i++) {
                
                text += "<a href=\"Negotiation.jsp\"><submit>" +
                        "<table border=\"0\" border-collapse=\"collapse\" width=\"660\" cellspacing=\"0\" cellpadding=\"5px\">" +
                        "<tr>" +
                        "<td width=\"16%\" align=\"center\">" + suggestions[i].getElementsByTagName("negotiation")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"12%\" align=\"center\">" + suggestions[i].getElementsByTagName("t")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"19%\" align=\"center\">" + suggestions[i].getElementsByTagName("statu")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"15%\" align=\"center\">" + suggestions[i].getElementsByTagName("dat")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"13%\" align=\"center\">" + suggestions[i].getElementsByTagName("faisabi")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"15%\" align=\"center\">" + suggestions[i].getElementsByTagName("delai")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"13%\" align=\"center\">"+ suggestions[i].getElementsByTagName("notif")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"15%\" align=\"center\">" + suggestions[i].getElementsByTagName("pric")[0].firstChild.nodeValue + "</td>" +
//                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("none")[0].firstChild.nodeValue + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "</submit></a>";
            }

            var elt = document.getElementById("ListPartNeg");
            elt.innerHTML = text;



        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "RefreshNegServlet?tech=" + techo, true);
    xhr.send(null);
}


function negoStat()
{
    
   //window.alert("1");
    var xhr = getXMLHttpRequest();
   
    var st = document.getElementById("status").value;
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Elément html que l'on va mettre à jour.
            var suggestions = xhr.responseXML.getElementsByTagName("tables");
            var text = "";
            for (var i = 0; i < suggestions.length; i++) {
                text += "<a href=\"Negotiation.jsp\"><submit>" +
                        "<table border=\"0\" border-collapse=\"collapse\" width=\"660\" cellspacing=\"0\" cellpadding=\"5px\">" +
                        "<tr>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("negotiation")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("t")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("statu")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("dat")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"20%\" align=\"center\">" + suggestions[i].getElementsByTagName("faisabi")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("del")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"20%\" align=\"center\">" + suggestions[i].getElementsByTagName("notifi")[0].firstChild.nodeValue + "</td>" +
                        "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("pric")[0].firstChild.nodeValue + "</td>" +
//                          "<td width=\"10%\" align=\"center\">" + suggestions[i].getElementsByTagName("none")[0].firstChild.nodeValue + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "</submit></a>";

            }

            var elt = document.getElementById("ListPartNeg");
            elt.innerHTML = text;
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "StatusNegServlet?stat=" + st, true);
    xhr.send(null);
}


function notify() {
    window.alert("ok");


}
   
function user() {
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
    var role = document.getElementById("roles").value;
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("user");
            // On construit les 'options' de notre liste déroulante.
            var texte = "<option>--</option>";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += "<option>" + l_nuplet[i].getElementsByTagName("id")[0].firstChild.nodeValue + "</option>";

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("account");
            elt.innerHTML = texte;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "AdminListUserServlet?role=" + role, true);
    xhr.send(null);
}



function modify() {
//    window.alert("salut");
    var xhr = getXMLHttpRequest();
    var id = document.getElementById("accountid").value;
    var lastname = document.getElementById("lastname").value;
    var first = document.getElementById("firstname").value;
    var mail = document.getElementById("mail").value;
    var psw = document.getElementById("password").value;
    var r1 = document.getElementById("role1").value;
    var r2 = document.getElementById("role2").value;
    var r3 = document.getElementById("role3").value;
    var r4 = document.getElementById("role4").value;

//    window.alert("id"+id);
    xhr.onreadystatechange = function()
    {
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ModifyUserServlet?id=" + id + "&last=" + lastname + "&first=" + first + "&mail=" + mail + "&psw=" + psw + "&rol1=" + r1 + "&rol2=" + r2 + "&rol3=" + r3 + "&rol4=" + r4, true);
    xhr.send(null);

}

function newUser() {
//    window.alert("salut2");
    var xhr = getXMLHttpRequest();
    var id = document.getElementById("accountid").value;
    var lastname = document.getElementById("lastname").value;
    var first = document.getElementById("firstname").value;
    var mail = document.getElementById("mail").value;
    var psw = document.getElementById("password").value;
    var mail2 = document.getElementById("mail2").value;
    var psw2 = document.getElementById("password2").value;
    var r1 = document.getElementById("role1").value;
    //  window.alert("rol1"+r1);
    var r2 = document.getElementById("role2").value;
    // window.alert("rol2"+r2);
    var r3 = document.getElementById("role3").value;
    //   window.alert("rol3"+r3);
    var r4 = document.getElementById("role4").value;
//    window.alert("rol4"+r4);
    //
    xhr.onreadystatechange = function()
    {
    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "NewUserServlet?idu=" + id + "&last=" + lastname + "&first=" + first + "&mail=" + mail + "&psw=" + psw + "&mail2=" + mail2 + "&psw2=" + psw2 + "&rol1=" + r1 + "&rol2=" + r2 + "&rol3=" + r3 + "&rol4=" + r4, true);
    xhr.send(null);

}

function idExist() {
    var xhr = getXMLHttpRequest();
    var id = document.getElementById("accountid").value;
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("messExist");
            // On construit les 'options' de notre liste déroulante.
            var texte = "";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += l_nuplet[i].firstChild.nodeValue;

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("messId");
            elt.innerHTML = texte;
        }

    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "VerifIdServlet?idu=" + id, true);
    xhr.send(null);
}
function verifMail() {
    var xhr = getXMLHttpRequest();
    var mail = document.getElementById("mail").value;
    var mail2 = document.getElementById("mail2").value;
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("mess");
            // On construit les 'options' de notre liste déroulante.
            var texte = "";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += l_nuplet[i].firstChild.nodeValue;

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("verMail");
            elt.innerHTML = texte;
        }

    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "VerifMailServlet?mail=" + mail + "&mail2=" + mail2, true);
    xhr.send(null);
}
function verifMailExist() {
    var xhr = getXMLHttpRequest();
    var mail = document.getElementById("mail").value;
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("messExist");
            // On construit les 'options' de notre liste déroulante.
            var texte = "";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += l_nuplet[i].firstChild.nodeValue;

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("verMailExiste");
            elt.innerHTML = texte;
        }

    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "VerifMailServlet?mail=" + mail, true);
    xhr.send(null);
}
function verifPsw() {
    var xhr = getXMLHttpRequest();
    var ps = document.getElementById("password").value;
    var ps2 = document.getElementById("password2").value;
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === 4 && xhr.status === 200)
        {
            // Réponse du serveur.
            var l_nuplet = xhr.responseXML.getElementsByTagName("messPass");
            // On construit les 'options' de notre liste déroulante.
            var texte = "";
            for (var i = 0; i < l_nuplet.length; i++)
                texte += l_nuplet[i].firstChild.nodeValue;

            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("verPass");
            elt.innerHTML = texte;
        }

    };

    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "VerifPasswordServlet?psw=" + ps + "&psw2=" + ps2, true);
    xhr.send(null);
}

function reporting()
{
    var xhr = getXMLHttpRequest();
//window.alert(1);
    xhr.onreadystatechange = function()
    {
//window.alert(2);
        // Si l'on a tout reçu et que la requête http s'est bien passée.
        if (xhr.readyState === 4 && xhr.status === 200)
        {
//window.alert(3);
            var suggestions = xhr.responseXML.getElementsByTagName("Graphic");
            
            var text ="<iframe frameborder='0' width='700' height='524' src='http://www.petale-graphique.fr/embed/embed.php?largeur=700&hauteur=524&"+
                        "donnees=Validated:"+suggestions[0].getElementsByTagName("NbVal")[0].firstChild.nodeValue+
                        ",Cancelled:"+suggestions[0].getElementsByTagName("NbCan")[0].firstChild.nodeValue+
                        ",Refused:"+suggestions[0].getElementsByTagName("NbRef")[0].firstChild.nodeValue+
                        ",In progress:"+suggestions[0].getElementsByTagName("NbInProg")[0].firstChild.nodeValue+
                        ",New:"+suggestions[0].getElementsByTagName("NbNew")[0].firstChild.nodeValue+
                        ",Provisional:"+suggestions[0].getElementsByTagName("NbProv")[0].firstChild.nodeValue+
                        "&modele=camembert&legende=oui&palette=bleu' allowtransparency='true' style='background-color:transparent;'></iframe>";
                //camember / anneau / histogramme
            var elt = document.getElementById("graf");
            elt.innerHTML = text;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET", "ReportingServlet", true);
    xhr.send(null);
}
   