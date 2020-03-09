package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.StackPane;
import manager.KioskManager;
import modules.Slideshow;
import utilities.GestureHandler;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class SlideshowController implements Initializable {

    private static final long AFTER_TOUCH_IDLE_DURATION = 10000;
    private Slideshow slideshow;
    private GestureHandler gestureHandler;

    @FXML
    private StackPane slideshowContainer;

    @FXML
    private ImageView imageView;

    @FXML
    private JFXDrawer drawer;

    private Timer t;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gestureHandler = new GestureHandler();
        setDefaultBounds();
        this.slideshow = (Slideshow) KioskManager.getInstance().getModule("slideshow");

        slideshow.init(imageView);
        slideshow.onWake();
    }

    public void setDefaultBounds(){
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(bounds.getHeight());
        imageView.setFitWidth(bounds.getWidth());
        imageView.fitHeightProperty().bind(slideshowContainer.heightProperty());
        imageView.fitWidthProperty().bind(slideshowContainer.widthProperty());
    }
    @FXML
    //Transition slideshow active_image to previous photo
    public void previousPhoto() {
        monitorIdle();
        slideshow.previousImage();
        slideshow.setImage();
    }

    @FXML
    //Transition slideshow active_image to next photo
    public void nextPhoto() {
        monitorIdle();
        slideshow.nextImage();
        slideshow.setImage();
    }

    private void monitorIdle() {

        slideshow.cancelTimer();

        if(t != null){
            t.cancel();
            t.purge();
        }

        t = new Timer(true);
        t.schedule(
                new java.util.TimerTask(){
                    @Override
                    public void run() {
                        //Close Menu after menu duration exceeded
                        slideshow.startTimer();
                    }
                },
                AFTER_TOUCH_IDLE_DURATION
        );
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
                //openDrawer();
                default:
                break;
        }
    }

    @FXML
    public void onTouchEvent(MouseEvent event) throws IOException {
        monitorIdle();
        if(!gestureHandler.inMotion()){
            gestureHandler.startGesture(event);
        }
    }

    @FXML
    public void onTouchReleased(MouseEvent event) throws IOException {
        monitorIdle();
        if(gestureHandler.inMotion()){
            if(gestureHandler.validate(event)){
                //Gesture has just completed
                EventType<SwipeEvent> swipe = gestureHandler.processGesture();
                if(swipe.equals(SwipeEvent.SWIPE_UP)){
                } else if(swipe.equals(SwipeEvent.SWIPE_LEFT)){
                    previousPhoto();
                } else if(swipe.equals(SwipeEvent.SWIPE_RIGHT)){
                    nextPhoto();
                } else if(swipe.equals(SwipeEvent.SWIPE_DOWN)){ }
            }
        } else {
            //User tapped center of Touchscreen
            //Pause Slideshow / Show options
            //TODO: Call timer to wait for inactivity
        }
    }
}
