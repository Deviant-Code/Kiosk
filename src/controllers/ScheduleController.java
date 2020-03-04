package controllers;

import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import manager.KioskManager;
import modules.Polls;
import modules.Schedules;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

    @FXML
    private StackPane webViewContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Schedules schedules = (Schedules) KioskManager.getInstance().getModule("schedules");
        BrowserView browserView = BrowserView.newInstance(schedules.getBrowser());
        webViewContainer.getChildren().addAll(browserView);
    }

}
