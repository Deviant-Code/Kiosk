package modules;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.KioskManager;

import java.io.*;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Slideshow implements ModuleInterface{

    private int imageIndex;
    private short secondsPerImage = 5;
    private static String slideshowDirectory = "slideshow/"; //local directory used by adminportal listener
    private List<String> list;
    private Image activeImage;
    private File folder;
    private ImageView imageView;
    private Timer t;
    private boolean timerEnabled;

    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());


    //TODO: Move timer to separate event listener class and have it maintain scope of user activity and inactivity

    public Slideshow() {
        list = new ArrayList<>();
        Thread watchThread = new Thread(new WatchRunnable());
        watchThread.start();
    }

    //Initializes the pictures in slideshow
    public void init(ImageView imageView) {
        this.imageView = imageView;
        //Check for slideshow image directory
        validateDirectory();

        //Build Slideshow list from directory
        buildList();

        this.imageIndex = 0;
        activeImage = new Image(list.get(imageIndex));
        setImage();
    }

    public void update() {

        //Slideshow directory not found, reinitialize
        if(!folder.exists()){
            try {
                init(imageView);
            } catch (Exception e) {
                //TODO: Log exception with high severity
            }
            return;
        }

        list.clear();
        buildList();
    }

    @Override
    public void onWake() {
        update();
        setImage();
        startTimer();
    }

    @Override
    public void onSleep() {

    }

    @Override
    public void onShutdown() {

    }

    //Validates slideshow directory existence.
    //Tries to create if directory is missing and logs errors
    private void validateDirectory() throws Error {

        folder = new File(slideshowDirectory);

        if(!folder.exists()){
            if(folder.mkdirs()){
                //log folder created succesfully
                logr.log(Level.WARNING, "Slideshow Folder Not Found --> New Folder instantiated");
            } else {
                logr.log(Level.SEVERE, "Slideshow Folder Not Found --> Could not instantiate new folder");
            }
        }
    }

    //Builds slideshow in array list from files in declared directory
    private void buildList() {

        File[] listOfFiles = folder.listFiles();

        if(listOfFiles.length > 0){
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        String mimetype = Files.probeContentType(Paths.get(file.getPath()));
                        if(mimetype == null){
                            InputStream is = new BufferedInputStream(new FileInputStream(file));
                            mimetype = URLConnection.guessContentTypeFromStream(is);
                        }
                        String typeFormat[] = mimetype.split("/");
                        if(typeFormat[0].equals("image")){
                            list.add(file.getPath());
                        }
                    }catch(IOException e){
                        //file IO exception --skip file
                    }
                }
            }
        }

        if(list.size() == 0){
            //No pictures were added to slideshow. Add demo photo and log result //TODO: log result
            File file = new File("gallery_empty_img.jpg");
            if(file.exists()){
                list.add("/gallery_empty_img.jpg");
            } else {
                throw new Error("No files found for slideshow");
            }
        }
    }

    // Restarts the slideshow timer
    public void startTimer(){
        if(t != null){
            t.cancel();
            t.purge();
        }
        t = new Timer(true);
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                nextImage();
                setImage();
            }
        },(secondsPerImage*1000),(secondsPerImage*1000));
        timerEnabled = true;
    }

    public void cancelTimer(){
        if(t != null){
            t.cancel();
            t.purge();
        }
        timerEnabled = false;
    }

    public void setImage() {
        try {
            Image image = new Image(getImage());
            imageView.setImage(image);
        } catch(IllegalArgumentException E){
            logr.log(Level.WARNING, "Illegal Argument Exception attempting to load image: " + getImage());
            list.remove(imageIndex);
        }
    }

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

    public boolean isTimerEnabled() {
        return timerEnabled;
    }

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
                            update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)){
                        try {
                            update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}