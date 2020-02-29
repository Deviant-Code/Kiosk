package modules;

import com.teamdev.jxbrowser.engine.RenderingMode;

public class Polls extends WebViewModule implements ModuleInterface {

    private static final String URL = "http://127.0.0.1:3000/pages/kioskPoll.html";

    public Polls() {
        super(URL, RenderingMode.OFF_SCREEN);
    }

    @Override
    public void update() throws Exception {

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
