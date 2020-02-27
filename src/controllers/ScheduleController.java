package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import manager.KioskManager;
import utilities.GestureHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

    @FXML
    private WebView webView;
    @FXML
    private JFXDrawer drawer;

    private final String urlweb = "http://localhost:3000/pages/kioskSchedules.html"; //UPDATE ME PLEASE
    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = webView.getEngine();
        web.setJavaScriptEnabled(true);
        web.executeScript("location.reload(true);");
        web.load(urlweb);

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
                    //TODO: OPEN NAVMENU
                }
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
