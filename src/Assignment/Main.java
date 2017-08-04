/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author caeden
 */
public class Main extends Application {
    //public static ArrayList<String> result = new ArrayList();
//    public static void main(String[] args) throws InterruptedException {
//        String yahoo = "https://sg.search.yahoo.com/search?p=";
//        String bing = "https://www.bing.com/search?q=";
//        
//        StringBuffer text = new StringBuffer("ha");
//        String ysearch = yahoo + text.toString().replaceAll(" ", "+");
//        String bsearch = bing + text.toString().replaceAll(" ", "+");
//        Search yahooSearch = new Search(ysearch,dl);
//        yahooSearch.start();
//        Search bingSearch = new Search(bsearch,dl);
//        bingSearch.start();
//        yahooSearch.join();
//        bingSearch.join();
//            
//        dl.startdownload(2);
//    }
    
    public void start(Stage primaryStage) throws IOException {
       
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(btn2);
        
//        Scene scene = new Scene(root, 300, 250);
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Web Crawler by Francis & Fengye");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        launch(args);
    }
}
