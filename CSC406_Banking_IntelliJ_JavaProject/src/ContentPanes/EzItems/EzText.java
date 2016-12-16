package ContentPanes.EzItems;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Created by user on 11/26/2016.
 * DONE
 */
public class EzText extends Text {
    public EzText(String x) {
        setText(x);
        setFill(Color.web("#B8D4EF", 1.0));
    }
}