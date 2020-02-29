package modules;

import com.teamdev.jxbrowser.engine.RenderingMode;

public class Department extends WebViewModule implements ModuleInterface {

    private static final String URL = "http://localhost:3000/pages/kioskDepartment.html";

    public Department() {
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
