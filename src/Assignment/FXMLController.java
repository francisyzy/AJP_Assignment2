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
    
//    public void SetStartTime(){
//        startTime = System.currentTimeMillis();
//    }
//    
//    public long GetStartTime(){
//        return startTime;
//    }
//    
//    public void StopTime(){
//        double timetaken = (System.currentTimeMillis() - GetStartTime())/1000;
//        
//        timeOutput.setText(timetaken+"");
//    }
    
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
        
        System.out.println(checkBing.isSelected());
        
        System.out.println(checkGoogle.isSelected());
        
        searchBtn.setOnAction((ActionEvent e) -> {
            listOutput.setPlaceholder(new Label("No Content In List"));
            //listOutput.setItems(null);//?
            
            dl.clearResult();
            
            String UserSearch = null;
            int threadCount = 0;
            
            if(searchInput.getText()==null){
                JOptionPane.showMessageDialog(null, "Please enter something in the search field");
            }else if(threadInput.getText()==null){
                JOptionPane.showMessageDialog(null, "Please enter something in the thread field");
            }else{
                UserSearch = searchInput.getText();
                threadCount = Integer.parseInt(threadInput.getText());
                System.out.println("Search = " + UserSearch);
                System.out.println("Thread Count = " + threadCount);
                SetUserSearch(UserSearch);
//                SetStartTime();//Time taken
            }
            
            SearchInput search = new SearchInput();
            
            try {
                search.startSearch(UserSearch, threadCount);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            
//            for(BusStop b : Search){
//                //System.out.println(b.BusStopDescription);
//                startresult.add(b);
//            }
            ArrayList<String> result = dl.getResult();
            Collections.sort(result); //to sort in accending order
            ObservableList<String> observableResult = FXCollections.observableArrayList(result); //convert the arraylist to obversable list
            listOutput.setItems(observableResult);
        });
        
//        EndLocationSearchBtn.setOnAction((ActionEvent e) -> {
//            //System.out.println(EndLocationCombo.getValue());
//            endresult.clear();
//            try {
//                Search = SearchBusStop(EndLocationSearchInput.getText());
//            } catch (Exception ex) {
//                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            for(BusStop b : Search){
//                //System.out.println(b.BusStopDescription);
//                endresult.add(b);
//            }
//            EndLocationCombo.setItems(endresult);
//        });
//        
//        
//        //System.out.println("btnMapPressed")
//        
//        //Adding press link to map but nevermind no time do
        MultipleSelectionModel<String> listOutputSel = listOutput.getSelectionModel();
//        listOutputSel.selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue ov, BusStop oldVal, BusStop newVal)
//            {
//                System.out.println("You selected " + newVal);
//            }        
//
//            @Override
//            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
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
                
                Pattern userSearch_REGEX = Pattern.compile("("+GetUserSearch()+")", Pattern.CASE_INSENSITIVE);
                
                Matcher userSearchMatcher = userSearch_REGEX.matcher(url);
                
                int output = 0;
                
                while (userSearchMatcher.find()) {
                    output++;
                }
                
                textOutput.setText(Integer.toString(output));
                timeOutput.setText(SearchInput.dl.getStopTime()+"");
                
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
