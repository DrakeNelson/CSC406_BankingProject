package Master;
/**
 * Controller for the MasterContentPane
 * contains methods used to set the MasterContentPane with a new Pane from the ContentPanes package
 * methods are set to click events for the menu bar in menu.fxml
 * Created by Drake Nelson 11/13/2016
 */

import ContentPanes.TestPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MasterController extends Master.Main {

    public BorderPane MasterBorderPane;
    public VBox MasterTitleVBox;
    public Label MasterLabel;
    public Label MasterProjectChoiceLabel;
    public MenuBar MasterMenuBar;

    //This is just a test of the controller to make sure my menu items are working properly
    public void TestPaneClick() {
        //reinitialize the master content pane so a new window can be set to it
        MasterContentPane = new StackPane();
        //change the title of the window
        window.setTitle("TestPaneTest");
        //add the new window to the mastercontentpane
        MasterContentPane.getChildren().add(new TestPane());
        //set it to the correct position
        root.setCenter(MasterContentPane);
    }

}
