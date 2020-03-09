import controllers.DynamicController;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.fxml.FXMLLoader;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import manager.KioskManager;

import java.io.*;

public class Main extends Application {

    private static Process pr;
    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            this.stage = primaryStage;
            setWindowProperties(primaryStage);
            KioskManager kioskManager = KioskManager.getInstance();
            FXMLLoader dynamicContainer = new FXMLLoader(getClass().getResource("fxml/dynamicContainer.fxml"));
            Scene scene = new Scene(dynamicContainer.load(),primaryStage.getWidth(), primaryStage.getHeight());

            //Set Scene and Show Stage
            DynamicController controller = dynamicContainer.getController();
            controller.bindScene(scene);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setWindowProperties(Stage primaryStage) {
        // Set Window Properties
        primaryStage.setTitle("Western Washington University - CS Department Display");

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (pr != null)
                    pr.destroy();
            }
        });
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
