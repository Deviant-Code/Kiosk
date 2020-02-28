package modules;

public class Polls extends WebView implements ModuleInterface {

    private static final String URL = "http://127.0.0.1:3000/pages/kioskPoll.html";

    public Polls() {
        super(URL);
    }

    @Override
    public void update() throws Exception {
        refresh();
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
