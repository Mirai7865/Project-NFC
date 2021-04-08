/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranslatorApi {

    private Document doc;
    private Element link;
    private String relHref; // == "/"
    private String absHref;

    public TranslatorApi() {
        //Request http connection
        this.connect();
    }

    private void connect() {
        try {
            this.doc = Jsoup.connect("http://translate.google.com/translate?js=n&sl=auto&tl=ja&text=Gracias").get();
//            this.link = doc.select("a").first();
            String word = this.doc.text();
            Scanner scr = new Scanner(word);
            scr.useDelimiter("G");
            while(scr.hasNext()){
                System.out.println(scr.next());
            }
            System.out.println(this.doc.title());
            System.out.println(word);
//            this.relHref = link.attr("href"); // == "/"
            this.absHref = link.attr("abs:href"); // "http://jsoup.org/"
        } catch (IOException ex) {
            System.exit(0);
        }
    }

    public static String getTranslation(String str, String language) {
        //Create API to translate through google translate
        //return String
        return null;
    }
}
