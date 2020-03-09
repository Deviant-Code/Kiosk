package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import manager.KioskManager;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NavMenuController implements Initializable {

    @FXML
    private JFXButton slideshowBtn;
    @FXML
    private JFXButton pollsBtn;
    @FXML
    private JFXButton schedulesBtn;
    @FXML
    private JFXButton departmentBtn;

    @FXML
    private HBox navMenu;

    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());


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
        bindButtons();
    }

    //Verifies valid modules and consistency with data layer and binds module buttons to drawer size
    //Allows for dynamic scaling and for buttons to be disabled, or enabled from admin portal
    private void bindButtons(){
        // Ensure navigation menu contains valid navigation module nodes, else remove rogue nodes.
        if(navMenu.getChildren().removeIf(node -> !(node instanceof Button || node instanceof JFXButton))){
            logr.log(Level.WARNING,"NavMenu contains a direct child that is not of a recognized button type. " +
                    "Loose nodes will be removed to maintain proper scaling. See design spec for details");
        }

        ObservableList<Node> buttons = navMenu.getChildren();
        int btnCount = buttons.size();
        int moduleCount = KioskManager.getInstance().getModuleCount();
        if(btnCount != moduleCount){
            logr.log(Level.WARNING, "Module count in view level does not match data level. Ensure modules declared" +
                    " in KioskManager are consistent with those in the navMenu. Nav Menu: " + btnCount + " , " +
                    "KioskManager: " + moduleCount);
        }

        //Scale Buttons to navigation drawer proportional to the number of modules
        for (Node btn: buttons) {
            ((Button) btn).prefWidthProperty().bind(navMenu.widthProperty().divide(btnCount));
            ((Button) btn).prefHeightProperty().bind(navMenu.heightProperty());
        }
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
