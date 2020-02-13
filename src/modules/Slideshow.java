package modules;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Slideshow extends Module{

    private int imageCount;
    private int imageIndex;
    private int secondsPerImage = 5;
    private List<String> list = new ArrayList<>();
    private Image activeImage;
    private String imageFolder = "slideshow/";
    private Timer timer;
    private Scene scene;

    public Slideshow() throws IOException {

        //Stupid IDE issue temp fix
        File folder = new File(imageFolder);
        if(!folder.exists()){
            folder = new File("src/" + imageFolder);
        }

        DataFormat mimeAudio = new DataFormat("audio/*");
        DataFormat mimeVideo = new DataFormat("video/*");
        DataFormat mimeImage = new DataFormat("image/*");

        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                //Check file type: Photo? Video?
                if(Files.probeContentType(Paths.get(file.getPath())).equals(mimeImage)){
                    System.out.println("YP");
                }

                list.add(imageFolder + file.getName());
            }
        }

        this.imageIndex = 0;
        this.imageCount = list.size();

        //Image image = new Image(list.)
        activeImage = new Image(list.get(imageIndex));

        ActionListener timerInterrupt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageView imageView = (ImageView) scene.lookup("#ss_image_view");
                Image image = new Image(getImage("FORWARD"));
                imageView.setImage(image);
            }
        };

        this.timer = new Timer(secondsPerImage*1000,timerInterrupt);

    }
    
    public void PlaySlideshow(){}
    public void PauseSlideshow(){}
    
    void Update(){
    }

    void resume(){

    }

    public String getImage(String MOVE) {
        switch(MOVE){
            case "FORWARD":
                if(imageIndex == imageCount-1){
                    imageIndex = 0;
                } else {
                    imageIndex++;
                }
                break;
            case "BACKWARD":
                if(imageIndex == 0){
                    imageIndex = list.size()-1;
                } else {
                    imageIndex--;
                }
                break;
        }
        return list.get(imageIndex);
    }

    public void setTimer() {
        this.timer.restart();

    }

    public void setScene(Scene ssScene) {
        this.scene = ssScene;
    }

    public void updateSlides(){
        //Stupid IDE issue temp fix
        File folder = new File(imageFolder);
        if(!folder.exists()){
            folder = new File("src/" + imageFolder);
        }

        list.clear();
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                list.add(imageFolder + file.getName());
            }
        }

        this.imageIndex = 0;
        this.imageCount = list.size();

    }

}