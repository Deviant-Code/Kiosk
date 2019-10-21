import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class MenuController {

    //Handles on click/touch for transitioning to slideshow module
    public void runSlideShow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/slideshow.fxml"));
        Scene scene = Main.getScene();
        scene.setRoot(root);
    }

    //Transition back to main menu
    public void runMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/kioskDisplay.fxml"));
        Scene scene = Main.getScene();
        scene.setRoot(root);
    }
}
