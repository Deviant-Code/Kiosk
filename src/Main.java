import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
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


        //TODO: Use below bounds to adjust for varying screen resolutions
        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

        //Set stage parameters
        primaryStage.setTitle("Project Electra: V0.1.2");
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreenExitHint("Kiosk");

        //Generate loader for module menu
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("fxml/kioskDisplay.fxml"));
        Parent menu = menuLoader.load();
        Scene menuScene = new Scene(menu);

        //Generate loader for slideshow menu
        FXMLLoader slideshowLoader = new FXMLLoader(getClass().getResource("fxml/slideshow.fxml"));
        Parent slideshow = slideshowLoader.load();
        Scene ssScene = new Scene(slideshow);

        //Generate loader for webview
        FXMLLoader webViewLoader = new FXMLLoader(getClass().getResource("fxml/webview.fxml"));
        Parent webView = webViewLoader.load();
        Scene webScene = new Scene(webView);
        WebController webController = webViewLoader.getController();
        webController.setMenuScene(menuScene);

        //Initiate Controller for Menu and pass reference to module scenes
        MenuController menuController = menuLoader.getController();
        menuController.setSlideshowScene(ssScene);
        menuController.setWebScene(webScene);
        Slideshow ss = new Slideshow();
        ss.setScene(ssScene);

        //Initiate Controller for slideshow and pass reference to menu scene
        SlideshowController ssController = slideshowLoader.getController();
        ssController.setMenuScene(menuScene);
        ssController.setSlideshow(ss);
        menuController.setSlideshowController(ssController);

        KioskManager.setSS(ss);

        Video video = new Video();
        KioskManager.setVideo(video);

        //Set Scene and Show Stage
        primaryStage.setScene(menuScene);
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
