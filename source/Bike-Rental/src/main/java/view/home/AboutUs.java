package view.home;

import javafx.scene.input.MouseEvent;
import view.BaseContent;

import java.io.IOException;

public class AboutUs extends BaseContent {
    public AboutUs(String contentPath) throws IOException {
        super(contentPath);
    }

    public void close(MouseEvent mouseEvent) {
        getBaseScreen().removeChild(getContent());
    }
}
