
import java.sql.Date;


public class ZdravstvenoStanje {
    
    private int id;
    private String opisStanja;
    private Date datumPregleda;
    private String opisTerapije;

    public ZdravstvenoStanje() {
    }

    public ZdravstvenoStanje(int id, String opisStanja, Date datumPregleda, String opisTerapije) {
        this.id = id;
        this.opisStanja = opisStanja;
        this.datumPregleda = datumPregleda;
        this.opisTerapije = opisTerapije;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpisStanja() {
        return opisStanja;
    }

    public void setOpisStanja(String opisStanja) {
        this.opisStanja = opisStanja;
    }

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public String getOpisTerapije() {
        return opisTerapije;
    }

    public void setOpisTerapije(String opisTerapije) {
        this.opisTerapije = opisTerapije;
    }

    @Override
    public String toString() {
        return "ZdravstvenoStanje{" + "id=" + id + ", opisStanja=" + opisStanja + ", datumPregleda=" + datumPregleda + ", opisTerapije=" + opisTerapije + '}';
    }

   

   
}
