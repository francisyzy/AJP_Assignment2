/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import static Assignment.SearchInput.dl;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * 
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("initialized");
        //StartLocationSearchBtn.setOnAction(e -> ImportData.SearchBusStop(StartLocationSearchInput.getText()));
        
//        String userSearch;
        
        searchBtn.setOnAction((ActionEvent e) -> {
            listOutput.setPlaceholder(new Label("No Content In List"));
            listOutput.setItems(null);//?
            
            dl.result.clear();
            
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
                ArrayList<String> resultHTML = dl.getResult();
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
                int index = result.indexOf(newVal);
                System.out.println("ID of the url they selected " + index);
                String url = dl.getHTML(index);
                //String url = FXMLController.class.getResource("URL0.html").toExternalForm();
                WebEngine engine = viewWeb.getEngine();
                engine.load(url);
                
            }         
        });
//        
////        if(EndLocationCombo.selectionModelProperty() != null){
////            System.out.println("end combo box selected");
////        }
//        
//        System.out.println(EndLocationCombo.getValue());
//
//        
//        EndLocationCombo.valueProperty().addListener(new ChangeListener<BusStop>() {
//            @Override 
//            public void changed(ObservableValue ov, BusStop t, BusStop t1) {
//                //System.out.println(ov);
//                //System.out.println(t);
//                endstop = t1; 
//                //EndDesc = t1;
//                //System.out.println(t1);
////                System.out.println("changed");//debug purposes
//                
//                Result.setItems(null);
//                
//                if(startstop != null){
//                    ObservableList<Transfer> transfers = FXCollections.observableArrayList();
//                    try {
//                        transfers = Transfers(startstop, endstop);
//                        
//                        if(transfers.size() == 0)
//                            ListOutput.setItems(noresult);
//                        else{
////                            System.out.println("setting items");//debug purposes
////                            System.out.println(transfers);//debug purposes
//                            Result.setItems(transfers);//set combobox values
//                            ListOutput.setItems(update);//to clear ListView of its previous outputs
//                        }
//                    } catch (NullPointerException e) {
//                        ListOutput.setItems(noresult);
////                        System.out.print("Caught the NullPointerException");//debug purposes
//                    }
//                    
////                    detecting if transfers is null doesnt work
////                    if (Transfers(startstop, endstop) != null) {
////                        transfers = Transfers(startstop, endstop);
////                    
////                        System.out.println("setting items");
////                        System.out.println(transfers);
////                        Result.setItems(transfers);
////                    }else
////                        Result.setItems(noresult);ya
//
//                    
//                }
//            }
//        });//End of endlocationcombo
//        
//        StartLocationCombo.valueProperty().addListener(new ChangeListener<BusStop>() {
//            @Override 
//            public void changed(ObservableValue ov, BusStop t, BusStop t1) {
//                //\System.out.println(ov);
//                //System.out.println(t);
//                startstop = t1;
//                //StartDesc = t1;
//                //System.out.println(t1);
////                System.out.println("changed");//debug purposes
//                
//                Result.setItems(null);
//                //duplicate from end location combo
//                if(endstop != null){
//                    ObservableList<Transfer> transfers = FXCollections.observableArrayList();
//                    try {
//                        transfers = Transfers(startstop, endstop);
//                        
//                        if(transfers.size() == 0)
//                            ListOutput.setItems(noresult);
//                        else{
////                            System.out.println("setting items");//debug purposes
////                            System.out.println(transfers);//debug purposes
//                            Result.setItems(transfers);//set combobox values
//                            ListOutput.setItems(update);//to clear ListView of its previous outputs
//                        }
//                    } catch (NullPointerException e) {
//                        ListOutput.setItems(noresult);
////                        System.out.print("Caught the NullPointerException");//debug purposes
//                    }
////                    detecting if transfers is null doesnt work
////                    if (Transfers(startstop, endstop) != null) {
////                        transfers = Transfers(startstop, endstop);
////                    
////                    System.out.println("setting items");
////                    System.out.println(transfers);
////                    Result.setItems(transfers);
////                    }else
////                        Result.setItems(noresult);
//                    
//                }
//            }
//        });//end of start location combo
//       
//        
//        Result.valueProperty().addListener(new ChangeListener<Transfer>() {
//            @Override 
//            public void changed(ObservableValue ov, Transfer t, Transfer t1) {
//                //System.out.println(ov);
//                //System.out.println(t);
////                System.out.println(t1);//debug purposes
////                System.out.println("changed");//debug purposes
//                double tdis = 0;
//                int tstop = 0;
//                ObservableList<String> toListView = FXCollections.observableArrayList();
//                ListOutput.setItems(update);
//                try{
//                    for (Route r : t1.routes) {
//                        toListView.add(r.startPoint.BusStopDescription);
//                        toListView.add(r.endPoint.BusStopDescription);
//                        toListView.add("Bus Number: " + r.busNo);
//                        toListView.add("Distance Travelled: " + new DecimalFormat("#.##").format(r.distance) + "km");
//                        toListView.add("Stops on bus: " + (r.r.size()-1)+ " stops");
//                        toListView.add("\n");
//
//                        tdis += r.distance;
//                        tstop += r.r.size() - 1;
//
////                        System.out.println(toListView);//debug purposes
//                    }
//
//                    toListView.add("Total distance: " + new DecimalFormat("#.##").format(tdis));
//                    toListView.add("Total stops: " + tstop);
//                    ListOutput.setItems(toListView);
//                     //Works need better UI now
//                }catch(NullPointerException e) {
////                    System.out.print("Caught the NullPointerException for Output");//debug purposes
//                }
//
//
//            }
//        });//end of result location combo
//        
//        
//        shortestRoute.setOnAction((ActionEvent e) -> {
//            Graph graph = new Graph(ImportData.busStops,ImportData.edges);
//            Dijk dijkstra = new Dijk(graph);
//            dijkstra.execute(startstop);
//            LinkedList<Edge> path = dijkstra.getPath(endstop);
//            double tdis = 0;
//            int tstop = 0;
//            String busn = "aaa";
//            String laststop = "aaa";
//            ObservableList<String> toListView = FXCollections.observableArrayList();
//            int i = 0;
//            try{
//                toListView.add(startstop.BusStopDescription);
//                for (Edge r : path) {
//                    if((!(busn.equals(r.getNo())))&&( i != 0))
//                        toListView.add(" take " + busn + " to " + laststop);
////                      toListView.add("\n");
//
//                    tdis += r.getWeight();
//                    tstop ++;
//                    busn = r.getNo();
//                    laststop = r.getDestination().BusStopDescription;
//                    i++;
//                }
//                toListView.add(" take " + busn + " to " + laststop);
//                toListView.add("Total distance: " + new DecimalFormat("#.##").format(tdis) + " km");
//                toListView.add("Total stops: " + tstop);
//                 //Works need better UI now
//                ListOutput.setItems(toListView);
//            }catch(NullPointerException x) {
////                System.out.print("Caught the NullPointerException for Output");//debug purposes
//            }
//            
//            
//        });//end of button
//        
//        SearchBusServiceBtn.setOnAction((ActionEvent e) -> { //output is bus service, input is bus stop
//            SearchBusService.clear();
//            try {
//                Search = SearchBusStop(SearchBusServiceInput.getText());
//            } catch (Exception ex) {
//                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            for(BusStop b : Search){
//                //System.out.println(b.BusStopDescription);
//                SearchBusService.add(b);
//            }
//            SearchBusServiceCombo.setItems(SearchBusService);
//        });
//        
//        SearchBusServiceCombo.valueProperty().addListener(new ChangeListener<BusStop>() { //output is bus service, input is bus stop
//            @Override 
//            public void changed(ObservableValue ov, BusStop t, BusStop t1) {
//                //\System.out.println(ov);
//                //System.out.println(t);
//                //StartDesc = t1;
//                //System.out.println(t1);
////                System.out.println("changed");//debug purposes
//                
//                
//                try{
//                    ObservableList<String> resultstring = FXCollections.observableArrayList(t1.GetBusNos());
//                    SearchBusServiceList.setItems(resultstring);
//                }catch(NullPointerException e) {
////                    System.out.print("Caught the NullPointerException for Output");//debug purposes
//                }
//            }
//        });//end of SearchBusServiceCombo
//        
//        //________________________________________________________________________
//        
//        SearchBusStopBtn.setOnAction((ActionEvent e) -> { //input is bus service, output is bus stop
//            SearchBusStop.clear();
//            try {
//                SearchB = SearchBusNo(SearchBusStopInput.getText());
//            } catch (Exception ex) {
//                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            for(BusNo b : SearchB){
//                //System.out.println(b.BusStopDescription);
//                SearchBusStop.add(b);
//            }
//            SearchBusStopCombo.setItems(SearchBusStop);
//        });
//        
//        SearchBusStopCombo.valueProperty().addListener(new ChangeListener<BusNo>() { //input is bus service, output is bus stop
//            @Override 
//            public void changed(ObservableValue ov, BusNo t, BusNo t1) {
//                //\System.out.println(ov);
//                //System.out.println(t);
//                //StartDesc = t1;
//                //System.out.println(t1);
////                System.out.println("changed");//debug purposes
//                try{
//                    ObservableList<BusService> resultstring = FXCollections.observableArrayList(t1.GetBusService());
//                    SearchBusStopList.setItems(resultstring);
//                }catch(NullPointerException e) {
////                    System.out.print("Caught the NullPointerException for Output");//debug purposes
//                }
//            }
//        });//end of SearchBusStopCombo
                
        
    }//end of method
    
    
