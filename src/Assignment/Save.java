/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caeden
 */
public class Save implements Runnable {
    private int number;
    private String url;
    public Save(int number) {
        this.number = number;
        url = SearchInput.dl.getURL(number);
    }
   @Override
    public void run() {
        System.out.println("Start downloading of Url :"+ url);
        try {
            //Simulating processing time
            
            //perform tasks
            //File file = new File("URL"+number +".txt");
//            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("URL"+number +".txt"), "utf-8"))) {
//                StringBuilder htmlfile =PageRead.readPage(url);
//                writer.write(htmlfile.toString());
//                SearchInput.dl.setHtml(number, htmlfile.toString());  
//             } catch (Exception ex) {
//                Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
//             }
            
            File newFile = new File("URL"+number +".html");
            
            try{
            newFile.createNewFile();
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                FileWriter fileW = new FileWriter(newFile);
                BufferedWriter buffW = new BufferedWriter(fileW);
                String html = PageRead.readPage(url).toString();
                buffW.write(html);
                buffW.close();
                System.out.println("File Written");
                SearchInput.dl.setHtml(number, html);
                SearchInput.dl.putMap(url, html);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End downloading of Url :"+ url);
        if(SearchInput.dl.checkMapnum()){
            System.out.println("Total Time Taken :" + SearchInput.dl.getTime());
            TaskExecutor.canceltask();
        }
        /*if(SearchInput.dl.checkMapnum())
            try {
                SearchInput.dl.stopTime();
                } catch (IOException ex) {
                    Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
                }*/
    }//end of method
    
    public static void WriteJson(BufferedReader in) throws IOException{
        File newFile = new File("Results.json");
        try{
            newFile.createNewFile();
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            FileWriter fileW = new FileWriter(newFile);
            BufferedWriter buffW = new BufferedWriter(fileW);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                buffW.write(inputLine+"\n");
            }
            buffW.close();
            System.out.println("File Written");
        }catch(Exception e){
            e.printStackTrace();
        }
    }//end of method
}
