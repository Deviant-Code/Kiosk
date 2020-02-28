package modules;

/* Department Schedules Module --> Extends the Webview class

   The Administrative portal maintains the schedules module via web page.
   TODO: cache the webpage and explore data solutions to keep track of local data for all webview modules
 */

public class Schedules extends WebView implements ModuleInterface{

    private static final String URL = "http://localhost:3000/pages/kioskSchedules.html";

    public Schedules() {
        super(URL);
    }

    public void update(){
        refresh();
    }

    @Override
    public void onWake() {

    }

    @Override
    public void onSleep() {

    }

    @Override
    public void onShutdown() {

    }


}