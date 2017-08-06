/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import static Assignment.SearchInput.dl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;


/**
 * FXML Controller class
 *
 * @author francisyzy
 */
public class FXMLController implements Initializable {

    @FXML
    Button searchBtn;
    @FXML
    TextField searchInput;
    @FXML
    CheckBox checkBing; 
    @FXML
    CheckBox checkYahoo;
    @FXML
    CheckBox checkGoogle;
    @FXML
    ListView listOutput;
    @FXML
    WebView viewWeb;
    @FXML
    Button threadSetBtn;
    @FXML
    TextField threadInput;
    @FXML
    TextArea rawHTML;
    @FXML
    TextField textOutput;
    @FXML
    TextField timeOutput;
    @FXML
    TextField errorOutput;

    /**
     * 
     * 
     * Initializes the controller class.
     */
    
    private String userSearch;
    private Long startTime;
    
    public void SetUserSearch(String userSearchIn){
        userSearch = userSearchIn;
    }
    
    public String GetUserSearch(){
        return userSearch;
    }
    
    public void Timer(Double timetaken){
        System.out.println("Timer method ran");
        timeOutput.setText(timetaken+"");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("initialized");
        //StartLocationSearchBtn.setOnAction(e -> ImportData.SearchBusStop(StartLocationSearchInput.getText()));
        
//        String userSearch;
        
        searchBtn.setDefaultButton(true);
        
        searchBtn.setOnAction((ActionEvent e) -> {
            listOutput.setPlaceholder(new Label("No Content In List"));
            rawHTML.setText(null);
            timeOutput.setText(null);
            viewWeb.getEngine().load(null);
            listOutput.setItems(null);
            dl.clearResult();
            //clearing previous result if any
            
            //debug
            System.out.println("Bing = " + checkBing.isSelected());

            System.out.println("Yahoo = " + checkYahoo.isSelected());

            System.out.println("Google = " + checkGoogle.isSelected());
            
            String UserSearch = null;
            int threadCount = 0;
            
            errorOutput.setText("");
            
            if(searchInput.getText().isEmpty()){
                errorOutput.setText("Please enter something in the search field");
                //JOptionPane.showMessageDialog(null, "Please enter something in the search field");//causes crash
            }else if(threadInput.getText().isEmpty()){
                errorOutput.setText("Please enter something in the thread field");
                //JOptionPane.showMessageDialog(null, "Please enter something in the thread field");//causes crash
            }else if(! (checkYahoo.isSelected() || checkBing.isSelected() || checkGoogle.isSelected())){
                errorOutput.setText("Please select an search engine");
                //JOptionPane.showMessageDialog(null, "Please select an search engine");//causes crash
            }else{
                System.out.println(searchInput.getText());
                UserSearch = searchInput.getText();
                threadCount = Integer.parseInt(threadInput.getText());
                System.out.println("Search = " + UserSearch);
                System.out.println("Thread Count = " + threadCount);
                SetUserSearch(UserSearch);
                SearchInput search = new SearchInput(checkYahoo.isSelected(),checkBing.isSelected(), checkGoogle.isSelected());
            
                try {
                    search.startSearch(UserSearch, threadCount);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //1)	The 10 website URLs and its html page contents (saved locally) should be shown to the user through a GUI (For example, after clicking on a selected URL, the web page content will be shown in a text area). The website URLs are to be displayed in a list in ascending order.
                
                ArrayList<String> result = dl.getResult();
                Collections.sort(result); //to sort in accending order
                ObservableList<String> observableResult = FXCollections.observableArrayList(result); //convert the arraylist to obversable list
                listOutput.setItems(observableResult);
                System.out.println(observableResult+"Result");
//                SetStartTime();//Time taken
            }
//            for(BusStop b : Search){
//                //System.out.println(b.BusStopDescription);
//                startresult.add(b);
//            }
            
        });
        
        MultipleSelectionModel<String> listOutputSel = listOutput.getSelectionModel();

        listOutputSel.selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal)
            {
                System.out.println  ("You selected " + newVal);
                ArrayList<String> result = dl.getResult();
                Collections.sort(result); //to sort in accending order
                //ArrayList<String> resultHTML = dl.getResult();
//                for(int i = 0; i<=result.size();i++){
//                    if(newVal.compareTo())){
//                        
//                    }
//                }
//                for (String element : result) {
//                    if (String.equals(element)) {
//                        found = true;
//                        break;
//                    }
//                }
                //int index = result.indexOf(newVal);
                //System.out.println("ID of the url they selected " + index);
                
                //System.out.println("sorting");
                ///dl.sortHTML();//so the id same!!!
                //sorting error idk why since the ID never line up the selected resource ≠ to the displayed raw HTML
                String url = dl.getMapValue(newVal);
                //String url = FXMLController.class.getResource("URL0.html").toExternalForm();
                viewWeb.getEngine().load(newVal);
                rawHTML.setText(url);
                
                System.out.println("User Search = " + GetUserSearch());
                
                //10)	Keep track of the number of occurrences of the search phrase within the html page and display the number of occurrences. 

                try{
                        Pattern userSearch_REGEX = Pattern.compile("("+GetUserSearch()+")", Pattern.CASE_INSENSITIVE);
                
                        Matcher userSearchMatcher = userSearch_REGEX.matcher(url);
                        int output = 0;

                        while (userSearchMatcher.find()) {
                            output++;
                        }
                        
                        textOutput.setText(Integer.toString(output));
                    }catch(Exception e){
                        System.out.println("Caught exception");
                    }
                
                timeOutput.setText(SearchInput.dl.getStopTime()+"s");
                
                //debug
                //System.out.println(url);
                
                //debug stuff below
//                FileReader file;
//                try {
//                    file = new FileReader("URL0.html");
//                    BufferedReader reader = new BufferedReader(file);
//                    String line = reader.readLine();
//                    while ((line = reader.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
            }         
        });    
    }//end of method
    
}
