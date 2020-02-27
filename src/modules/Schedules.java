package modules;

/* Department Schedules Module --> Extends the Webview class

   The Administrative portal maintains the schedules module via web page.
   TODO: cache the webpage and explore data solutions to keep track of local data for all webview modules
 */

public class Schedules extends WebView implements ModuleInterface{

    protected Schedules(String url) {
        super(url);
    }

    public void update(){
        refresh();
    }

    @Override
    public void onExit() {
        refresh();
    }

}