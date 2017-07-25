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
    
    public String url;
    private static final Pattern RESULT_REGEX = Pattern.compile("result\"><h3 class=\"title\"><a href=\"(.+?)\" class=\"\">");
    private static final Pattern SEC_REGEX = Pattern.compile("class=\"b_algo\"><h2><a href=\"(.+?)\" h=\"");
    private static final Pattern URL_REGEX = Pattern.compile("<a href=\"(.+?)\"");
    public Search(String url){
        this.url = url;
    }
    
    
        public static void main(String[] args) {
            String yahoo = "https://sg.search.yahoo.com/search?p=";
            StringBuffer text = new StringBuffer("a b");
            String url = yahoo + text.toString().replaceAll(" ", "+");
            
            System.out.println(PageRead.readPage(url));
        }
        
        public void run(){
            StringBuilder html = PageRead.readPage(url);
            System.out.println("Runing Thread");
            System.out.println(html);
            final List<String> lifound = new ArrayList<String>();
            final List<String> afound = new ArrayList<String>();
            final Matcher matcher = RESULT_REGEX.matcher(html);
            final Matcher smatcher = SEC_REGEX.matcher(html);
            if (matcher.find()){
                lifound.add(matcher.group(1));
            }
            else if (smatcher.find()){
                lifound.add(smatcher.group(1));
            }
            
            for(String a : lifound){    
                System.out.println(a);
                
                
            }
            

            
            
            
        }
    
}
