/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

/**
 *
 * @author 21103205
 */
import bd.ConnectionBd;
import bd.ExceptionBd;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class HibernateMain {

//    private static Session ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//   
//    private static Transaction tc = ses.beginTransaction();
    private static Session ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
    private static Transaction tc = ses.beginTransaction();
//    private static Transaction tc;

//private static Session ses;
//private static Transaction tc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        System.out.println(infoNegotiation(14).getEntrydate());
//        System.out.println(infoUser("PROC_AI1").getCompany().getName());
//        System.out.println(trouveCompany(2).getName());

//       Session ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//       Company c= new Company(4, "Airbus"); 
//        Transaction tc = ses.beginTransaction();
//       ses.save(c); 
//       tc.commit(); // Commit et flush automatique de la session
//       System.out.println("company "+c.getNumbercompany());
//        Query q = ses.createQuery("from Users");
//       List<Users> us = (List<Users>) q.list();
//       System.out.println("us " + us.size());
//       
//             for (Users users : us) {
//                 System.out.println(users.getIduser().toString() + " " + users.getFirstname().toString() + " " + users.getLastname().toString());
//             }
//             
//        Query qu = ses.createQuery("from Partnegotiation");
//        List<Partnegotiation> pn = (List<Partnegotiation>) qu.list();
//             System.out.println("pt "+pn.size());
//             
//             for (Partnegotiation pa : pn) {
//                 System.out.println(pa.getFinalprice().toString());
//             }
//             
//                 Transaction tc2 = ses.beginTransaction();
//        String login = "dupont.gerard@airbus.fr";
//        String mdp = "codeva1";
//        System.out.println(login + mdp);
//       Query qa = ses.createQuery("from Users u where u.email = " +"\'login\'"+"and u.password = " + "\'mdp\'");
//       + "and password = "+"\"codeva1\"");
//      List<Users> usd = (List<Users>) qa.list();
//       System.out.println("us " + usd.size() );
//        List l = session.createQuery("select e.nomE, count(*) " +
//									  "from Demande d, Employe e " +
//									  "where d.codeEmp = e.codeE " +
//									  "group by e.codeE " +
//									  "having count(*) >= 2").list();
//        
//        String email = "dupont.gerard@airbus.fr";
//        List lst = ses.createQuery("select p.labelrole from Positions p, Users u where p.iduser = u.iduser and u.email = '" + email + "'").list();
//       
//         List<String> us = (List<String>) qa.list();
//         System.out.println("us " + us.size());
//         System.out.println("us " + us.toString());
//       
//        Positions p = (Positions)ses.get(Positions.class,(byte)1);
//        Set<Users> po = p.getUserses();
//        for (Users users : po) {
//            System.out.println("user" + users.getIduser());
//        }
//        Users u = (Users)ses.get(Users.class,"AI_PREP13");
//		System.out.println("Liste des roles de " + u.getFirstname());
//                
//                Set<Positions> p = u.getPositionses();
//               for (Positions positions : p) {
//                   System.out.println("pos "+positions.getLabelrole());
//            Users u = (Users)ses.get(Users.class,"AI_PREP13");
//            System.out.println("Liste des roles de " + u.getFirstname());
//        Query qa = ses.createQuery("select u.firstname from Users u where u.email = '" + email + "'");
//        List<String> us = (List<String>) qa.list();
//        System.out.println("prenom " + us.toString());
//        System.out.println(affParNeg().get(13).getPart().getTechnology().getTechnocode());
//        System.out.println(connexion("dupont.gerard@airbus.fr","codeva1"));
//        System.out.println(infoUserEmail("dupont.gerard@airbus.fr").getIduser());
//        System.out.println(inforPropose(2).getPrice());
//        insertPublicComment("SALES1", (short)2, null, null, null, null, null, null, null);
//        System.out.println(infoNegotiation(2).getNumberneg());
//        DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
//        Date date = new Date();
//        String time= df.format(date);
//        Timestamp ts = Timestamp.valueOf(time);
//        System.out.println(ts);
//        List<Propose> l = publicComments((short)19);
//        for (Propose p : l) {
//            System.out.println(p.getCommentpart());
//             System.out.println(p.getId().getDatepro());
//              System.out.println(p.getUsers().getCompany().getName());
//               System.out.println(p.getUsers().getFirstname());
//        }
        

    }

