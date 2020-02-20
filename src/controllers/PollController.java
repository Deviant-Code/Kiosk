package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import manager.KioskManager;

import java.net.URL;
import java.util.ResourceBundle;

public class PollController implements Initializable {
    @FXML
    private WebView viewweb;
    private final String urlweb = "http://127.0.0.1:3000/pages/kioskPoll.html";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final WebEngine web = viewweb.getEngine();
        web.setJavaScriptEnabled(true);
        web.executeScript("location.reload(true);");
        web.load(urlweb);
    }

    public void openMenuScene(Event actionEvent) {
        Scene scene = KioskManager.getInstance().getScene();
        Parent root = KioskManager.getInstance().transition("MENU");
        scene.setRoot(root);
        refresh();
    }

    public void refresh() {
        viewweb.getEngine().load(urlweb);
    }
}
