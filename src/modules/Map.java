package modules;

/*
Map Module: An interactive map to show where faculty and rooms are located.
*/

public class Map extends WebView implements ModuleInterface {

    protected Map(String url) {
        super(url);
    }

    public void search(){}
    
    public void update(){
    }

    @Override
    public void onExit() {

    }

}