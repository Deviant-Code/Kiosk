import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class PollController implements Initializable {
    @FXML
    private WebView viewweb;
    private Parent menuRoot;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = viewweb.getEngine();
        String urlweb = "https://127.0.0.1:3000/pages/kioskPoll";
        web.load(urlweb);
    }

    public void openMenuScene(Event actionEvent) {
        scene.setRoot(menuRoot);
    }

    public void setMenuRoot(Parent menuRoot) {
        this.menuRoot = menuRoot;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
