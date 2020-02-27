package modules;

public class Polls extends WebView implements ModuleInterface {

    protected Polls(String url) {
        super(url);
    }

    @Override
    public void update() throws Exception {
        refresh();
    }

    @Override
    public void onExit() {
        refresh();
    }
}