//    public static ObservableList<BusStop> SearchBusStop(String SearchInput){
//        ObservableList<BusStop> results = FXCollections.observableArrayList();
//        System.out.println("Search Bus Stop Input " + SearchInput);
//        for (BusStop b : busStops) {
//            if(((b.BusStopDescription).toUpperCase()).contains(SearchInput.toUpperCase())){ //search ignore caps
//                //System.out.println("Method Search BusStop Output Debug" + b.BusStopDescription);
//                results.add(b);
//            }
//        }
//        //System.out.println(results.toString() + " Method check results debug");
//        return results;
//    }
//    
//    public static ObservableList<BusNo> SearchBusNo(String SearchInput){
//        ObservableList<BusNo> results = FXCollections.observableArrayList();
//        System.out.println("Search Bus No Input " + SearchInput);
//        for (BusNo b : busNos) {
//            if((b.busNo).toUpperCase().contains(SearchInput.toUpperCase())){ //search ignore caps
//                //System.out.println("Method Search SearchBusStop Output Debug" + b.busNo);
//                results.add(b);
//            }
//        }
//        //System.out.println(results.toString() + " Method check results debug");
//        return results;
//    }
//    
//    
//    public static ObservableList<Transfer> Transfers(BusStop s, BusStop e){
//        ArrayList<Route> routes = new ArrayList<>();
//        
//        ObservableList<Transfer> trans = FXCollections.observableArrayList();
//        ArrayList<String> bsnadded = new ArrayList<>();
//        
//        for (String n : s.GetBusNos()) {
//            if(e.GetBusNos().contains(n)){
//                routes.add(new Route(s,e,n));
//                Transfer r = new Transfer(routes);
//                trans.add(r);
//                bsnadded.add(n);
//                routes = new ArrayList<>();
//            }
//        }
//        
//        for (String n : s.GetBusNos()) {
//            if(!(bsnadded.contains(n))){
//                for (BusStop bs : ImportData.bsnoMap.get(n)) {
//                    for (String m : bs.GetBusNos()) {
//                        if((!(bsnadded.contains(m)))&&(e.GetBusNos().contains(m))){
//                            try{
//                            routes.add(new Route(s,bs,n));
//                            routes.add(new Route(bs,e,m));
//                            Transfer r = new Transfer(routes);
//                            trans.add(r);
//                            bsnadded.add(n);
//                            routes = new ArrayList<>();
//                            }catch(Exception ex){
//                                routes = new ArrayList<>();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        
//        
//        
//        /*for (BusStop bs : ImportData.busStops) {
//            for(String m : bs.GetBusNos()){
//                if((!(bsnadded.contains(m)))&&(s.GetBusNos().contains(m)))
//                    for(String l : bs.GetBusNos()){
//                        if((!(bsnadded.contains(l)))&&(e.GetBusNos().contains(l))){
//                            routes.add(new Route(s,bs,m));
//                            routes.add(new Route(bs,e,l));
//                            Transfer r = new Transfer(routes);
//                            trans.add(r);
//                            routes = new ArrayList<>();
//                        }
//                    }
//            }
//        }*/
//        System.out.println("transfer method ran");
//        
////        System.out.println(trans);//debug purposes
//        
//        return trans;
//    }
    
    
}
