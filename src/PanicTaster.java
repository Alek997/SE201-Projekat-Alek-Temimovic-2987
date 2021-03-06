
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;


public class PanicTaster extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("PanicTaster");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);

        final Label nazivT = new Label("Pritisniti u hitnim situacijama");
        

        Button btn = new Button("Pomoc");

        GridPane grid = new GridPane();
        
        grid.add(btn, 1, 4);
        grid.setHgap(30);
        grid.setVgap(15);

        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.getChildren().addAll(nazivT, grid);


        btn.setOnAction((ActionEvent event) -> {
           try {
                            runAnotherApp(RadnikEkran.class);
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Potrebna pomoc");
                            alert.setHeaderText(null);
                            alert.setContentText("Pritisnut je panik taster");
                            alert.showAndWait();
                            Stage stage = (Stage) btn.getScene().getWindow();
                            //stage.close();
                            
                        } catch (Exception ex) {
                            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                        }
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

