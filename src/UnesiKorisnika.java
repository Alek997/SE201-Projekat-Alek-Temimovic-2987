
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;


public class UnesiKorisnika extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Unesite korisnika");
        primaryStage.setWidth(350);
        primaryStage.setHeight(450);

        final Label nazivT = new Label("Unesite informacije o korisniku");
        nazivT.setFont(new Font("Arial", 20));
        TextField imeTX = new TextField();
        TextField prezimeTX = new TextField();
        TextField jmbgTX = new TextField();
        DatePicker datumPrijema = new DatePicker();
        TextField kontaktTX = new TextField();


        Button btn = new Button("Sacuvaj");

        GridPane grid = new GridPane();
        grid.add(new Label("Ime"), 0, 0);
        grid.add(imeTX, 1, 0);
        grid.add(new Label("Prezime"), 0, 1);
        grid.add(prezimeTX, 1, 1);
        grid.add(new Label("JMBG"), 0, 2);
        grid.add(jmbgTX, 1, 2);
        grid.add(new Label("Dat.prijem."), 0, 4);
        grid.add(datumPrijema, 1, 4);
        grid.add(new Label("Kontakt"), 0, 3);
        grid.add(kontaktTX, 1, 3);
        
        
        grid.add(btn, 1, 7);
        grid.setHgap(30);
        grid.setVgap(15);

        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.getChildren().addAll(nazivT, grid);

        imeTX.setPrefWidth(20);

        btn.setOnAction((ActionEvent event) -> {
            
            Baza.connect();
            LocalDate dp = datumPrijema.getValue();
            java.util.Date utilDatum = java.util.Date.from(dp.atStartOfDay(ZoneId.systemDefault()).toInstant());
             
            Baza.addKorisnik(imeTX.getText(), prezimeTX.getText(), jmbgTX.getText(), kontaktTX.getText() , new java.sql.Date(utilDatum.getTime()));
            Baza.disconnect();
        });

        ((Group) scene.getRoot()).getChildren().addAll(vb);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

    public void runAnotherApp(Class<? extends Application> anotherAppClass) throws Exception {
        Application app2 = anotherAppClass.newInstance();
        Stage anotherStage = new Stage();
        app2.start(anotherStage);
    }
}

