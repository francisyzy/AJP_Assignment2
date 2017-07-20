/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author francisyzy
 * google search engine api key  AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok 
 *  search engine ID 002976313549948865923:30uboh7bkhw
 * 
 * https://www.googleapis.com/customsearch/v1?key=AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok&cx=002976313549948865923:30uboh7bkhw&q=lectures
 */
public class GoogleSearchRestTest {
    public static void main(String[] args) throws IOException {
        final String APIKey = "AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok";
        final String SearchEngineID = "002976313549948865923:30uboh7bkhw";
        
        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok&cx=002976313549948865923:30uboh7bkhw&q=lectures");
        String query = "Test";

        //make connection
        URLConnection urlc = url.openConnection();

        //use post mode
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        //send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.print(query);
        ps.close();

        //get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l = null;
        while ((l=br.readLine())!=null) {
            System.out.println(l);
        }
        br.close();
    }
    
    public HttpsURLConnection connect(URL url) throws IOException {
        if (!url.getProtocol().equals("https")){
            throw (new MalformedURLException("Can only be used to connect to HTTPS servers"));
        }
        HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
        conn.setSSLSocketFactory(sfac());
        if (ver != null){ 
            conn.setHostnameVerifier(ver);
        }
        return (conn);
      }
 
}
