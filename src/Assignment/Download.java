/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.HashSet;

/**
 *
 * @author caeden
 */
public class Download {
    public HashSet<String> result;
    public HashSet<String> downloaded;
    public HashSet<String> processing;
    public HashSet<String> downloadfail;
    
    public Download(){
        result = new HashSet();
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

    public HashSet<String> getResult(){
        return result;
    }
        
    public void startdownload(int a){
        for(String x:result){
            System.out.println(x);
        }
        
        
        
        
    }
    
}
