
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


public class ObrisiKorisnika extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Obrisi korisnika");
        primaryStage.setWidth(350);
        primaryStage.setHeight(450);

        final Label nazivT = new Label("Unesite JMBG korisnika");
        nazivT.setFont(new Font("Arial", 20));

        TextField jmbgTX = new TextField();
   


        Button btn = new Button("Obrisi");

        GridPane grid = new GridPane();
        grid.add(new Label("JMBG"), 0, 0);
        grid.add(jmbgTX, 1, 0);
       
        
        grid.add(btn, 1, 2);
        grid.setHgap(30);
        grid.setVgap(15);

        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.getChildren().addAll(nazivT, grid);

        jmbgTX.setPrefWidth(130);

        btn.setOnAction((ActionEvent event) -> {
            Baza.connect();
            Baza.deleteKorisnik(jmbgTX.getText().trim());
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

