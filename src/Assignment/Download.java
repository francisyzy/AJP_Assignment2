/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author caeden
 */
public class Download {
    public ArrayList<String> result;
    public HashSet<String> downloaded;
    public HashSet<String> processing;
    public HashSet<String> downloadfail;
    
    public Download(){
        result = new ArrayList();
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
    
    
    
}
