


import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RadnikEkran extends Application {

    private final TableView<Korisnik> table = new TableView<>();
    private ObservableList<Korisnik> korisniciOL = FXCollections.observableArrayList();
    

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Korisnici doma za stara lica");
        primaryStage.setWidth(870);
        primaryStage.setHeight(530);

        final Label nazivT = new Label("Korisnici");
        nazivT.setFont(new Font("Arial", 20));

        table.setEditable(true);

         TableColumn<Korisnik, Integer> idTC = new TableColumn("ID");
        idTC.setMinWidth(50);
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Korisnik, String> imeTC = new TableColumn("Ime");
        imeTC.setMinWidth(50);
        imeTC.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<Korisnik, String> prezimeTC = new TableColumn("Prezime");
        prezimeTC.setMinWidth(50);
        prezimeTC.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<Korisnik, String> jmbgTC = new TableColumn("Jmbg");
        jmbgTC.setMinWidth(50);
        jmbgTC.setCellValueFactory(new PropertyValueFactory<>("jmbg"));

        TableColumn<Korisnik, Date> datumPrijemaTC = new TableColumn("DatumPrijema");
        datumPrijemaTC.setMinWidth(150);
        datumPrijemaTC.setCellValueFactory(new PropertyValueFactory<>("datumPrijema"));
        
        TableColumn<Korisnik, String> kontaktTC = new TableColumn("KontaktRodbine");
        kontaktTC.setMinWidth(50);
        kontaktTC.setCellValueFactory(new PropertyValueFactory<>("kontaktRodbine"));

        
        
        table.getColumns().addAll(idTC ,imeTC, prezimeTC, jmbgTC, datumPrijemaTC, kontaktTC );
        table.setPrefWidth(700);
        Baza.connect();
        //ArrayList<Korisnik> korisnici = Baza.getAllKorisnik();
        korisniciOL = FXCollections.observableArrayList(Baza.getAllKorisnik());
        Baza.disconnect();
        table.setItems(korisniciOL);

     
        
        final VBox vboxLeft = new VBox();
        vboxLeft.setSpacing(5);
        vboxLeft.setPadding(new Insets(10, 0, 0, 10));
        vboxLeft.getChildren().addAll(nazivT, table);

        Button btnUnesiNovog = new Button("Novi korisnik");
        Button btnObrisi = new Button("Obrisi");
        Button btnOsvezi = new Button("Osvezi");
        
        btnUnesiNovog.setOnAction((ActionEvent event) -> {
            
                         try {
                            runAnotherApp(UnesiKorisnika.class);
                            Stage stage = (Stage) btnUnesiNovog.getScene().getWindow();
                            //stage.close();
                        } catch (Exception ex) {
                            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                        }
        });
        btnObrisi.setOnAction((ActionEvent event) -> {
            
                         try {
                            runAnotherApp(ObrisiKorisnika.class);
                            Stage stage = (Stage) btnObrisi.getScene().getWindow();
                            //stage.close();
                        } catch (Exception ex) {
                            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                        }
        });
        btnOsvezi.setOnAction((ActionEvent event) -> {
             Baza.connect();
        //ArrayList<Korisnik> korisnici = Baza.getAllKorisnik();
        korisniciOL = FXCollections.observableArrayList(Baza.getAllKorisnik());
        Baza.disconnect();
        table.setItems(korisniciOL);
        });
        
        btnUnesiNovog.setPrefWidth(100);
        btnObrisi.setPrefWidth(100);
        btnOsvezi.setPrefWidth(100);
        
        
        
        GridPane gpane = new GridPane();
        gpane.add(btnUnesiNovog, 0, 5);
        gpane.add(btnOsvezi, 0, 6);
        gpane.add(btnObrisi, 0, 7);
        gpane.setVgap(40);
        gpane.setHgap(15);
        gpane.setPadding(new Insets(50, 10, 10, 10));

        final VBox vboxRight = new VBox();
        vboxRight.getChildren().addAll(gpane);

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(vboxLeft, vboxRight);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public void runAnotherApp(Class<? extends Application> anotherAppClass) throws Exception {
        Application app2 = anotherAppClass.newInstance();
        Stage anotherStage = new Stage();
        app2.start(anotherStage);
    }
}
