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
    public static Map<String,StringBuilder> result = new HashMap();
    public static void main(String[] args) {
        String yahoo = "https://sg.search.yahoo.com/search?p=";
        String bing = "https://www.bing.com/search?q=";
        
            StringBuffer text = new StringBuffer("a b");
            String ysearch = yahoo + text.toString().replaceAll(" ", "+");
            String bsearch = bing + text.toString().replaceAll(" ", "+");
            Search yaho = new Search(ysearch);
            //yaho.start();
            Search bs = new Search(bsearch);
            bs.start();
    }
}
