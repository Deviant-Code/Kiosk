package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import manager.KioskManager;
import javafx.scene.Parent;
import modules.Slideshow;

import java.io.IOException;

public class SlideshowController {

    private Slideshow ss;
    @FXML
    private ImageView ss_image_view;

    //Gesture Processing
    private boolean mouseDragEvent;
    private final long dragTimeThreshold = 1000; // Max time for a gesture before being consumed in ms
    private final double distanceThreshold = 20; // Min distance for a gesture
    private final double differenceThreshold = .25; // Percent difference between vert. and horiz. distance to be considered a swipe
    private long startTime = -1l; // Records the time a touch gesture begins
    private double startX; // Start location of gesture
    private double startY; // End location of gesture

    public void openMenuScene(Event actionEvent) {
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
                openMenuScene(event);
                default:
                break;
        }
    }

    @FXML
    public void onTouchEvent(MouseEvent event) throws IOException {
        if(event.getEventType().equals(MouseEvent.DRAG_DETECTED)){
            mouseDragEvent = true;
            startTime = System.currentTimeMillis();
            startX = event.getX();
            startY = event.getY();
        } else {
            event.consume();
        }
    }

    @FXML
    public void onTouchReleased(MouseEvent event) throws IOException {
        if(mouseDragEvent){
            //User swiped touchscreen
            long netTime = System.currentTimeMillis() - startTime;
            if(netTime < dragTimeThreshold && netTime != -1l){
                processGesture(event);
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
        mouseDragEvent = false;
        startTime = -1l;
    }

    private void processGesture(MouseEvent event){

        double horizontalShift = event.getX() - startX;
        double verticalShift = event.getY() - startY;
        double horizontalMagnitude = Math.abs(horizontalShift);
        double verticalMagnitude = Math.abs(verticalShift);

        if((horizontalMagnitude < distanceThreshold && verticalMagnitude < distanceThreshold)
            ||  Math.abs((1.0-(verticalMagnitude/horizontalMagnitude))) < differenceThreshold ){
            return;
        }

        if(horizontalMagnitude > verticalMagnitude && (horizontalMagnitude - verticalMagnitude) > differenceThreshold){
            if(horizontalShift < 0){
                //Left Swipe
                previousPhoto();
            } else {
                //Right Swipe
                nextPhoto();
            }
        } else if((verticalMagnitude - horizontalMagnitude) > differenceThreshold){
            //Process Swipe Up or Swipe Down
            if(verticalShift < 0){
                //Swipe Up
                System.out.println("UP");
                openMenuScene(event);
            } else {
                //Swipe Down
            }
        }
    }

    public void setSS(Slideshow ss){
        this.ss = ss;
    }
}
