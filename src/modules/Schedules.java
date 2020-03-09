package modules;

/* Department Schedules Module --> Extends the Webview class

   The Administrative portal maintains the schedules module via web page.
   TODO: cache the webpage and explore data solutions to keep track of local data for all webview modules
 */

import com.teamdev.jxbrowser.engine.RenderingMode;

public class Schedules extends WebViewModule implements ModuleInterface{

    private static final String URL = "http://localhost:3000/pages/kioskSchedules.html";

    public Schedules() {
        super(URL, RenderingMode.OFF_SCREEN);
    }

    public void update(){
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