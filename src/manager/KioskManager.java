package manager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import modules.*;
import controllers.*;

import java.io.IOException;

public class KioskManager {

    private static KioskManager instance = null;

    static modules.Module activeModule; //shows current module being used
    static Slideshow slideshow;
    static Video video;
    static Schedules schedules;
    static Map map;

    //Save state of root for changing scenes
    private Parent menuRoot;
    private Parent pollRoot;
    private Parent deptRoot;
    private Parent slideshowRoot;
    private Scene scene;

    //Controllers for fxml files
    private MenuController menuController;
    private SlideshowController slideshowController;
    private PollController pollController;
    private WebController deptController;
    //private MapController mapController;
    //private ScheduleController scheduleController;

    private KioskManager(){
        //Private Constructor
    }

    public static KioskManager getInstance(){
        if(instance == null){
            instance = new KioskManager();
        }
        return instance;
    }

    public void setScene(){
        this.scene = new Scene(menuRoot);
    }

    //Transition kiosk to a different module given the name of the module
    //Returns requested scene to controller to set root
    public Parent transition(String module){
        switch (module){
            case "MENU":
                if(activeModule == slideshow){
                    slideshow.pause();
                }
                activeModule = null;
                return menuRoot;
            case "SS":
                startSlideShow();
                activeModule = slideshow;
                return slideshowRoot;
            case "POLLS":
                //activeModule = polls;
                return pollRoot;
            case "DEPT":
                //activeModule = department;
                return deptRoot;
            case "SCHED":
                //Future modules, not yet implemented
                //activeModule = schedules;
                //return scheduleRoot;
            case "MAPS":
                //Future modules, not yet implemented
                //activeModule = maps;
                //return mapRoot;
            default:
                return menuRoot;
        }
    }

    public void startSlideShow() {
        slideshow.setImage();
        slideshow.resume();
    }

    public void setRoots(Parent slideshowRoot, Parent pollRoot, Parent deptRoot, Parent menuRoot){
        this.slideshowRoot = slideshowRoot;
        this.pollRoot = pollRoot;
        this.deptRoot = deptRoot;
        this.menuRoot = menuRoot;
    }

    public void setControllers(MenuController menuController, SlideshowController slideshowController, WebController deptController, PollController pollController){
        this.menuController = menuController;
        this.slideshowController = slideshowController;
        this.deptController = deptController;
        this.pollController = pollController;
    }

    public void slideShowInit() throws Exception {
        ImageView imageView = (ImageView) slideshowRoot.lookup("#ss_image_view");
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(scene.widthProperty());
        imageView.fitHeightProperty().bind(scene.heightProperty());

        slideshow = new Slideshow(imageView);
        slideshowController.setSS(slideshow);
    }

    public void videoInit() {
        video = new Video();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return this.scene;
    }
}