//                
//		for (Positions tr : l_tr)
//			System.out.println(tr.getLabelrole());
//        tc.commit();
//        
//    HibernateMain.affichage(lst);
//    private static void affichage(List l) {
//        Iterator e = l.iterator();
//        while (e.hasNext()) {
//            Object[] tab_obj = ((Object[]) e.next());
//
//            for (Object obj : tab_obj) {
//                System.out.print(obj + " ");
//            }
//
//            System.out.println("");
//        }
//    }
    
    public static String connexion(String login, String mdp) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//       tc = ses.beginTransaction();
        //OpenSession();
        String v = "";
        //tc.begin();
        Query qa = ses.createQuery("from Users as u where u.email= '" + login + "' and u.password= '" + mdp + "'");
        List<Users> us = (List<Users>) qa.list();

        if (us.size()==0) {
            v = "ko";
        } else {
            v = "ok";
        }
       //tc.commit();
        return v;
    }

    public static List<String> afficherRoles(String email) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tc = ses.beginTransaction();
        //tc = ses.beginTransaction();
        Query qa = ses.createQuery("select u.firstname from Users u where u.email = '" + email + "'");
        List<String> us = (List<String>) qa.list();
        //tc.commit();
        return us;

    }

    public static List<Partnegotiation> affParNeg() {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tc = ses.beginTransaction();
        //tc = ses.beginTransaction();
        Query q = ses.createQuery("from Partnegotiation order by entrydate desc");
        List<Partnegotiation> lstPartNeg = (List<Partnegotiation>) q.list();
        //tc.commit();
        return lstPartNeg;
    }

