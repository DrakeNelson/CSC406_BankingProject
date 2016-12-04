
package Master;

import DatabaseObjects.Customer;
import DatabaseObjects.Database;
import DatabaseObjects.TermLoan;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;

/**************************************************************************************************
 * CSC 406                                                                                        *
 * Banking Project GUI                                                                            *
 * Team 2: Austin, Shane, Nick, Darrian & Drake                                                   *
 * Program contains all functions necessary for the Fictional Bank to Operate                     *
 **************************************************************************************************/
public class Main extends Application {
    //the mastercontentpane is the container of the main window that will hold
    //the different windows as they are created
    public static ScrollPane MasterContentPane;
    static BorderPane root;
    static Stage window;
    public static Database database;
    private static Gson gson;
    public static Customer customer;
    //start at main :)
    //main class pretty much starts up the app
    //the basic plan is to use the root as a constant container for the app
    //with a bar that has methods in the controller
    //to switch the view of the MasterContentPane between different projects I work through
    public static void main(String[] args) {
        //instantiate the Gson Package
        gson = new Gson();
        Reader reader;
        try {
            //tell gson where to find the json file
            reader = new FileReader("Banking_Base_Data.json");
            //turn the json file into usable objects found in the DatabaseObjects package
            database = gson.fromJson(reader, Database.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (TermLoan loan : database.getTermLoans()) {
            loan.setOpenDate("10/01/2016");
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //the menu.fxml will hold the basic items of the home page
        //it will hold the menu bar and all of the items in it
        //the title header and subtitle at the top left of screen
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        //to run on close
        window.setOnCloseRequest(e -> {
            try {
                //format the gson in a way that can be read by people as well as the computer
                gson = new GsonBuilder().setPrettyPrinting().create();
                File file = new File("Banking_Base_Data.json");
                FileWriter w = new FileWriter(file);
                //overwrite the current database file with the new one created from the modified info
                gson.toJson(database, w);
                w.close();
            } catch (Exception shouldnthappen) {
                shouldnthappen.printStackTrace();
            }
            e.consume();
            window.close();
        });
        window.setTitle("CSC406 Banking Project Team 2");
        MasterContentPane = new ScrollPane();
        root.setCenter(MasterContentPane);
        //set the default size to w700 x h900
        window.setScene(new Scene(root, 900, 700));
        window.setResizable(true);
        window.sizeToScene();
        window.show();
        //right now i'm landing on the teller page on booting the program but this should change
        MasterController.landing();
    }
}
