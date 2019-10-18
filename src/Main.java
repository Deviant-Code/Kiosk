import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/KioskView.fxml"));
        Scene scene = new Scene (root);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Electra");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("res/icon.png")));
        primaryStage.setResizable(false); 
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (KeyCode.F11.equals(event.getCode())) {
                primaryStage.setFullScreen(!primaryStage.isFullScreen());
            }
        });
    }

    public static void main(String[] args){
        launch(args); 
    }

}
