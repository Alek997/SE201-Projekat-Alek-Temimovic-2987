
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;


public class UnesiRadnika extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Unesite radnika");
        primaryStage.setWidth(350);
        primaryStage.setHeight(450);

        final Label nazivT = new Label("Unesite informacije o radniku");
        nazivT.setFont(new Font("Arial", 20));
        TextField imeTX = new TextField();
        TextField prezimeTX = new TextField();
        TextField jmbgTX = new TextField();
        TextField adresaTX = new TextField();
        DatePicker datumZaposlenja = new DatePicker();
        TextField pozicijaTX = new TextField();
        TextField passwordTX = new TextField();

        Button btn = new Button("Sacuvaj");

        GridPane grid = new GridPane();
        grid.add(new Label("Ime"), 0, 0);
        grid.add(imeTX, 1, 0);
        grid.add(new Label("Prezime"), 0, 1);
        grid.add(prezimeTX, 1, 1);
        grid.add(new Label("JMBG"), 0, 2);
        grid.add(jmbgTX, 1, 2);
        grid.add(new Label("Adresa"), 0, 3);
        grid.add(adresaTX, 1, 3);
        grid.add(new Label("Dat.zap."), 0, 4);
        grid.add(datumZaposlenja, 1, 4);
        grid.add(new Label("Pozicija"), 0, 5);
        grid.add(pozicijaTX, 1, 5);
        grid.add(new Label("Password"), 0, 6);
        grid.add(passwordTX, 1, 6);
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
            LocalDate dp = datumZaposlenja.getValue();
            java.util.Date utilDatum = java.util.Date.from(dp.atStartOfDay(ZoneId.systemDefault()).toInstant());
             
            Baza.addRadnik(imeTX.getText(),prezimeTX.getText(),jmbgTX.getText(),adresaTX.getText(), new java.sql.Date(utilDatum.getTime()), pozicijaTX.getText(), passwordTX.getText());
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

