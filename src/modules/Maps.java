package modules;

/*
Map Module: An interactive map to show where faculty and rooms are located.
*/

public class Maps extends WebView implements ModuleInterface {

    private static final String URL = "http://localhost:3000/pages/kioskMap.html";

    public Maps() {
        super(URL);
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