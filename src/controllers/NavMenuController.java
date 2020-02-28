package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class NavMenuController implements Initializable {

    private final StringProperty activeWindow = new SimpleStringProperty();

    public StringProperty activeWindowProperty(){
        return activeWindow;
    }

    public final String getActiveWindow(){
        return activeWindowProperty().get();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activeWindow.set("slideshow");
    }

    @FXML
    public void openSlideshow(){
        if(!activeWindow.get().equals("slideshow")){
            activeWindow.set("slideshow");
        }
    }

    @FXML
    public void openSchedules(){
        if(!activeWindow.equals("schedules")){
            activeWindow.set("schedules");
        }
    }

    @FXML
    public void openPolls(){
        if(!activeWindow.equals("polls")){
            activeWindow.set("polls");
        }
    }

    @FXML
    public void openDepartment(){
        if(!activeWindow.equals("department")){
            activeWindow.set("department");
        }
    }
}
