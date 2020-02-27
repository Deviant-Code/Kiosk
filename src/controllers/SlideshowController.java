package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.HBox;
import manager.KioskManager;
import modules.Slideshow;
import utilities.GestureHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SlideshowController implements Initializable {

    private Slideshow ss;
    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @FXML
    private ImageView imageView;

    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ss = new Slideshow(imageView);

        imageView.setPreserveRatio(true);
        imageView.fitHeightProperty().bind(KioskManager.getInstance().getStage().widthProperty());
        imageView.fitHeightProperty().bind(KioskManager.getInstance().getStage().heightProperty());

        HBox menu = null;
        try {
            menu = FXMLLoader.load(getClass().getResource("../fxml/kioskNavMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO: Move FXML Loaders to KioskManager to eliminate redundancies
        drawer.setSidePane(menu);
        drawer.setPrefWidth((KioskManager.getInstance().getStage().getWidth()/3)*2);
        drawer.setPrefHeight(KioskManager.getInstance().getStage().getHeight()/6);

        ss.resume();
    }

    @FXML
    //Transition slideshow active_image to previous photo
    public void previousPhoto() {
        ss.previousImage();
        ss.setImage();
        if(!ss.isPaused()){
            ss.resume();
        }
    }

    @FXML
    //Transition slideshow active_image to next photo
    public void nextPhoto() {
        ss.nextImage();
        ss.setImage();
        if(!ss.isPaused()){
            ss.resume();
        }
    }

    @FXML
    public void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                nextPhoto();
                break;
            case LEFT:
                previousPhoto();
                break;
            case DOWN:
                openDrawer();
                default:
                break;
        }
    }

    @FXML
    public void onTouchEvent(MouseEvent event) throws IOException {
        gestureHandler.startGesture(event);
    }

    @FXML
    public void onTouchReleased(MouseEvent event) throws IOException {
        if(gestureHandler.inMotion()){
            if(gestureHandler.validate(event)){
                //Gesture has just completed
                EventType<SwipeEvent> swipe = gestureHandler.processGesture();
                if(swipe.equals(SwipeEvent.SWIPE_UP)){
                    openDrawer();
                } else if(swipe.equals(SwipeEvent.SWIPE_LEFT)){
                    previousPhoto();
                } else if(swipe.equals(SwipeEvent.SWIPE_RIGHT)){
                    nextPhoto();
                } else if(swipe.equals(SwipeEvent.SWIPE_DOWN)){
                    closeDrawer();
                }
            }
        } else {
            //User tapped center of Touchscreen
            //Pause Slideshow / Show options
            if(ss.isPaused()){
                ss.resume();
            } else {
                ss.pause();
            }
        }
    }

    private void openDrawer(){
        if(drawer.isClosed()){
            drawer.open();
        }
    }

    private void closeDrawer() {
        if(drawer.isOpened()){
            drawer.close();
        }
    }



}
