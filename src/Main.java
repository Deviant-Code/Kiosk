import controllers.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import manager.KioskManager;
import modules.Slideshow;

import java.io.*;

public class Main extends Application {

    private static Slideshow slideshow;
    private static Process pr;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Set stage parameters
        primaryStage.setTitle("Project Electra: V0.1.2");

        primaryStage.setFullScreen(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        KioskManager kioskManager = KioskManager.getInstance();;
        kioskManager.setStage(primaryStage);

        //Generate FXML Loaders for each module
        FXMLLoader slideshowLoader = new FXMLLoader(getClass().getResource("fxml/slideshow.fxml"));
        FXMLLoader webViewLoader = new FXMLLoader(getClass().getResource("fxml/webview.fxml"));
        FXMLLoader pollViewLoader = new FXMLLoader(getClass().getResource("fxml/pollView.fxml"));
        FXMLLoader schedulerLoader = new FXMLLoader(getClass().getResource("fxml/schedule.fxml"));

        //Generate Roots for each loader
        Parent slideshowRoot = slideshowLoader.load();
        Parent deptRoot = webViewLoader.load();
        Parent pollViewRoot = pollViewLoader.load();
        Parent scheduleRoot = schedulerLoader.load();

        //Build Scene and pass in slideshow as original root
        Scene scene = new Scene(slideshowRoot,bounds.getWidth(), bounds.getHeight());

        //Build Controllers for each view
        SlideshowController ssController = slideshowLoader.getController();
        WebController webController = webViewLoader.getController();
        PollController pollController = pollViewLoader.getController();
        ScheduleController scheduleController = schedulerLoader.getController();

        //set scene, root, and controllers to kiosk manager
        kioskManager.setRoots(slideshowRoot,pollViewRoot,deptRoot,scheduleRoot);
        kioskManager.setControllers(ssController, webController, pollController, scheduleController);

        //Set Scene and Show Stage
        kioskManager.setScene(scene);

        //Initialize modules
        kioskManager.videoInit();
        kioskManager.slideShowInit();

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreenExitHint("Kiosk");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if(pr != null)
                    pr.destroy();
            }
        });       
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

    public static void main(String[] args){

        Runtime rt = Runtime.getRuntime();
        try{
            pr = rt.exec("java -cp dependencies/gson/gson-2.8.6.jar manager/AdminPortalListener.java");
            launch(args);
            pr.destroy();
        }
        catch(IOException E){
            if(pr != null)
                pr.destroy();

            System.exit(0);
        }
    }

    @Override
    public void stop() {
        if(pr != null)
            pr.destroy();

        System.exit(0);
    }
}
