package manager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modules.*;
import controllers.*;

public class KioskManager {

    private static KioskManager instance = null;

    static ModuleInterface activeModule; //shows current module being used
    static Slideshow slideshow;
    static Video video;
    static Schedules schedules;
    static Map map;
    static Polls polls;
    static Department department;


    // Root for each module to change between scenes
    private Parent pollRoot;
    private Parent deptRoot;
    private Parent scheduleRoot;
    private Parent slideshowRoot;

    // Scene & Display Controls
    private Scene scene;
    private Stage stage;

    private KioskManager(){
        //Private Constructor
    }

    public static KioskManager getInstance(){
        if(instance == null){
            instance = new KioskManager();
        }
        return instance;
    }

    //Transition kiosk to a different module given the name of the module
    //Returns requested scene to controller to set root
    public void transition(String module){
        switch (module){
            case "SS":
                if (activeModule != slideshow) {
                    slideshow.update();
                    slideshow.setImage();
                    slideshow.resume();
                    activeModule = slideshow;
                    scene.setRoot(slideshowRoot);
                }
            case "POLLS":
                activeModule = polls;
                scene.setRoot(pollRoot);
                stage.show();
            case "DEPT":
                activeModule = department;
                scene.setRoot(deptRoot);
            case "SCHED":
                activeModule = schedules;
                scene.setRoot(scheduleRoot);
            case "MAPS": //TODO: Implement a map module
                //activeModule = map;
                //scene.setRoot(mapRoot);
            default:
                activeModule = slideshow;
                scene.setRoot(slideshowRoot);
        }
        stage.show();
    }


    // *********** Getters and Setters *********** \\

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void setRoots(Parent slideshowRoot, Parent pollRoot, Parent deptRoot, Parent scheduleRoot){
        this.slideshowRoot = slideshowRoot;
        this.pollRoot = pollRoot;
        this.deptRoot = deptRoot;
        this.scheduleRoot = scheduleRoot;
    }

    public Scene getScene() {
        return this.scene;
    }


    public Stage getStage() {
        return this.stage;
    }

}