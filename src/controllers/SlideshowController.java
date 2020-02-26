package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import manager.KioskManager;
import javafx.scene.Parent;
import modules.Slideshow;
import utilities.GestureHandler;

import java.io.IOException;

public class SlideshowController {

    private Slideshow ss;
    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @FXML
    private JFXDrawer drawer;

    public void openMenuScene() {
        Scene scene = KioskManager.getInstance().getScene();
        Parent root = KioskManager.getInstance().transition("MENU");
        scene.setRoot(root);
    }

    //Transition slideshow active_image to previous photo
    public void previousPhoto() {
        ss.previousImage();
        ss.setImage();
        if(!ss.isPaused()){
            ss.resume();
        }
    }

    //Transition slideshow active_image to next photo
    public void nextPhoto() {
        ss.nextImage();
        ss.setImage();
        if(!ss.isPaused()){
            ss.resume();
        }
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
                openMenuScene();
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
                    System.out.println("SWIPEUP");
                    initDrawer();
                } else if(swipe.equals(SwipeEvent.SWIPE_LEFT)){
                    previousPhoto();
                } else if(swipe.equals(SwipeEvent.SWIPE_RIGHT)){
                    nextPhoto();
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

    public void setSS(Slideshow ss){
        this.ss = ss;
    }

    private void initDrawer(){
        try {
            HBox menu = FXMLLoader.load(getClass().getResource("../fxml/kioskNavMenu.fxml"));
            drawer.setSidePane(menu);
            drawer.setPrefWidth((KioskManager.getInstance().getScene().getWidth()/3)*2);
            drawer.setPrefHeight(KioskManager.getInstance().getScene().getHeight()/6);
            drawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
