
import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import manager.KioskManager;
import modules.Slideshow;

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

        //Initiate Controller for Menu and pass reference to module scenes
        MenuController menuController = menuLoader.getController();
        menuController.setSlideshowScene(ssScene);

        Slideshow ss = new Slideshow();
        ss.setScene(ssScene);

        //Initiate Controller for slideshow and pass reference to menu scene
        SlideshowController ssController = slideshowLoader.getController();
        ssController.setMenuScene(menuScene);
        ssController.setSlideshow(ss);

        KioskManager.setSS(ss);

        //Set Scene and Show Stage
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    public static Slideshow getSlideshow() {
        return slideshow;
    }
}
