import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import manager.KioskManager;
import modules.Slideshow;
import modules.Video;

import java.io.*;

public class Main extends Application {

    private static Slideshow slideshow;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Set stage parameters
        primaryStage.setTitle("Project Electra: V0.1.2");

        //12-3 New patch, added effects and modules are causing a delay in the rendering time of scene swaps. Attempting
        //new method to prevent screen resize delay
        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(300);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        //Generate FXML Loaders for each module
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("fxml/kioskDisplay.fxml"));
        FXMLLoader slideshowLoader = new FXMLLoader(getClass().getResource("fxml/slideshow.fxml"));
        FXMLLoader webViewLoader = new FXMLLoader(getClass().getResource("fxml/webview.fxml"));
        FXMLLoader pollViewLoader = new FXMLLoader(getClass().getResource("fxml/pollView.fxml"));

        //Generate Roots for each loader
        Parent menuRoot = menuLoader.load();
        Parent slideshowRoot = slideshowLoader.load();
        Parent webViewRoot = webViewLoader.load();
        Parent pollViewRoot = pollViewLoader.load();

        //Build Scene and pass in main menu as original root
        Scene scene = new Scene(menuRoot);

        //Build Controllers for each view
        MenuController menuController = menuLoader.getController();
        SlideshowController ssController = slideshowLoader.getController();
        WebController webController = webViewLoader.getController();
        PollController pollController = pollViewLoader.getController();

        //Pass in content roots to each controller that needs access to other modules
        menuController.setSlideshowRoot(slideshowRoot);
        menuController.setPollRoot(pollViewRoot);
        menuController.setWebRoot(webViewRoot);
        ssController.setMenuRoot(menuRoot);
        webController.setMenuRoot(menuRoot);
        pollController.setMenuRoot(menuRoot);

        //Pass reference to scene to each controller
        menuController.setScene(scene);
        ssController.setScene(scene);
        webController.setScene(scene);
        pollController.setScene(scene);

        //Give menuController reference to ss controller

        //Initialize slideshow
        Slideshow ss = new Slideshow();
        ssController.setSS(ss);
        KioskManager.setSS(ss);
        ss.updateSlides();
        ImageView imgView = (ImageView) slideshowRoot.lookup("#ss_image_view");
        imgView.setPreserveRatio(true);
        imgView.fitWidthProperty().bind(scene.widthProperty());
        imgView.fitHeightProperty().bind(scene.heightProperty());

        //Initialize video module
        Video video = new Video();
        KioskManager.setVideo(video);

        //Set Scene and Show Stage
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreenExitHint("Kiosk");
        primaryStage.show();
    }

    // //running the kiosk
    // static Runnable r1 = new Runnable() {
    //     public void run() {
    //       try {
            
    //       } catch (InterruptedException iex) {}
    //     }
    //   };
    //   //running the portalListener
    //   static Runnable r2 = new Runnable() {
    //     public void run() {
    //       try {
    //         while(true){
    //             //sleep for 10 sec
    //             Thread.sleep(1000 * 10);
    //             portalListener.Listener();
    //         }
    //       } catch (InterruptedException iex) {}
    //     }
    //   };


    // public static launchKiosk(String[] args){
    //     launch(args);
    // }

    public static Slideshow getSlideshow() throws Exception {
        return slideshow;
    }

    public static void main(String[] args){

        Runtime rt = Runtime.getRuntime();
        try{
            Process pr = rt.exec("java -cp dependencies/gson/gson-2.8.6.jar manager/AdminPortalListener.java");
            launch(args);
            pr.destroy();
        }
        catch(IOException E){
            System.exit(0);
        }
    }    
}
