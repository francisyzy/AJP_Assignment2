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
        InputStream is = null;
        BufferedReader br;
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            url = new URL(pageAddr);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return sb;
    }

//    public static void main(String arg[]){ //testing
//
//		System.out.println(readPage("http://www.bing.com/search?q=test"));
//    }
}