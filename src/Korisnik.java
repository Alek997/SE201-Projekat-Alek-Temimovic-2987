
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Korisnik {
    
    private int id;
    private String ime;
    private String prezime;
    private String jmbg;
    private Date datumPrijema;
    private String kontaktRodbine;
    private List<ZdravstvenoStanje> zdravstveniProblemi;

    public Korisnik(int id, String ime, String prezime, String jmbg, Date datumPrijema,String kontaktRodbine, List<ZdravstvenoStanje> zdravstveniProblemi) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumPrijema = datumPrijema;
        this.kontaktRodbine = kontaktRodbine;
        this.zdravstveniProblemi = new ArrayList<ZdravstvenoStanje>();
    }

    public int getId() {
        return id;
    }

    public String getKontaktRodbine() {
        return kontaktRodbine;
    }

    public void setKontaktRodbine(String kontaktRodbine) {
        this.kontaktRodbine = kontaktRodbine;
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

    public Date getDatumPrijema() {
        return datumPrijema;
    }

    public void setDatumPrijema(Date datumPrijema) {
        this.datumPrijema = datumPrijema;
    }

    public List<ZdravstvenoStanje> getZdravstveniProblemi() {
        return zdravstveniProblemi;
    }

    public void setZdravstveniProblemi(List<ZdravstvenoStanje> zdravstveniProblemi) {
        this.zdravstveniProblemi = new ArrayList<ZdravstvenoStanje>();
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", datumPrijema=" + datumPrijema + ", kontaktRodbine=" + kontaktRodbine + ", zdravstveniProblemi=" + zdravstveniProblemi + '}';
    }

    
    

    
    
}
