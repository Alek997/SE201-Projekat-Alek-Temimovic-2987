
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class Baza {
    
    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost/se201-projekat";
    private static String user = "root";
    private static String pass = "";
    private static String query = "";

    public static void connect() {
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public static ArrayList<Korisnik> getAllKorisnik() {
        ArrayList<Korisnik> korisnici = new ArrayList<>();

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            query = "SELECT * FROM `korisnik`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID_KORISNIK");
                String ime = rs.getString("IME_KORISNIK");
                String prezime = rs.getString("PREZIME_KORISNIK");
                String jmbg = rs.getString("JMBG_KORISNIK");
                Date datumPrijema = rs.getDate("DATUMPRIJEMA_KORISNIK");
                String kontakt = rs.getString("kontakRodbine");
                ArrayList<ZdravstvenoStanje> zdravstveniProblemi = null;
                
                Korisnik k = new Korisnik(id, ime, prezime, jmbg, datumPrijema,kontakt, zdravstveniProblemi);
                korisnici.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;

    }
   /*  public static ArrayList<Korisnik> getAllKorisnik2() {
        ArrayList<Korisnik> korisnici = new ArrayList<>();

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            query = "SELECT * FROM `korisnik` JOIN `zdravstvenostanje` ON `korisnik`.`ID_KORISNIK` = `zdravstvenostanje`.`ID_KORISNIK`";//treba uraditi JOIN ya arrayListu
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID_KORISNIK");
                String ime = rs.getString("IME_KORISNIK");
                String prezime = rs.getString("PREZIME_KORISNIK");
                String jmbg = rs.getString("JMBG_KORISNIK");
                Date datumPrijema = rs.getDate("DATUMPRIJEMA_KORISNIK");
                ZdravstvenoStanje zs = new ZdravstvenoStanje(id,rs.getString("OPISSTANJA"),rs.getDate("DATUMPREGLEDA"),rs.getString("OPISTERAPIJE"));
                ArrayList<ZdravstvenoStanje> zdravstveniProblemi = new ArrayList<>();
                zdravstveniProblemi.add(zs);
                Korisnik k = new Korisnik(id, ime, prezime, jmbg, datumPrijema, zdravstveniProblemi);
                korisnici.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;

    }*/
    public static void deleteKorisnik(String jmbg) {

        try {
            query = "DELETE FROM `korisnik` WHERE `JMBG_KORISNIK`=" + jmbg;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void addKorisnik (String ime,String prezime, String jmbg,String kontakt,  Date datumPrijema) {

        try {
            query = "INSERT INTO `korisnik` (`ID_KORISNIK`, `IME_KORISNIK`, `PREZIME_KORISNIK`, `JMBG_KORISNIK`, `DATUMPRIJEMA_KORISNIK`, `kontakRodbine` ) "
                    + "VALUES (NULL, ?, ?, ?, ? ,?);";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, jmbg);
            ps.setDate(4, datumPrijema);
            ps.setString(5, kontakt);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Radnik> getAllRadnik() {
        ArrayList<Radnik> radnici = new ArrayList<>();

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            query = "SELECT * FROM `radnik`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID_RADNIK");
                String ime = rs.getString("IME_RADNIK");
                String prezime = rs.getString("PREZIME_RADNIK");
                String jmbg = rs.getString("JMBG_RADNIK");
                String adresa = rs.getString("ADRESA_RADNIK");
                Date datumZaposlenja = rs.getDate("DATUMZAPOSLENJA");
                String pozicija = rs.getString("POZICIJA");
                String password = rs.getString("PASSWORD");
                
                Radnik r = new Radnik(id, ime, prezime, jmbg, adresa, datumZaposlenja, pozicija, password);
                radnici.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return radnici;
    }
      public static ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> admini = new ArrayList<>();

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            query = "SELECT * FROM `administrator`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID_ADMIN");
                String jmbg = rs.getString("JMBG_ADMIN");
                String password = rs.getString("PASSWORD_ADMIN");
              
                
                Admin a = new Admin(id, jmbg, password);
                admini.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admini;
    }
    public static void deleteRadnik(String jmbg) {

        try {
            query = "DELETE FROM `radnik` WHERE `radnik`.`JMBG_RADNIK` = ? ";
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, jmbg);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void addRadnik (String ime,String prezime, String jmbg, String adresa, Date datumZaposlenja, String pozicija, String password) {

        try {
            query = "INSERT INTO `radnik` (`ID_RADNIK`, `IME_RADNIK`, `PREZIME_RADNIK`, `JMBG_RADNIK`, `ADRESA_RADNIK`,`DATUMZAPOSLENJA`, `POZICIJA`, `PASSWORD` ) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ? );";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, jmbg);
            ps.setString(4, adresa);
            ps.setDate(5, datumZaposlenja);
            ps.setString(6, pozicija);
            ps.setString(7, password);
            
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    }
