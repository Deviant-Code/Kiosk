package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import manager.KioskManager;

import java.io.IOException;

public class MenuController {

    private KioskManager kioskManager;
    @FXML
    private StackPane menuRoot;
    @FXML
    private ImageView background;
    @FXML
    private GridPane modules;
    @FXML
    private Button slideshow;
    @FXML
    private Button schedules;
    @FXML
    private Button polls;
    @FXML
    private Button department;
    @FXML
    private Pane topbuffer;

    public void initialize() {
        kioskManager = KioskManager.getInstance();
        Stage stage = kioskManager.getStage();
        menuRoot.maxHeightProperty().bind(stage.heightProperty());
        menuRoot.maxWidthProperty().bind(stage.heightProperty());
        background.fitHeightProperty().bind(menuRoot.heightProperty());
        background.fitWidthProperty().bind(menuRoot.widthProperty());
        bind(modules, menuRoot,1,1);
        topbuffer.maxHeightProperty().bind(menuRoot.heightProperty().multiply(.19));
        modules.maxHeightProperty().bind(menuRoot.heightProperty().multiply(.70));
        modules.maxWidthProperty().bind(menuRoot.widthProperty().multiply(.70));
        bind(slideshow, modules,.35,.21);
        bind(schedules,modules,.35,.21);
        bind(polls,modules, .35,.21);
        bind(department,modules,.35,.21);
    }

    public void bind(Region object, Region source, double modifierH, double modifierW){
        object.maxHeightProperty().bind(source.heightProperty().multiply(modifierH));
        object.maxWidthProperty().bind(source.widthProperty().multiply(modifierW));
    }

    //Requests module root to transition scene from KioskManager
    public void transition(String module){
        Scene scene = KioskManager.getInstance().getScene();
        Parent root = KioskManager.getInstance().transition(module);
        scene.setRoot(root);
    }

    @FXML
    public void openSlideShow(Event actionEvent) throws IOException {
        transition("SS");
    }

    @FXML
    public void openPolls(Event actionEvent) throws IOException {
        transition("POLLS");
    }

    @FXML
    public void openDepartment(Event actionEvent) throws IOException {
        transition("DEPT");
    }

    @FXML
    private void openSchedules(Event actionEvent) throws IOException {
        transition("SCHED");
    }

    private void openMaps(Event actionEvent) throws IOException {
        transition("MAPS");
    }



}
