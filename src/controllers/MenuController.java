package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import manager.KioskManager;

import java.io.IOException;

public class MenuController {

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

    public void openPolls(Event actionEvent) throws IOException {
        transition("POLLS");
    }

    public void openDepartment(Event actionEvent) throws IOException {
        transition("DEPT");
    }

    private void openSchedules(Event actionEvent) throws IOException {
        transition("SCHED");
    }

    private void openMaps(Event actionEvent) throws IOException {
        transition("MAPS");
    }



}
