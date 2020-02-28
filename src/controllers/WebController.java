package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import manager.KioskManager;
import utilities.GestureHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WebController implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private JFXDrawer drawer;

    private WebEngine web;

    @FXML
    private BorderPane kioskOverlay;

    private final String urlweb = "http://localhost:3000/pages/kioskDepartment.html";

    private GestureHandler gestureHandler = GestureHandler.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.web = webView.getEngine();
        web.load(urlweb);
    }

    public void load(){

    }

    @FXML
    public void onTouchEvent(MouseEvent event)  {
        gestureHandler.startGesture(event);
    }

    @FXML
    public void onTouchReleased(MouseEvent event) {
        if(gestureHandler.inMotion()) {
            if (gestureHandler.validate(event)) {
                //Gesture has just completed
                EventType<SwipeEvent> swipe = gestureHandler.processGesture();
                if (swipe.equals(SwipeEvent.SWIPE_UP)) {
                    openDrawer();
                } else if(swipe.equals(SwipeEvent.SWIPE_DOWN)){
                    closeDrawer();
                }
            }
        }
    }

    public void refresh() {
        webView.getEngine().load(urlweb);
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
