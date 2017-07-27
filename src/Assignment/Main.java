/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.*;
/**
 *
 * @author caeden
 */
public class Main {
    public static Download dl = new Download();
    //public static ArrayList<String> result = new ArrayList();
    public static void main(String[] args) throws InterruptedException {
        String yahoo = "https://sg.search.yahoo.com/search?p=";
        String bing = "https://www.bing.com/search?q=";
        
            StringBuffer text = new StringBuffer("ha");
            String ysearch = yahoo + text.toString().replaceAll(" ", "+");
            String bsearch = bing + text.toString().replaceAll(" ", "+");
            Search yaho = new Search(ysearch,dl);
            yaho.start();
            Search bs = new Search(bsearch,dl);
            bs.start();
            yaho.join();
            bs.join();
            
            dl.startdownload(1);
    }
}
