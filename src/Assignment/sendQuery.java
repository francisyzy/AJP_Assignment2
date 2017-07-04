/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection ;
/**
 *
 * @author francisyzy
 * google search engine api key  AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok 
 */
public class sendQuery {
    public void send(){
        
    }
    public static void main(String[] args) throws Exception {
        String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
        String search = "stackoverflow";
        String charset = "UTF-8";

        URL url = new URL(google + URLEncoder.encode(search, charset));
        Reader reader = new InputStreamReader(url.openStream(), charset);
        GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

        // Show title and URL of 1st result.
        System.out.println(results.getResponseData().getResults().get(0).getTitle());
        System.out.println(results.getResponseData().getResults().get(0).getUrl());
    }
}
