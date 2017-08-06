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
    
    private boolean yahooselected;
    private boolean bingselected;
    
    public SearchInput(boolean yahoo, boolean bing){
        this.yahooselected = yahoo;
        this.bingselected = bing;
    }
    
    public static Download dl = new Download();
    
    public void startSearch(String input, int threadCount) throws InterruptedException{
        String yahoo = "https://sg.search.yahoo.com/search?p=";
        String bing = "https://www.bing.com/search?q=";
        
        String yahooregex = "result\"><h3 class=\"title\"><a href=\"(.+?)\" class=\"\">";
        String bingregex = "class=\"b_algo\"><h2><a href=\"(.+?)\" h=\"";
    
       
        
        StringBuffer text = new StringBuffer(input);
        String ysearch = yahoo + text.toString().replaceAll(" ", "+");
        String bsearch = bing + text.toString().replaceAll(" ", "+");
        
        
        if((yahooselected)&&!(bingselected)){
        Search yahooSearch = new Search(ysearch,dl,yahooregex);
        yahooSearch.start();
        yahooSearch.join();}
        else if((bingselected)&&!(yahooselected)){
        Search bingSearch = new Search(bsearch,dl,bingregex);
        bingSearch.start();
        bingSearch.join();}
        else{
            Search yahooSearch = new Search(ysearch,dl,yahooregex);
            Search bingSearch = new Search(bsearch,dl,bingregex);
            bingSearch.start();
            yahooSearch.start();
            yahooSearch.join();
            bingSearch.join();
        }
        
        

        dl.startdownload(threadCount);
    }
}
