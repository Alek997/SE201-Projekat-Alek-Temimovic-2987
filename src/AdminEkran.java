
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminEkran extends Application {

    private final TableView<Radnik> table = new TableView<>();
    private ObservableList<Radnik> radniciOL = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Radnici");
        primaryStage.setWidth(870);
        primaryStage.setHeight(530);

        final Label nazivT = new Label("Radnici");
        nazivT.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Radnik, Integer> idTC = new TableColumn("ID");
        idTC.setMinWidth(50);
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Radnik, String> imeTC = new TableColumn("Ime");
        imeTC.setMinWidth(50);
        imeTC.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<Radnik, String> prezimeTC = new TableColumn("Prezime");
        prezimeTC.setMinWidth(50);
        prezimeTC.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<Radnik, String> jmbgTC = new TableColumn("Jmbg");
        jmbgTC.setMinWidth(50);
        jmbgTC.setCellValueFactory(new PropertyValueFactory<>("jmbg"));

        TableColumn<Radnik, String> adresaTC = new TableColumn("Adresa");
        adresaTC.setMinWidth(50);
        adresaTC.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        TableColumn<Radnik, Date> datumZaposlenjaTC = new TableColumn("DatumZaposlenja");
        datumZaposlenjaTC.setMinWidth(50);
        datumZaposlenjaTC.setCellValueFactory(new PropertyValueFactory<>("datumZaposlenja"));

        TableColumn<Radnik, String> pozicijaTC = new TableColumn("Pozicija");
        pozicijaTC.setMinWidth(50);
        pozicijaTC.setCellValueFactory(new PropertyValueFactory<>("pozicija"));

        TableColumn<Radnik, String> passwordTC = new TableColumn("Password");
        passwordTC.setMinWidth(50);
        passwordTC.setCellValueFactory(new PropertyValueFactory<>("password"));

        table.getColumns().addAll(imeTC, prezimeTC, jmbgTC, adresaTC, datumZaposlenjaTC, pozicijaTC, passwordTC);
table.setPrefWidth(700);
        Baza.connect();
        radniciOL = FXCollections.observableArrayList(Baza.getAllRadnik());
        Baza.disconnect();
        table.setItems(radniciOL);

        final VBox vboxLeft = new VBox();
        vboxLeft.setSpacing(5);
        vboxLeft.setPadding(new Insets(10, 0, 0, 10));
        vboxLeft.getChildren().addAll(nazivT, table);

        Button btnUnesiNovog = new Button("Novi radnik");
        btnUnesiNovog.setPrefWidth(100);
    
        Button btnObrisi = new Button("Obrisi");
        
        Button btnOsvezi = new Button("Osvezi");
        btnObrisi.setPrefWidth(100);
        btnOsvezi.setPrefWidth(100);
        btnUnesiNovog.setOnAction((ActionEvent event) -> {
            
                         try {
                            runAnotherApp(UnesiRadnika.class);
                            Stage stage = (Stage) btnUnesiNovog.getScene().getWindow();
                            //stage.close();
                        } catch (Exception ex) {
                            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                        }
        });
        btnObrisi.setOnAction((ActionEvent event) -> {
            
                         try {
                            
                            runAnotherApp(ObrisiRadnika.class);
                            Stage stage = (Stage) btnObrisi.getScene().getWindow();
                            //stage.close();
                        } catch (Exception ex) {
                            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                        }
        });
        btnOsvezi.setOnAction((ActionEvent event) -> {
             Baza.connect();
        //ArrayList<Korisnik> korisnici = Baza.getAllKorisnik();
        radniciOL = FXCollections.observableArrayList(Baza.getAllRadnik());
        Baza.disconnect();
        table.setItems(radniciOL);
        });

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
