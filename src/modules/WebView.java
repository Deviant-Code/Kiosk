package modules;

/* Module Class for any javafx WebView based modules: currently, polls department and schedules

 */

public abstract class WebView implements ModuleInterface {

    private javafx.scene.web.WebView webView;
    private String url;

    protected WebView(String url) {
        this.webView = new javafx.scene.web.WebView();
    }

    protected void refresh(){
        webView.getEngine().load(url);
    }
}
