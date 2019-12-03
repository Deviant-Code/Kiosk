import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WebController implements Initializable {
    @FXML
    private WebView viewweb;
    private Scene menuScene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = viewweb.getEngine();
        String urlweb = "http://127.0.0.1:3000/pages/kioskPoll.html";
        web.load(urlweb);
    }

    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    public void openMenuScene(Event actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //Weird JavaFX bug requires toggle on full screen after swapping scenes
        //primaryStage.setFullScreen(false);
        primaryStage.setScene(menuScene);
        primaryStage.setFullScreen(true);
    }
}
