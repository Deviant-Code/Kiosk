package manager;

import java.net.URL;
import com.google.gson.*;
import java.util.concurrent.TimeUnit.*;
import java.util.Timer; 
import java.util.TimerTask; 
import java.io.*;
import java.nio.channels.FileChannel;

public class AdminPortalListener{

    public static void main(String[] args) throws IOException{
        //try simpler method, lol
        try{
            while(true){
                //sleep for 10 sec
                Thread.sleep(1000 * 10);
                Listener();
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //in here, we call other methods every minute.
    public static void Listener() throws IOException{

        //call download all ness JSON files
        //not testing right now, gitlab is down.
        downloadAllJSON();

        //call checkJson to compare 2 modify times
        checkAllJSON();
        
        downloadImages();

        //other methods to update kiosk...

    }

    //this class will be used to eventually loop through and download all
    //needed JSON
    private static void downloadAllJSON(){

        try{
            downloadJSON("slideshow.json");
            //download more...
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    //takes as input a JSON name, and downloads that from the server.
    private static void downloadJSON(String fileName) throws IOException{
        //do internet stuff here.
        //localhosted first.

        URL link = new URL("http://localhost:3000/json/" + fileName);

        InputStream in = new BufferedInputStream(link.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf))){
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("temp" + fileName);
        fos.write(response);
        fos.close();

    }

    //checks all JSON using checkJSON.
    //if any check returns true, call further methods for updating
    //JSON. Otherwise, don't do anything. the file does not need updating.
    private static void checkAllJSON() throws IOException{

        if(checkJson("slideshow.json", "tempslideshow.json")){
            System.out.println("slideshow needs to be updated.");
            //if checkJson returned true, do below. else do nothing.

            replaceJSON("slideshow.json", "tempslideshow.json");

            //before parseJson, we need to call closeFile
            //closeFile(slideshow.json);
            //just closes the current JSON file, in case currently being read.
            
            //call parseJson to update Json here
            parseJSON("slideshow.json", "localslideshow.json");

            //call pullImages to pull any images not in folder
            
            //call deleteImages to delete images that were removed from file.
            //for this, we may need to store a file just for deleting things.
        }
        else{
            System.out.println("slideshow does not need to be updated.");
        }
        
        
    }




    //method to download any new images to the kiosk
    private static void downloadImages(){
        //File file = new File("slideshow.json");
        //make a gson object from the file
        Gson gson = new Gson();
        
        try{
            Slideshow slideshow = gson.fromJson(new FileReader("slideshow.json"), Slideshow.class);
            

            //loop through, get every image. if not in folder, download it.
            //System.out.println(slideshow.images.length);
            for(int i = 0; i < slideshow.images.length; i++){
                //make sure it does not exist first.
                String pictureName = slideshow.images[i].location.substring(8,slideshow.images[i].location.length());
                File tempFile = new File("slideshow/" + pictureName);

                if(!tempFile.exists()){
                    try{
                        URL link = new URL("http://localhost:3000/" + slideshow.images[i].location);

                        InputStream in = new BufferedInputStream(link.openStream());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1!=(n=in.read(buf))){
                            out.write(buf, 0, n);
                        }
                        out.close();
                        in.close();
                        byte[] response = out.toByteArray();

                        FileOutputStream fos = new FileOutputStream("slideshow/" + pictureName);

                        fos.write(response);
                        fos.close();
                    }
                    catch(IOException e){
                        System.out.println("file read error!" + e);
                        System.exit(1);
                    }

                    
                }

                
            }


        }
        catch(FileNotFoundException E){
            System.out.println("file: not found!");
            
            System.exit(1);
        }
        

    }

    public class Slideshow{
        Boolean moduleEnabled;
        int transitionSpeed;
        Boolean willTransition;
        Boolean autoPlayVideo;
        SImage[] images;
    }

    public class SImage{
        int seqNum;
        String location;
        long lastModified;
    }





    //this method replaces the local json with the one downloaded from server.
    //Only one file will remain on replace, so no need to worry about 
    //too many files.
    private static void replaceJSON(String oldFile, String newFile) throws IOException{
        File old = new File(oldFile);
        File replacement = new File(newFile);

        FileChannel source = null;
        FileChannel destination = null;

        try{
            source = new FileInputStream(replacement).getChannel();
            destination = new FileOutputStream(old).getChannel();
            destination.transferFrom(source, 0, source.size());
        } catch(IOException e){
           System.out.println("File cannot be copied\n" + e);
        }finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
            
            System.out.println("file copied successfully!");
        }

    }

    //compare two files modify times.
    //if file2 has a newer modify time, return true to update
    //else, return false.
    private static Boolean checkJson(String file1, String file2) {

        long modTime1 = new File(file1).lastModified();
        long modTime2 = new File(file2).lastModified();

        //if mod time less, it is older
        return (modTime1 < modTime2);
    }

    //parse out all objects in both files.
    //compare all objects in order.
    //if not a match, replace in with out object, and delete the appropriate image.
    //continue to next object.
    //when done, save new JSON to fileUpdateIn, close streams.
    private static void parseJSON(String fileUpdateIn, String fileUpdateOut){

        //UNFINISHED CODE!
        //depending on name of file, parse it out differently.
        //Gson gson = new Gson();        
        //obj = gson.fromJson(json, Object.class);
        
        //JsonParser jsonParser = new JsonParser();
        //JsonElement jsonTreeIn = parser.parse(new File(fileUpdateIn));
        //JsonElement jsonTreeOut = parser.parse(new File(fileUpdateOut));
/*
        if(jsonTree.isJsonObject()) {
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            //to get an element of the tree with given name
            JsonElement f1 = jsonObject.get("f1");
            //can parse further, and so on...
        }
*/
        //what we need: Cole's JSON tree, to build off of.
        //pull out every object for both trees, and compare them.
        //if changed, update the specific object in fileUpdateIn.
        //then parse back into json file.
        

    }

    //parse out input into java file, parse out output into java file,
    //update out with in data, save as fileupdateOut.
    private void parseSlideshow(String fileUpdateIn, String fileUpdateOut){
        //Gson gson = new Gson();

        //try(Reader reader = new FileReader(fileUpdateIn)){
            // Convert JSON File to Java Object
            //Staff staffIn = gson.fromJson(reader, Staff.class);
            //reader = new FileReader(fileUpdateOut);
            //Staff staffOut = gson.fromJson(reader, Staff.class);

            //print out to test it works
            //System.out.println(staffIn);
            //System.out.println(staffOut);

            //compare all objects in both. We want to update all, except location to image.
            //also, if it is a different image, download it here.

            //parse out settings, compare all
            //String inSettings = staffIn.get("settings").toString();

            //parse out image data as set of objects and compare.
            //String inImages = staffIn.get("images").toString();



            /*psuedo code:

            for(each object: staffIn){
                compare to staffOut
                if(notEqual){
                    update staffOut
                    if(new image){
                        download new image;
                        delete old image;
                    }
                    
                }
            }
            */




            //at the end, parse back into file
            //FileWriter writer = new FileWriter(fileUpdateOut);
            //gson.toJson(staffOut, writer);

        //}
        //catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

/*
    private  String readUrl(String urlString) throws Exception {
        BufferedReader br = null;
        try {
            URL url = new URL(urlString);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = br.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (br != null)
                br.close();
        }
    }
    
    //Grabs json from portal via URL to json file
    public Object getObject(String url) throws Exception {
        Object obj;
        try {
            String json = readUrl(url);
            Gson gson = new Gson();        
            obj = gson.fromJson(json, Object.class);
        } catch(Exception err) {
            obj = null;
        }
        return obj;
    }

    */

}

