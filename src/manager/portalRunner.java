package manager;

//main tester for running admin code

//include the admin portal in here
import manager.AdminPortalListener;
//include("AdminPortalListener.class");
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class portalRunner{

    public portalRunner(){

    }

    public static void run(){
        //try simpler method, lol
        try{
            while(true){
                //sleep for 10 sec
                Thread.sleep(1000 * 10);
                AdminPortalListener.Listener();
            }
        }
        catch(InterruptedException | IOException e){
            e.printStackTrace();
        }


    }

    
}