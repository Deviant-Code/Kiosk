import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import manager.KioskManager;
import javafx.scene.Parent;

import modules.Slideshow;
import java.io.IOException;

public class MenuController {

    private Scene ssScene;
    private SlideshowController ssController;

    public void setSlideshowScene(Scene ssScene) {
        this.ssScene = ssScene;
    }

    @FXML
    public void openSlideShow(Event actionEvent) throws IOException {

        Slideshow ss = KioskManager.getSS();
        ss.updateSlides();
        ssController.setSlideshow(ss);

        ImageView imageView = (ImageView) ssScene.lookup("#ss_image_view");
        Image image = new Image(ss.getImage("CURRENT"));
        imageView.setImage(image);

        //Set Stage to slideshow
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        //Weird JavaFX bug requires toggle on full screen after swapping scenes
        //primaryStage.setFullScreen(false);
        primaryStage.setScene(ssScene);
        primaryStage.setFullScreen(true);

        ss.setTimer();

    }

    public void setSlideshowController(SlideshowController controller) {
        this.ssController = controller;
    }


}
