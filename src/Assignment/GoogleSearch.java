/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author francisyzy
 */
public class GoogleSearch {
    
    private static final Pattern GOOGLE_REGEX = Pattern.compile("\\\"link\\\": \\\"(http.*?)\\\"");
    
    public void ConnectGoogle() throws Exception{
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
        //return in;
    }
    
}
