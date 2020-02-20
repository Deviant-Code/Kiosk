package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import manager.KioskManager;
import javafx.scene.Parent;
import modules.Slideshow;

import java.io.IOException;

public class SlideshowController {

    private Slideshow ss;
    @FXML
    private ImageView ss_image_view;

    public void openMenuScene(Event actionEvent) {
        Scene scene = KioskManager.getInstance().getScene();
        Parent root = KioskManager.getInstance().transition("MENU");
        scene.setRoot(root);
    }

    //Transition slideshow active_image to previous photo
    public void previousPhoto() {
        ss.previousImage();
        ss.setImage();
        ss.resume();
    }

    //Transition slideshow active_image to next photo
    public void nextPhoto() {
        ss.nextImage();
        ss.setImage();
        ss.resume();
    }

    @FXML
    public void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case RIGHT:
                nextPhoto();
                break;
            case LEFT:
                previousPhoto();
                break;
            case DOWN:
                openMenuScene(event);
                default:
                break;
        }

    }

    public void setSS(Slideshow ss){
        this.ss = ss;
    }


}
