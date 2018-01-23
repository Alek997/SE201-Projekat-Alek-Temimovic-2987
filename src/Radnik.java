
import java.sql.Date;


public class Radnik {
    
   private int id; 
   private String ime;
   private String prezime;
   private String jmbg;
   private String adresa;
   private Date datumZaposlenja;
   private String pozicija;
   private String password;

    public Radnik() {
    }

    public Radnik(int id, String ime, String prezime, String jmbg, String adresa, Date datumZaposlenja, String pozicija, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.datumZaposlenja = datumZaposlenja;
        this.pozicija = pozicija;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Radnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", datumZaposlenja=" + datumZaposlenja + ", pozicija=" + pozicija + ", password=" + password + '}';
    }

   
   
   
}
