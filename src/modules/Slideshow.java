package modules;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Slideshow extends Module{

    private int imageIndex;
    private int secondsPerImage = 5;
    private static String slideshowDirectory = "slideshow/";
    private List<String> list;
    private Image activeImage;
    private File folder;
    private ImageView imageView;
    private Timer t;

    public class WatchRunnable implements Runnable {
        @Override
        public void run() {
            WatchService watchService = null;
            try {
                watchService = FileSystems.getDefault().newWatchService();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Path directory = Paths.get(slideshowDirectory);

            WatchKey watchKey = null;
            try {
                watchKey = directory.register(watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while(true) {
                for(WatchEvent<?> event : watchKey.pollEvents()){
                    if(event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)){
                        try {
                            Update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)){
                        try {
                            Update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public Slideshow(ImageView imageView) throws Exception {

        this.imageView = imageView; //Links imageview from scene to slideshow module
        list = new ArrayList<>();
        init();

        Thread watchThread = new Thread(new WatchRunnable());
        watchThread.start();
    }

    //Initializes the pictures in slideshow
    private void init() throws Exception {
        folder = new File( slideshowDirectory);
        if(!folder.exists()){
            throw new Exception("Slideshow src directory not found!");
        }

        DataFormat mimeAudio = new DataFormat("audio/*");
        DataFormat mimeVideo = new DataFormat("video/*");
        DataFormat mimeImage = new DataFormat("image/*");

        File[] listOfFiles = folder.listFiles();

        if(listOfFiles.length == 0){
            //No pictures in slideshow. Return to main menu... Print error
            list.add("/fxml/back.jpg");
        } else {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    //Check file type: Photo? Video?
                    if(Files.probeContentType(Paths.get(file.getPath())).equals(mimeImage)){
                    }

                    list.add(slideshowDirectory + file.getName());
                }
            }
        }

        this.imageIndex = 0;
        activeImage = new Image(list.get(imageIndex));
    }


    // Restarts the slideshow timer
    public void resume(){
        if(t != null){
            t.cancel();
            t.purge();
        }
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                nextImage();
                setImage();
            }
        },(secondsPerImage*1000),(secondsPerImage*1000));
    }

    //Pause timer for slideshow
    public void pause(){
        t.cancel();
        t.purge();
    }

    public void setImage() {
        try {
            Image image = new Image(getImage());
            imageView.setImage(image);
        } catch(IllegalArgumentException E){
            System.out.println("ERR" + " : " + getImage());
        }
    }

    public void playSlideshow(){}


    public String getImage() {
        return list.get(imageIndex);
    }

    public void nextImage() {
        if(imageIndex >= list.size()-1){
            imageIndex = 0;
        } else {
            imageIndex++;
        }
    }

    public void previousImage() {
        if(imageIndex==0){
            imageIndex = list.size()-1;
        } else {
            imageIndex--;
        }
    }

    @Override
    void Update() throws Exception {
        pause();

        list.clear();

        folder = new File( slideshowDirectory);
        if(!folder.exists()){
            throw new Exception("Slideshow src directory not found!");
        }

        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                list.add(slideshowDirectory + file.getName());
            }
        }

        this.imageIndex = 0;
        resume();
    }

}