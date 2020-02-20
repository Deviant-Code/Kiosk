package modules;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.*;
import java.net.URLConnection;
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
    private boolean isPaused;

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

    public Slideshow(ImageView imageView) throws Exception {
        this.imageView = imageView; //Links imageview from scene to slideshow module
        list = new ArrayList<>();
        init();
        Thread watchThread = new Thread(new WatchRunnable());
        watchThread.start();
    }

    public Slideshow() {

    }

    //Initializes the pictures in slideshow
    private void init() throws Exception {

        //Check for slideshow image directory
        validateDirectory();

        //Build Slideshow list from directory
        buildList();

        this.imageIndex = 0;
        activeImage = new Image(list.get(imageIndex));
    }

    @Override
    public void update() throws Exception {
        pause();

        //Slideshow directory not found, reinitialize
        if(!folder.exists()){
            init();
            return;
        }

        list.clear();
        buildList();

        this.imageIndex = 0;
        resume();
    }

    //Validates slideshow directory existence.
    //Tries to create if directory is missing and logs errors
    private void validateDirectory() throws Error {

        folder = new File(slideshowDirectory);

        if(!folder.exists()){
            if(folder.mkdirs()){
                //log folder created succesfully
                System.out.print("Folder created");
            } else {
                throw new Error("Slideshow directory could not be found or created");
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
            File file = new File("fxml/back.jpg");
            if(file.exists()){
                list.add("/fxml/back.jpg");
            } else {
                throw new Error("No files found for slideshow");
            }
        }
    }

    // Restarts the slideshow timer
    public void resume(){
        isPaused = false;
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
    }

    //Pause timer for slideshow
    public void pause(){
        isPaused = true;
        if(t != null){
            t.cancel();
            t.purge();
        }
    }

    public void setImage() {
        try {
            Image image = new Image(getImage());
            imageView.setImage(image);
        } catch(IllegalArgumentException E){
            System.out.println("ERR" + " : " + getImage());
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

    public boolean isPaused() {
        return isPaused;
    }

}