package controllers;


import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import manager.KioskManager;
import modules.Department;
import utilities.GestureHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class DeptController implements Initializable {

    @FXML
    private StackPane webViewContainer;

    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Department department = (Department) KioskManager.getInstance().getModule("department");
        BrowserView browserView = BrowserView.newInstance(department.getBrowser());
        webViewContainer.getChildren().addAll(browserView);
    }

}
