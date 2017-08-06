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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class PageRead {
    
    //orignal page read from Mr Boh / assignment specs
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
            //URLConnection conn = url.openConnection();
            //conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            //conn.connect(); //does not work
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
    
    
    //code below is modified from https://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java/2582771#2582771
    //does not fix linked in error so solution discarded. This is supposed to set a user agent but it did not
    //adds time to load
//    public static StringBuilder readPage(String pageAddr) {
//        
//        URL url;
//        
//        InputStream inStr = null;
//
//        BufferedReader reader;
//        String line;
//        StringBuilder sb = new StringBuilder();
//
//        try {
//            
//            url = new URL(pageAddr);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Cast shouldn't fail
//            HttpURLConnection.setFollowRedirects(true);
//            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
//            inStr = conn.getInputStream();
//            
//            inStr = url.openStream();  // throws an IOException
//            reader = new BufferedReader(new InputStreamReader(inStr));
//
//            while ((line = reader.readLine()) != null) {
//                sb.append(line+"\n");
//            }
//        } catch (MalformedURLException e) {
//             e.printStackTrace();
//        } catch (IOException e) {
//             e.printStackTrace();
//        }
//        
//        try {
//            inStr.close();
//        } catch (IOException ex) {
//            Logger.getLogger(PageRead.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return sb;
//    }
    
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
//		System.out.println(readPage("http://www.useragentstring.com"));
//    }
}