/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author caeden
 */
public class Download {
    private ArrayList<String> result;//list of all URL downloaded
    private ArrayList<String> htmlList;//list of all HTML downloaded
    private HashMap<String,String> urlMap = new HashMap<>();
    private long starttime;
    
    public Download(){
        result = new ArrayList();
        htmlList = new ArrayList();
        for (int i = 0; i < 10; i++) {
        htmlList.add("");
        }
    }
    
    public synchronized void addresult(String url){
        result.add(url);
    }
    
    public boolean checknum(){
        if (result.size()< 10)
            return true;
        else
            return false;
    }

    public ArrayList<String> getResult(){
        return result;
    }
        
    public void startdownload(int a) throws InterruptedException{
        for(String x:result){
            System.out.println(x);
        }
        
        ThreadPool threadPool = new ThreadPool(10,a);
        
        for(int taskNumber = 0 ; taskNumber <= 9; taskNumber++) {
            Save task = new Save(taskNumber);
            threadPool.submitTask(task);
            
        }
        
    }
    
    public String getURL(int index){
        return result.get(index);
    }
    
    public void addHTML(String html){
        htmlList.add(html);
    }
    
    public String getHTML(int index){
        return htmlList.get(index);
    }
    
    public void setHtml(int index,String html){
        //htmlList.add(index, html);
        htmlList.set(index, html);
    }
    
    public void putMap(String url,String html){
        urlMap.put(url, html);
    }
    
    public String getMapValue(String url){
        return urlMap.get(url);
    }
    
    public boolean checkMapnum(){
        if (urlMap.size() == 10)
            return true;
        else
            return false;
    }
    
    public void stopTime() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("FXML.fxml").openStream());
        FXMLController fooController = (FXMLController) fxmlLoader.getController();
        
        fooController.StopTime();
    }
    
    
    
    public double getTime(){
        double time = (System.currentTimeMillis() - this.starttime)/1000;
        
        return time;
    }
    
    public void clearResult(){
        result.clear();
    }
    
    public void SetStartTime(){
        starttime = System.currentTimeMillis();
    }
    public void ClearMap(){
        urlMap.clear();
    }
}
