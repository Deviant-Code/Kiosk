package modules;

public class Department extends WebView implements ModuleInterface {

    private static final String URL = "http://localhost:3000/pages/kioskDepartment.html";

    public Department() {
        super(URL);
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
