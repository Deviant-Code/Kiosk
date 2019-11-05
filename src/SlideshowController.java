import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import manager.KioskManager;
import modules.Slideshow;

import java.io.IOException;

public class SlideshowController {

    private Scene menuScene;
    private Stage primaryStage;
    private Slideshow ss;

    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    public void openMenuScene(Event actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        //Weird JavaFX bug requires toggle on full screen after swapping scenes
        primaryStage.setFullScreen(false);
        primaryStage.setFullScreen(true);
    }

    public void setImage(Event event, String filename) {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ImageView imageView = (ImageView) primaryStage.getScene().lookup("#ss_image_view");
        Image image = new Image(filename);
        imageView.setImage(image);
    }

    //Transition slideshow active_image to previous photo
    public void previousPhoto(Event event) throws IOException {
        setImage(event, KioskManager.getSS().getImage("BACKWARD"));
        ss.setTimer();
    }

    //Transition slideshow active_image to next photo
    public void nextPhoto(Event event) throws IOException {
        setImage(event, KioskManager.getSS().getImage("FORWARD"));
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

    //TODO: Figure out the best implementation for a photo gallery view
    //          Option 1. Have thumbnails pop up in bottom bar on swipe up
    //          Option 2. Have a full photo gallery that can be opened up.

    public void leftThumbnails(ActionEvent event){
    }

    public void rightThumbnails(ActionEvent event){
    }

    public void setSlideshow(Slideshow ss) {
        this.ss = ss;
    }
}
