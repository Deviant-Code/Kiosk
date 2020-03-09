package controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

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

    private final BooleanProperty drawerVisibleProperty = new SimpleBooleanProperty();


    @FXML
    private NavMenuController navMenuController;
    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());
    private static final String CORE_MOD_DIR = "/fxml/coreModules/";
    private GestureHandler gestureHandler;

    private Map<String, Parent> moduleRoots = new HashMap<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gestureHandler = new GestureHandler();
        drawer.setSidePane(navMenu);
        navMenuController.activeWindowProperty().addListener(((observable, oldValue, newValue) -> setView(newValue)));
        initializeViews();
        kioskOverlay.pickOnBoundsProperty().bind(gestureHandler.inMotionProperty().or(drawerVisibleProperty));
       // setView("slideshow");

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
        requestedRoot.prefHeightProperty().bind(scene.heightProperty());
        requestedRoot.prefWidthProperty().bind(scene.widthProperty());
        dynamicPane.getChildren().setAll(moduleRoots.get(requestedModule));
    }

    @FXML
    public void onTouchEvent(MouseEvent event) throws IOException {
        if(!gestureHandler.inMotion()){
            gestureHandler.startGesture(event);
        }
    }

    @FXML
    public void onTouchReleased(MouseEvent event) throws IOException {
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
            drawerVisibleProperty.set(true);
        }
    }

    private void closeDrawer() {
        if(drawer.isOpened()){
            drawer.close();
            drawerVisibleProperty.set(false);
        }
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void bindScene(Scene scene) {
        this.scene = scene;
        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());
        dynamicPane.prefWidth(scene.getWidth());
        dynamicPane.prefHeight(scene.getHeight());
        drawer.prefWidthProperty().bind(scene.widthProperty().divide((2/3)));
        drawer.prefHeightProperty().bind(scene.heightProperty().divide(6));
        drawer.setDefaultDrawerSize(drawer.getPrefHeight());
        navMenu.prefHeightProperty().bind(drawer.heightProperty());
        navMenu.prefWidthProperty().bind(drawer.widthProperty());
        setView("slideshow");
    }

}
