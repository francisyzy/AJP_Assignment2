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
        url = Main.dl.getURL(number);
    }
   @Override
    public void run() {
        System.out.println("Start downloading of Url :"+ url);
        try {
            //Simulating processing time
            
        	//perform tasks
                File file = new File("URL"+number +".txt");
                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("URL"+number +".txt"), "utf-8"))) {
                    writer.write(PageRead.readPage(url).toString());
                 } catch (Exception ex) {
                    Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
                 }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.println("End downloading of Url :"+ url);
    }
    
    public static void WriteFile(BufferedReader in) throws IOException{
        
    }
}
