
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PocetniEkranView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Log In");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Dom za stara lica");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("JMBG:");
        grid.add(userName, 0, 1);

        TextField jmbgTextField = new TextField();
        grid.add(jmbgTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button logIn = new Button("Log in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(logIn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        logIn.setOnAction((ActionEvent event) -> {

            Baza.connect();
            ArrayList<Admin> admini = Baza.getAllAdmin();
            ArrayList<Radnik> radnici = Baza.getAllRadnik();
            Baza.disconnect();

            for (int i = 0; i < admini.size(); i++) {
                if (admini.get(i).getJmbg().equals(jmbgTextField.getText()) && admini.get(i).getPassword().equals(pwBox.getText())) {
                    //run admin deo
                    System.out.println("Admin usao");
                    try {
                        runAnotherApp(AdminEkran.class);
                        Stage stage = (Stage) logIn.getScene().getWindow();
                        stage.close();

                    } catch (Exception ex) {
                        Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            for (int i = 0; i < radnici.size(); i++) {
                if (radnici.get(i).getJmbg().equals(jmbgTextField.getText()) && radnici.get(i).getPassword().equals(pwBox.getText())) {
                    //run radnici deo
                    System.out.println("Radnik Usao");
                    try {
                        runAnotherApp(RadnikEkran.class);
                        Stage stage = (Stage) logIn.getScene().getWindow();
                        stage.close();
                    } catch (Exception ex) {
                        Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }

        });

        try {
            runAnotherApp(PanicTaster.class);
            //Stage stage = (Stage) logIn.getScene().getWindow();
            //stage.close();
        } catch (Exception ex) {
            Logger.getLogger(PocetniEkranView.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
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
