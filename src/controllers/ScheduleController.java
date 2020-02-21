package controllers;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import manager.KioskManager;
import utilities.GestureHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {
    @FXML
    private WebView viewweb;
    private final String urlweb = "http://www.google.com"; //UPDATE ME PLEASE

    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = viewweb.getEngine();
        web.setJavaScriptEnabled(true);
        web.executeScript("location.reload(true);");
        web.load(urlweb);
    }

    public void openMenuScene() {
        Scene scene = KioskManager.getInstance().getScene();
        Parent root = KioskManager.getInstance().transition("MENU");
        scene.setRoot(root);
        refresh();
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
                    openMenuScene();
                }
            }
        }
    }

    public void refresh() {
        viewweb.getEngine().load(urlweb);
    }
}
