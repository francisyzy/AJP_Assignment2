/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;
/**
 *
 * @author francisyzy
 */
public class SearchInput {
    
    private boolean yahooSelected;
    private boolean bingSelected;
    private boolean googleSelected;
    
    public SearchInput(boolean yahoo, boolean bing, boolean google){
        this.yahooSelected = yahoo;
        this.bingSelected = bing;
        this.googleSelected = google;
    }
    
    public static Download dl = new Download();
    
    public void startSearch(String input, int threadCount) throws InterruptedException{
        
        String g_api_key = "AIzaSyCEGJG94k2ERfopUDTab03R3kQX3E8m6ok";
        
        String yahoo = "https://sg.search.yahoo.com/search?p=";
        String bing = "https://www.bing.com/search?q=";
        //API KEY from https://developers.google.com/custom-search/json-api/v1/overview
        //Reference https://developers.google.com/custom-search/json-api/v1/using_rest
        String google = "https://www.googleapis.com/customsearch/v1?key="+g_api_key+"&cx=002976313549948865923:30uboh7bkhw&q=";
        
        String yahooregex = "result\"><h3 class=\"title\"><a href=\"(.+?)\" class=\"\">";
        String bingregex = "class=\"b_algo\"><h2><a href=\"(.+?)\" h=\"";
        String googleregex = "\\\"link\\\": \\\"(http.*?)\\\"";
        
        
        StringBuffer text = new StringBuffer(input);
        String ysearch = yahoo + text.toString().replaceAll("%", "%25").replaceAll("\\+", "%2B").replaceAll(" ", "+");
        String bsearch = bing + text.toString().replaceAll("%", "%25").replaceAll("\\+", "%2B").replaceAll(" ", "+");
        String gsearch = google + text.toString().replaceAll("%", "%25").replaceAll("\\+", "%2B").replaceAll(" ", "+");
        
        
        if((yahooSelected)&&!(bingSelected)&&!(googleSelected)){
            Search yahooSearch = new Search(ysearch,dl,yahooregex);
            yahooSearch.start();
            yahooSearch.join();
        }
        else if(!(yahooSelected)&&(bingSelected)&&!(googleSelected)){
            Search bingSearch = new Search(bsearch,dl,bingregex);
            bingSearch.start();
            bingSearch.join();
        }
        else if(!(yahooSelected)&&!(bingSelected)&&(googleSelected)){
            Search googleSearch = new Search(gsearch,dl,googleregex);
            googleSearch.start();
            googleSearch.join();
        }
        else if((yahooSelected)&&(bingSelected)&&!(googleSelected)){
            Search yahooSearch = new Search(ysearch,dl,yahooregex);
            Search bingSearch = new Search(bsearch,dl,bingregex);
            yahooSearch.start();
            bingSearch.start();
            yahooSearch.join();
            bingSearch.join();
        }
        else if((yahooSelected)&&!(bingSelected)&&(googleSelected)){
            Search yahooSearch = new Search(ysearch,dl,yahooregex);
            Search googleSearch = new Search(gsearch,dl,googleregex);
            yahooSearch.start();
            googleSearch.start();
            yahooSearch.join();
            googleSearch.join();
        }
        else if(!(yahooSelected)&&(bingSelected)&&(googleSelected)){
            Search bingSearch = new Search(bsearch,dl,bingregex);
            Search googleSearch = new Search(gsearch,dl,googleregex);
            bingSearch.start();
            googleSearch.start();
            bingSearch.join();
            googleSearch.join();
        }
        else{
            Search yahooSearch = new Search(ysearch,dl,yahooregex);
            Search bingSearch = new Search(bsearch,dl,bingregex);
            Search googleSearch = new Search(gsearch,dl,googleregex);
            yahooSearch.start();
            bingSearch.start();
            googleSearch.start();
            yahooSearch.join();
            bingSearch.join();
            googleSearch.join();
        }
        
        

        dl.startdownload(threadCount);
    }
}
