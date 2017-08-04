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
    
    public static Download dl = new Download();
    
    public void startSearch(String input, int threadCount) throws InterruptedException{
        String yahoo = "https://sg.search.yahoo.com/search?p=";
        String bing = "https://www.bing.com/search?q=";
       
        
        StringBuffer text = new StringBuffer(input);
        String ysearch = yahoo + text.toString().replaceAll(" ", "+");
        String bsearch = bing + text.toString().replaceAll(" ", "+");
        Search yahooSearch = new Search(ysearch,dl);
        yahooSearch.start();
        Search bingSearch = new Search(bsearch,dl);
        bingSearch.start();
        yahooSearch.join();
        bingSearch.join();

        dl.startdownload(threadCount);
    }
}
