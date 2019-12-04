import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.KioskManager;
import modules.Slideshow;

import java.io.IOException;

public class MenuController {

    private SlideshowController ssController;
    private Parent slideshowRoot;
    private Scene scene;
    private Parent pollViewRoot;
    private Parent webViewRoot;

    @FXML
    public void openSlideShow(Event actionEvent) throws IOException {

        Slideshow ss = KioskManager.getSS();
        ImageView imageView = (ImageView) slideshowRoot.lookup("#ss_image_view");
        Image image = new Image(ss.getImage("CURRENT"));
        imageView.setImage(image);

        scene.setRoot(slideshowRoot);
        ss.setTimer();
    }

    public void openPolls(Event actionEvent) throws IOException {
        scene.setRoot(pollViewRoot);
    }

    public void openDepartment(Event actionEvent) throws IOException {
        scene.setRoot(webViewRoot);
    }

    public void setSlideshowRoot(Parent slideshow) {
        this.slideshowRoot = slideshow;
    }

    public void setScene(Scene menuScene) {
        this.scene = menuScene;
    }

    public void setPollRoot(Parent pollViewRoot) {
        this.pollViewRoot = pollViewRoot;
    }

    public void setWebRoot(Parent webViewRoot) {
        this.webViewRoot = webViewRoot;
    }
}
