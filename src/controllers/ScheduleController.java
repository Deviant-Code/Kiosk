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

    private final String urlweb = "http://localhost:3000/pages/kioskSchedules.html"; //UPDATE ME PLEASE
    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = webView.getEngine();
        web.setJavaScriptEnabled(true);
        web.executeScript("location.reload(true);");
        web.load(urlweb);
    }

}
