/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.lang.StringBuffer;
import java.util.*;
import java.util.regex.*;
/**
 *
 * @author caeden
 */
public class Search extends Thread { 
    
    public static Download dl;
    public String url;
    private static final Pattern BING_REGEX = Pattern.compile("result\"><h3 class=\"title\"><a href=\"(.+?)\" class=\"\">");
    private static final Pattern YAHOO_REGEX = Pattern.compile("class=\"b_algo\"><h2><a href=\"(.+?)\" h=\"");
    private static final Pattern URL_REGEX = Pattern.compile("<a[^>]+href=\"(http.+?)\"");
    
    public  Search(String url){
        this.url = url;
    }
    
    public  Search(String url,Download d){
        this.url = url;
        dl = d;
    }
    
    
        public static void main(String[] args) {
            String yahoo = "https://sg.search.yahoo.com/search?p=";
            String text = "a b";
            String url = yahoo + text.replaceAll(" ", "+");
            
            System.out.println(PageRead.readPage(url));
        }
        
        public void run(){
            
            StringBuilder html = PageRead.readPage(url);
            String seed = "";
            System.out.println("Runing Thread");
            final List<String> lifound = new ArrayList<>();
            final List<String> afound = new ArrayList<>();
            final Matcher bingmatcher = BING_REGEX.matcher(html);
            final Matcher yahoomatcher = YAHOO_REGEX.matcher(html);
            if (bingmatcher.find()){
                seed = bingmatcher.group(1);
            }
            else if (yahoomatcher.find()){
                seed = yahoomatcher.group(1);
            }
            
            
            StringBuilder resulthtml = PageRead.readPage(seed);
            Matcher urlmatcher = URL_REGEX.matcher(resulthtml);
            
            while(urlmatcher.find()){
                
                if ((dl.checknum())){
                    if(!dl.getResult().contains(urlmatcher.group(1)))
                    dl.addresult(urlmatcher.group(1));
                }else{
                    break;
                }
            }
            
            

            
            
            
        }
    
}
