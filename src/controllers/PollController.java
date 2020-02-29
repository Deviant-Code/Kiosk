package controllers;

import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import modules.Polls;
import utilities.GestureHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class PollController implements Initializable {

    private final String URL = "http://127.0.0.1:3000/pages/kioskPoll.html";

    private GestureHandler gestureHandler = GestureHandler.getInstance();

    @FXML
    private StackPane webViewContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Polls poll = new Polls();
        BrowserView browserView = BrowserView.newInstance(poll.getBrowser());
        webViewContainer.getChildren().addAll(browserView);

        //browser.set(MouseEvent.DRAG_DETECTED.class -> Response.suppress())
        /* webViewContainer.getChildren().add(browserView);
        WebView webView = new WebView();
        WebEngine web = webView.getEngine();
        web.setJavaScriptEnabled(true);
        webView.setPrefSize(1920,1080);
        web.executeScript("location.reload(true);");
        webViewContainer.getChildren().add(webView);
        web.load(URL);*/
    }

}
