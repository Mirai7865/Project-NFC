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
import org.jsoup.select.Elements;

public class TranslatorApi {

    private Document doc;
    private Element link;
    private String relHref; // == "/"
    private String absHref;

    public TranslatorApi() throws InterruptedException {
        //Request http connection
        this.connect();
    }

    private void connect() throws InterruptedException {
        try {
            Connection c = Jsoup.connect("http://translate.google.com/translate?js=n&sl=auto&tl=ja&text=Hello");
            for (int i = 0; i < 1000000; i++) {

            }
            for (int i = 0; i < 1000000; i++) {

            }
            for (int i = 0; i < 1000000; i++) {

            }
            this.doc = c.get();
            this.link = this.doc.body();
//            Elements span = this.link.getElementsByTag("jsaction");

//            for (int i = 0; i < span.size(); i++) {
//                Element aSpanElem = span.get(i);
//                System.out.println(aSpanElem.text());
//            }
            String word = this.doc.text();
            Scanner scr = new Scanner(word);
            scr.useDelimiter(" ");
            while (scr.hasNext()) {
                System.out.println(scr.next());
            }
//            System.out.println(this.doc.title());
//            System.out.println(word);
//            this.relHref = link.attr("href"); // == "/"
//            this.absHref = link.attr("abs:href"); // "http://jsoup.org/"
//            this.doc = Jsoup.connect("http://translate.google.com/translate?js=n&sl=auto&tl=ja&text=Gracias").wait(0).get();
            word = this.doc.text();
            System.out.println(word);
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
