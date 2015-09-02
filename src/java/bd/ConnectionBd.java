package bd;

import Hibernate.HibernateMain;
import Hibernate.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21004555
 */
public class ConnectionBd {

    private static Connection cx;

    //Données de connexion
    private static final String url = "jdbc:oracle:thin:@etu-ora2.ut-capitole.fr:1550:igsi";
    private static final String login = "Codeva_Stelia_Airbus";
    private static final String password = "codeva";

    private static void connexion() throws ExceptionBd {
        //Chargement du pilote pour la BD
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            throw new ExceptionBd("Pilote pour se connecter à Oracle introuvable - " + ex.getMessage());
        }

        //Ouverture de la connexion
        try {
            ConnectionBd.cx = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de connexion à la base de données - " + ex.getMessage());
        }
    }

    public static ArrayList<String> retourneRole(String email) throws ExceptionBd {
        
        ArrayList l = new ArrayList();
        if (ConnectionBd.cx == null)
			ConnectionBd.connexion();
        try {
            String sql = "select p.labelrole from positions p, users u, title t "
                    + "where t.iduser=u.iduser and t.idrole=p.idrole and u.email = '" + email + "'";
            PreparedStatement st;
            ResultSet rs = null;
            try {
                st = cx.prepareStatement(sql);
                rs = st.executeQuery();

            } catch (Exception e) {
            }
            while (rs.next()) {
                l.add(rs.getString(1));

            }
        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de lecture de la liste des messages - " + ex.getMessage());
        }

        return l;
    }
    public static ArrayList<Users> retourneUser(String role) throws ExceptionBd {
        ArrayList<Users> l = new ArrayList();
        if (ConnectionBd.cx == null) {
            ConnectionBd.connexion();
        }
        try {
            String sql = "select u.iduser,u.firstname,u.lastname,u.password,u.email,u.telephone from positions p, users u, title t "
                    + "where t.iduser=u.iduser and t.idrole=p.idrole and p.labelrole = '" + role + "'";
            PreparedStatement st;
            ResultSet rs = null;
            try {
                st = cx.prepareStatement(sql);
                rs = st.executeQuery();

            } catch (Exception e) {
            }
            while (rs.next()) {
                l.add(new Users(rs.getString(1), null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), null, null, null, null, null, null));

            }
        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de lecture de retourneUser - " + ex.getMessage());
        }

        return l;
    }
    
     public static void ModifyRole(String id, String rol1, String rol2, String rol3, String rol4) throws ExceptionBd {
        System.out.println("bbbb "+ rol1);
        ArrayList<String> l = new ArrayList();
        if (ConnectionBd.cx == null) {
            System.out.println("bbbb1111 "+ rol1);
            ConnectionBd.connexion();
        }
        try {
            Users u = HibernateMain.infoUser(id);
            l = retourneRole(u.getEmail());
            /*----- Espace de requête  -----*/
            PreparedStatement st;
            System.out.println("bbbb1 "+ rol1);
            if(l.contains("Negotiator")==true)
            {
                System.out.println("contain");
            }
             if(l.contains("Negotiator"))
            {
                System.out.println("contain1");
            }
            
            System.out.println("");

            /*----- Requête SQL -----*/
            if ((rol1 == null) || ("on".equals(rol1)) && (l.contains("Negotiator"))) {
                String sql = "DELETE FROM Title WHERE idrole =2 AND iduser='" + id + "'";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb2 "+ rol1);

            } else if (("y".equals(rol1)) && (!l.contains("Negotiator"))) {
                String sql = "INSERT INTO Title(IDUSER,IDROLE) VALUES ('" + id + "',2)";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb3 "+ rol1);
            }
            if ((rol2 == null) || ("on".equals(rol2)) && (l.contains("Preparator"))) {
                String sql = "DELETE FROM Title WHERE idrole =3 AND iduser='" + id + "'";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb4 "+ rol1);

            } else if (("y".equals(rol2)) && (!l.contains("Preparator"))) {
                String sql = "INSERT INTO Title(IDUSER,IDROLE) VALUES ('" + id + "',3)";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb5 "+ rol1);
            }
            if ((rol3 == null) || ("on".equals(rol3)) && (l.contains("Consultant"))) {
                String sql = "DELETE FROM Title WHERE idrole =4 AND iduser='" + id + "'";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb6 "+ rol1);

            } else if (("y".equals(rol3)) && (!l.contains("Consultant"))) {
                String sql = "INSERT INTO Title(IDUSER,IDROLE) VALUES ('" + id + "',4)";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb7 "+ rol1);
            }
            if ((rol4 == null) || ("on".equals(rol4)) && (l.contains("Administrator"))) {
                String sql = "DELETE FROM Title WHERE idrole =1 AND iduser='" + id + "'";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb8 "+ rol1);

            } else if (("y".equals(rol4)) && (!l.contains("Administrator"))) {
                String sql = "INSERT INTO Title(IDUSER,IDROLE) VALUES ('" + id + "',1)";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("bbbb9 "+ rol1);
            }
            String sql = "commit";
            st = cx.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de lecture de modifyRole - " + ex.getMessage());
        }

    }

    public static void insertUserAirbus(String id, String lastname, String firstname, String email, String password)throws ExceptionBd {
        ArrayList<String> l = new ArrayList();
        if (ConnectionBd.cx == null) {
            ConnectionBd.connexion();
        }
        try {
            /*----- Espace de requête  -----*/
            PreparedStatement st;

            /*----- Requête SQL -----*/
                String sql = "INSERT INTO USERS(IDUSER,numbercompany,firstname,lastname,password,email) VALUES ('" + id + "',1,'" + firstname + "','" + lastname + "','" + email + "','" + password + "')";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
           

        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de lecture de insertAirbusUser - " + ex.getMessage());
        }
    }
    public static void insertUserStelia(String id,String lastname, String firstname, String email, String password)throws ExceptionBd {
        ArrayList<String> l = new ArrayList();
        if (ConnectionBd.cx == null) {
            ConnectionBd.connexion();
        }
        try {
            /*----- Espace de requête  -----*/
            PreparedStatement st;

            /*----- Requête SQL -----*/
                String sql = "INSERT INTO USERS(IDUSER,numbercompany,firstname,lastname,password,email) VALUES ('" + id + "',2,'" + firstname + "','" + lastname + "','" + email + "','" + password + "')";
                st = cx.prepareStatement(sql);
                st.executeUpdate();
           

        } catch (SQLException ex) {
            throw new ExceptionBd("Problème de lecture de insertSteliaUser - " + ex.getMessage());
        }
    }
//    ----Test----

    public static void main(String[] s) {
        try {
            ConnectionBd con = new ConnectionBd();
            con.connexion();
            ArrayList<String> l = retourneRole("bale.christian@airbus.fr");
            for (String role : l) {
                System.out.println(role);
            }

        } catch (ExceptionBd e) {
            System.out.println(e.getMessage());
        }

    }
}
