/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.List;

/**
 *
 * @author francisyzy
 */
public class GoogleSearch {
    
    private ResponseData responseData;
    public ResponseData getResponseData() {
        return responseData;
    }
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
    public String toString() {
        return "ResponseData[" + responseData + "]";
    }
    
    static class ResponseData {
        private List<Result> results;
        public List<Result> getResults() {
            return results; 
        }
        public void setResults(List<Result> results) {
            this.results = results;
        }
        public String toString() {
            return "Results[" + results + "]";
        }
    }
    
    static class Result {
        private String url;
        private String title;
        private String content;
        public String getUrl() {
            return url;
        }
        public String getTitle() {
            return title;
        }
        public String getContent() {
            return content;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setContent(String content) {
            this.content = content;
        }
        public String toString() {
            return "Result[url:" + url +",title:" + title + ",content:" + content + "]";
        }
    }   
}
