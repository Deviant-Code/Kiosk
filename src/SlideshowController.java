import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import manager.KioskManager;
import javafx.scene.Parent;
import modules.Slideshow;

import java.io.IOException;

public class SlideshowController {

    private Scene scene;
    private Slideshow ss;
    private Parent menuRoot;

    public void openMenuScene(Event actionEvent) {
        scene.setRoot(menuRoot);
    }

    public void setImage(Event event, String filename) {
        ImageView imageView = (ImageView) scene.lookup("#ss_image_view");
        Image image = new Image(filename);
        imageView.setImage(image);
    }

    //Transition slideshow active_image to previous photo
    public void previousPhoto(Event event) throws IOException {
        setImage(event, ss.getImage("BACKWARD"));
        ss.setTimer();
    }

    //Transition slideshow active_image to next photo
    public void nextPhoto(Event event) throws IOException {
        setImage(event, ss.getImage("FORWARD"));
        ss.setTimer();
    }

    @FXML
    public void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case RIGHT:
                nextPhoto(event);
                break;
            case LEFT:
                previousPhoto(event);
                break;
            case DOWN:
                KioskManager.ssActive(false);
                openMenuScene(event);
                default:
                break;
        }
    }

    public void setSS(Slideshow ss){
        this.ss = ss;
    }

    public void setMenuRoot(Parent menu) {
        this.menuRoot = menu;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