// ------------------
    public static Partnegotiation infoNegotiation(short idNego) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        tc = ses.beginTransaction();
        Query q1 = ses.createQuery("from Partnegotiation where NUMBERNEG=" + idNego);
        List<Partnegotiation> pn = (List<Partnegotiation>) q1.list();        
        return pn.get(0);
    }

    public static List<Propose> publicComments(short idNego) {
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tc = ses.beginTransaction();
//        HibernateMain.VerifSession();
        Query q2 = ses.createQuery("from Propose where NUMBERNEG=" + idNego + " and TYPECOMPART='public' order by DATEPRO desc");
        List<Propose> p = (List<Propose>) q2.list();
        //tc.commit();
        return p;
    }
    
    public static List<Propose> privateComments(int idNego) {
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tc = ses.beginTransaction();
//        HibernateMain.VerifSession();
        
//        Query q3 = ses.createQuery("from Propose p, Users u,  where p.IDUSER = u.IDUSER and p.NUMBERNEG=" + idNego + " and p.TYPECOMPART='private' and u.NUMBERCOMPANY='"
//                                    +infoUserEmail(email).getCompany().getName()+"' and order by p.DATEPRO desc");
        Query q3 = ses.createQuery("from Propose where NUMBERNEG=" + idNego + " and TYPECOMPART='private' order by DATEPRO desc");
        List<Propose> p2 = (List<Propose>) q3.list();
        //tc.commit();
        return p2;
    }

    public static Users infoUser(String idUser) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tc = ses.beginTransaction();
        Query q4 = ses.createQuery("from Users where IDUSER='" + idUser + "'");
        Users u = (Users) q4.list().get(0);
        //tc.commit();
        return u;
    }
    public static Users infoUserEmail(String email) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tc = ses.beginTransaction();
        Query q5 = ses.createQuery("from Users where EMAIL='" + email + "'");
        Users u = (Users) q5.list().get(0);
        //tc.commit();
        return u;
    }
    public static Propose inforPropose(int numberPart){
        //tc=ses.beginTransaction();
        Query q6=ses.createQuery("from Propose where NUMBERNEG="+numberPart+" and PRICE is not null order by DATEPRO desc");
        Propose p=(Propose)q6.list().get(0);
        //tc.commit();
        return p;
        
    }
    public static Company trouveCompany(int idCom) {
//        HibernateMain.VerifSession();
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tc = ses.beginTransaction();
        Company c = new Company();
        Query q1 = ses.createQuery("from Company where numbercompany=" + idCom);
        c = (Company) q1.list().get(0);
        //tc.commit();
        
        return c;
    }
    
        public static BigDecimal infoPrixNego(short idNego) {
//        HibernateMain.VerifSession();
//        Session sses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tca = sses.beginTransaction();
//        System.out.println(idNego);

        Query q1 = ses.createQuery("from Propose as N inner join ProposeId where NUMBERNEG=" + idNego + " ORDER BY datepro DESC");
        if (!q1.list().isEmpty()) {
            Propose pn = (Propose) q1.list().get(0);
            if (pn.getPrice() == null) {
                BigDecimal price = new BigDecimal(0);
//                tc.commit();
                return price;
            } else {
//                Propose pn = (Propose) q1.list().get(0);
                BigDecimal price = pn.getPrice();
//                tc.commit();
                return price;
            }
        } else {
            BigDecimal price = new BigDecimal(0);
//            tc.commit();
            return price;
        }

    }
    
    

    public static void insertPublicComment(String idUser, short numberNeg, String com, String price, String matPrice, String labPrice, String other, Date startDate, Date endDate) {
//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        tc = ses.beginTransaction();
//        HibernateMain.VerifSession();   
    
        
        
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
//        String time= df.format(date);
//        Timestamp ts = Timestamp.valueOf(time);
        ProposeId idp = new ProposeId(idUser, numberNeg, date);
        Partnegotiation pn = new Partnegotiation();
        pn = infoNegotiation(numberNeg);
        String pricestatus = "";
        
        if (date.compareTo(pn.getFirstdate()) == -1) {
            pricestatus = "definitive";
        } else {
            pricestatus = "temporary";
        }
        Propose pro = new Propose();
        pro.setId(idp);
        pro.setPartnegotiation(pn);
        try{
            pro.setPrice(new BigDecimal(price));
        }catch(Exception e){
            pro.setPrice(null);
        }
        try{
           pro.setMatprice(new BigDecimal(matPrice));
        }catch(Exception e){
            pro.setMatprice(null);
        }
        try{
           pro.setLabprice(new BigDecimal(labPrice));
        }catch(Exception e){
            pro.setLabprice(null);
        }
        try{
            pro.setOtherprice(new BigDecimal(other));
        }catch(Exception e){
            pro.setOtherprice(null);
        }
        pro.setEndval(endDate);
        pro.setStartval(startDate);
        pro.setCommentpart(com);
        pro.setUsers(infoUser(idUser));
        pro.setPricestatus(pricestatus);
        pro.setTypecompart("public");
        ses.save(pro);
        tc.commit();
        OpenSession();
        //return pro;
    }
    
    public static void insertPrivateComment(String idUser, short numberNeg, String com){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //date=df.format(date);
        ProposeId idp = new ProposeId(idUser, numberNeg, date);
        Partnegotiation pn = new Partnegotiation();
        pn = infoNegotiation(numberNeg);
        String pricestatus = "";
        if (date.compareTo(pn.getFirstdate()) == -1) {
            pricestatus = "definitive";
        } else {
            pricestatus = "temporary";
        }
        Propose pro = new Propose();
        pro.setId(idp);
        pro.setPartnegotiation(pn);
        pro.setCommentpart(com);
        pro.setUsers(infoUser(idUser));
        pro.setTypecompart("private");
        ses.save(pro);
        tc.commit();
        OpenSession();
    }
    
    public static void FermerSession(){
        ses.close();
    }
    public static void OpenSession(){
        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
        tc=ses.beginTransaction();
    }
    
    
     public static List<Partnegotiation> affParNegTech(String tech) {
//        tc = ses.beginTransaction();
        Query q = ses.createQuery("select pn from Partnegotiation pn, Part pa, Technology t where pn.part=pa.numberpart and pa.technology=t.technocode and t.technocode='"+tech+"'");
        List<Partnegotiation> lstPartN = (List<Partnegotiation>) q.list();
//        tc.commit();
        return lstPartN;
    }
    
       public static List<Partnegotiation> affParNegStat(String st) {
//        tc = ses.beginTransaction();
        Query q = ses.createQuery("from Partnegotiation where negostatus='"+st+"'");
        List<Partnegotiation> lstPartN = (List<Partnegotiation>) q.list();
//        tc.commit();
        return lstPartN;
    }
       
        public static List<String> recupMail() {

//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery("select u.email from Users u");
        List<String> lstmail = (List<String>) q.list();
//        tc.commit();

        return lstmail;

    }
    
     public static List<String> recupId() {

//        ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery("select u.iduser from Users u");
        List<String> lstid = (List<String>) q.list();
//        tc.commit();

        return lstid;

    }
     
      public static void modifyUser(String id, String lastname, String firstname, String email, String password) {
        Users u = infoUser(id);
//            ses = NewHibernateUtil.getSessionFactory().getCurrentSession();
//            Transaction tc = ses.beginTransaction();
        u.setFirstname(firstname);
        u.setEmail(email);
        u.setLastname(lastname);
        u.setPassword(password);
        ses.update(u);
        ses.getTransaction().commit();
        OpenSession();
    }
      
       public static void updatePriceNego(short idNego, float price) {

        Date date = new Date();
        String pricestatus;
        BigDecimal p = new BigDecimal(price);
        Partnegotiation pn = infoNegotiation( idNego);
        if (date.compareTo(pn.getFirstdate()) == -1) {
            pricestatus = "definitive";
            pn.setNegostatus("validated");
            pn.setFinalprice(p);
            pn.setDatevalidate(date);
            ses.update(pn);
            tc.commit();
            OpenSession();
        } else {
            pricestatus = "temporary";
            pn.setNegostatus("provisional");
            pn.setTemporaryprice(p);
            pn.setDatevalidate(date);
            ses.update(pn);
            tc.commit();
            OpenSession();
        }
    }
    
    public static float numberNegoVal() {
        Query qpnv = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'validated'");
        List<Partnegotiation> pnv = (List<Partnegotiation>) qpnv.list();
        int nbVal0 = pnv.size() ;
        System.out.println(nbVal0+" "+affParNeg().size());
        float nbVal =((float)nbVal0/(float)affParNeg().size())*100;
        return nbVal;
    }
    
    public static float numberNegoCan() {
        Query qpnc = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'cancelled'");
        List<Partnegotiation> pnc = (List<Partnegotiation>) qpnc.list();
        int nbCan0 = pnc.size() ;
        float nbCan = ((float)nbCan0/(float)affParNeg().size())*100;
        return nbCan;
    }
    
    public static float numberNegoRef() {
        Query qpnr = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'refused'");
        List<Partnegotiation> pnr = (List<Partnegotiation>) qpnr.list();
        int nbRef0 = pnr.size() ;
        float nbRef = ((float)nbRef0/(float)affParNeg().size())*100;
        return nbRef;
    }
    
    public static float numberNegoInProg() {
        Query qpni = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'in progress'");
        List<Partnegotiation> pni = (List<Partnegotiation>) qpni.list();
        int nbInProg0 = pni.size() ;
        float nbInProg = ((float)nbInProg0/(float)affParNeg().size())*100;
        return nbInProg;
    }
    
    public static float numberNegoNew() {
        Query qpnn = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'new'");
        List<Partnegotiation> pnn = (List<Partnegotiation>) qpnn.list();
        int nbNew0 = pnn.size() ;
        float nbNew = ((float)nbNew0/(float)affParNeg().size())*100;
        return nbNew;
    }
    
    public static float numberNegoProv() {
        Query qpnp = ses.createQuery("select p.numberneg from Partnegotiation as p where negostatus = 'provisional'");
        List<Partnegotiation> pnp = (List<Partnegotiation>) qpnp.list();
        int nbProv0 = pnp.size() ;
        float nbProv = ((float)nbProv0/(float)affParNeg().size())*100;
        return nbProv;
    }
    
        public static String getnotification(String idUser, short numberNeg) {
     
        NotifyId nid = new NotifyId(idUser, (short) numberNeg);
        String a = "";
        try {
            Query q = ses.createQuery("from Notify where IDUSER='" + nid.getIduser() + "' and numberneg='" + nid.getNumberneg() + "'");
            List<Notify> listn = (List<Notify>) q.list();
            a = "";
            if (listn.get(0).getComstatus().equals("ok")) {
                a = "New message";
            } else {
                a = " ";
            }
           

        } catch (Exception e) {
            a = " ";
        }

        return a;

    }

    public static void transfromstatus(String idUser, short numberNeg) {

        NotifyId nid = new NotifyId(idUser, (short) numberNeg);
        String a = "ege";
        Query q = ses.createQuery("from Notify where  numberneg=" + nid.getNumberneg() + "");
        List<Notify> listn = (List<Notify>) q.list();
        for (Notify notify : listn) {
            notify.setComstatus("no");
            ses.update(notify);
        }
        for (Notify notify : listn) {

            if (notify.getId().getIduser().equals(nid.getIduser())) {

                if (notify.getId().getNumberneg() == nid.getNumberneg()) {

                    notify.setComstatus("ok");
                    ses.update(notify);
                }
            }
        }
        ses.getTransaction().commit();

    }

    public static Date Feasabilitydate(short numberneg, String technocode) {

        Query q = ses.createQuery("from Technology where technocode='" + technocode + "'");

        List<Technology> listtech = (List<Technology>) q.list();
        short a = listtech.get(0).getCyclerealisation();
        Integer intObj = listtech.get(0).getIndustrialisationlot1();
    //use byteValue method of Integer class to convert it into byte type.

        Integer intObj2 = listtech.get(0).getIndustrialisationlot2();
    //use byteValue method of Integer class to convert it into byte type.

        Integer intObj3 = listtech.get(0).getIndustrialisationlot3();

        //use byteValue method of Integer class to convert it into byte type.
        short d = intObj.byteValue();

        short e = (short) (a + intObj + intObj2 + intObj3);

        Query qdate = ses.createQuery("from Partnegotiation as p where numberneg=" + numberneg);

        List<Partnegotiation> listentdate = (List<Partnegotiation>) qdate.list();

        Date dte = listentdate.get(0).getEntrydate();

        Calendar x = Calendar.getInstance();

        x.setTime(dte);
        x.add(Calendar.DAY_OF_MONTH, e);

        return x.getTime();
    }

    public static String alertecycles(short numberneg, Date date) {

        Query pb = ses.createQuery("from Partnegotiation where numberneg=" + numberneg);
        List<Partnegotiation> listpb = (List<Partnegotiation>) pb.list();
        listpb.get(0).getFirstdate();
        System.out.println(listpb.get(0).getFirstdate());
        Date datepremierbesoin = listpb.get(0).getFirstdate();
        String messalert = "";
        Calendar x = Calendar.getInstance();
        x.setTime(date);

        Calendar dpb = Calendar.getInstance();
        dpb.setTime(datepremierbesoin);

        int res = dpb.compareTo(x);
        if (res == -1) {
            messalert = "out of time";
        } else {
            messalert = " ";
        }

        return messalert;

    }

    public static List<String> recupTech() {

        Query q = ses.createQuery("select t.technocode from Technology as t");
        List<String> lstTech = (List<String>) q.list();

        return lstTech;
    }
       
}
