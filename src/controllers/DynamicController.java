package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import manager.KioskManager;
import utilities.GestureHandler;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamicController implements Initializable {

    @FXML
    private BorderPane kioskOverlay;

    @FXML
    private StackPane root;

    @FXML
    private AnchorPane dynamicPane;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private HBox navMenu;

    private Scene scene;



    @FXML
    private NavMenuController navMenuController;
    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());
    private static final String CORE_MOD_DIR = "/fxml/coreModules/";
    private GestureHandler gestureHandler;

    private Map<String, Parent> moduleRoots = new HashMap<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.gestureHandler = GestureHandler.getInstance();
        drawer.setSidePane(navMenu);
        navMenuController.activeWindowProperty().addListener(((observable, oldValue, newValue) -> setView(newValue)));

        initializeViews();
        bindViewsToScene();
        setView("slideshow");

    }

    private void bindViewsToScene() {
        moduleRoots.forEach((k,v)-> {
          //  v.prefWidth(scene.getWidth());
          //  v.prefHeight(scene.getHeight());
        });
    }

    //Loads FXML's corresponding to each core module and saves their roots for swapping between scenes
    private void initializeViews(){

        KioskManager.getModules().forEach((k,v)->{
            try {
                String rootPath = CORE_MOD_DIR + k + ".fxml";
                FXMLLoader loader = new FXMLLoader(getClass().getResource(rootPath));
                moduleRoots.put((String) k,loader.load());
            } catch (IOException e) {
                logr.log(Level.SEVERE, "Error loading corresponding fxml for declared module in KioskManager: " + k);
                e.printStackTrace();
            }
        });
    }

    private void setView(String requestedModule){
        KioskManager.getInstance().transition(requestedModule);
        StackPane requestedRoot = (StackPane) moduleRoots.get(requestedModule);
        requestedRoot.prefHeightProperty().bind(dynamicPane.heightProperty());
        requestedRoot.prefWidthProperty().bind(dynamicPane.widthProperty());
        dynamicPane.getChildren().setAll(moduleRoots.get(requestedModule));
    }

    @FXML
    public void onTouchEvent(MouseEvent event) throws IOException {
        kioskOverlay.setPickOnBounds(true);
        gestureHandler.startGesture(event);
    }

    @FXML
    public void onTouchReleased(MouseEvent event) throws IOException {
        kioskOverlay.setPickOnBounds(false);
        if(gestureHandler.inMotion()){
            if(gestureHandler.validate(event)){
                //Gesture has just completed
                EventType<SwipeEvent> swipe = gestureHandler.processGesture();
                if(swipe.equals(SwipeEvent.SWIPE_UP)){
                    openDrawer();
                } else if(swipe.equals(SwipeEvent.SWIPE_DOWN)){
                    closeDrawer();
                }
            }
        }
    }

    private void openDrawer(){
        if(drawer.isClosed()){
            drawer.open();
        }
    }

    private void closeDrawer() {
        if(drawer.isOpened()){
            drawer.close();
        }
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void bindScene(Scene scene) {
        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());
        dynamicPane.prefWidth(root.getWidth());
        dynamicPane.prefHeight(root.getHeight());
        drawer.prefWidthProperty().bind(dynamicPane.widthProperty().divide((2/3)));
        drawer.prefHeightProperty().bind(dynamicPane.heightProperty().divide(6));
        navMenu.prefHeightProperty().bind(drawer.heightProperty());
        navMenu.prefWidthProperty().bind(drawer.widthProperty());
    }
}
