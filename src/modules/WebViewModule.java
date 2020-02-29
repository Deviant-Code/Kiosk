package modules;

/*
Abstract Class governing web-dependent modules

Creates a browser instance given hardware rendering mode
    Modes: --HARDWARE_ACCELERATE = Extremely fast, but browser controls all touch events
           --OFF_SCREEN = Slower || Touch Events handled by java frame hierarchy
 */

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;


import static com.teamdev.jxbrowser.engine.RenderingMode.OFF_SCREEN;

public abstract class WebViewModule implements ModuleInterface {

    /* TODO: Possibly Deprecated
    //JavaFX WebView Implementation
    private WebView webView;
    private WebEngine engine;
    private String URL;*/

    //JxBrowser Implementation
    private Engine engine;
    protected Browser browser;
    private String URL;

    //Initilize new JxBrowser with or without hardware acceleration
    protected WebViewModule(String URL, RenderingMode mode)  {
        this.URL = URL;
        engine = Engine.newInstance(
                EngineOptions.newBuilder(mode)
                        .licenseKey("6P830J66YAIATYSTJKOJJ81M3H87FGDIIR8ZBEVV90ZSC79YB9PY16R9225BJK98R6UX")
                        .build());

        browser = engine.newBrowser();
        browser.navigation().loadUrl(URL);
    }

    public Browser getBrowser(){
        return this.browser;
    }

    public void reboot(){
        browser.close();
        browser = engine.newBrowser();
        browser.navigation().loadUrl(URL);
    }
}
