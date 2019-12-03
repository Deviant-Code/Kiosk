import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
}
