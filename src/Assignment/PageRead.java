package Assignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francisyzy
 */
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class PageRead {
//    public static StringBuilder readPage(String pageAddr) {
//        try {
//            URL url = new URL(pageAddr);
// 
//            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//          
//            String line;
//            StringBuilder sb=new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                sb.append(line+"\n");
//            }
// 
//            reader.close();
//
//			return sb;            
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//			return new StringBuilder("");
//        }  catch (IOException e) {
//            e.printStackTrace();
//			return new StringBuilder("");
//        }
//    }
    
    public static StringBuilder readPage(String pageAddr) {
        URL url;
        InputStream ins = null;
        BufferedReader reader;
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            url = new URL(pageAddr);
            ins = url.openStream();  // throws an IOException
            reader = new BufferedReader(new InputStreamReader(ins));

            while ((line = reader.readLine()) != null) {
                sb.append(line+"\n");
            }
        } catch (MalformedURLException e) {
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        }
        
        try {
            ins.close();
        } catch (IOException ex) {
            Logger.getLogger(PageRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb;
    }
    
    /*
    Google SSL Reader Old
    
        String httpsURL = "https://www.googleapis.com/customsearch/v1?key=AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok&cx=002976313549948865923:30uboh7bkhw&q=lectures";
        URL myurl = new URL(httpsURL);
        HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
        System.out.println("Connecting");
        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);
        
        final Matcher googlematcher = GOOGLE_REGEX.matcher((CharSequence) in);
        
        String seed = "";
        
        if (googlematcher.find()){
            seed = googlematcher.group(1);
        }
        
        StringBuilder resulthtml = PageRead.readPage(seed);
        
        
        
        in.close();
        
        */

//    public static void main(String arg[]){ //testing
//
//		System.out.println(readPage("http://www.bing.com/search?q=test"));
//    }
}