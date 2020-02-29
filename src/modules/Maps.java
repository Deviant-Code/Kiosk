package modules;

/*
Map Module: An interactive map to show where faculty and rooms are located.
*/

import com.teamdev.jxbrowser.engine.RenderingMode;

public class Maps extends WebViewModule implements ModuleInterface {

    private static final String URL = "http://localhost:3000/pages/kioskMap.html";

    public Maps() {
        super(URL, RenderingMode.HARDWARE_ACCELERATED);
    }

    public void search(){}
    
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