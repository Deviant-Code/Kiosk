package controllers;

import javafx.fxml.FXML;
import manager.KioskManager;

public class DrawerController {

    @FXML
    public void openSlideshow(){
        KioskManager.getInstance().transition("SS");
    }

    @FXML
    public void openSchedules(){
        KioskManager.getInstance().transition("SCHE");
    }

    @FXML
    public void openPolls(){
        KioskManager.getInstance().transition("POLLS");
    }

    @FXML
    public void openDepartment(){
        KioskManager.getInstance().transition("DEPT");
    }
}
