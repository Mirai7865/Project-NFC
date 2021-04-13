/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranslatorApi {

    private String url;

    public TranslatorApi() {
        //Request http connection
        this.url = "http://translate.google.com/translate?js=n&sl=auto&tl=ja&text=";
        this.url += "Hello";
        this.connect();
    }

    private void connect() {
//        try {
        //        try {
//            final WebClient client = new WebClient();
//            HtmlPage page = client.getPage(this.url);
////            String xml = page.asXml();
//            String text = page.asNormalizedText();
////            System.out.println(xml);
//            System.out.println(text);
//
//        } catch (IOException ex) {
//            Logger.getLogger(TranslatorApi.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FailingHttpStatusCodeException ex) {
//            Logger.getLogger(TranslatorApi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try (final WebClient webClient = new WebClient()) {
//            final HtmlPage page = webClient.getPage(this.url);
////            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
//
//            final String pageAsXml = page.asText();
//            System.out.println(pageAsXml);
////            Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));
//        } catch (IOException ex) {
//            Logger.getLogger(TranslatorApi.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FailingHttpStatusCodeException ex) {
//            Logger.getLogger(TranslatorApi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            Document doc = Jsoup.connect(this.url).get();
//            Element bodyElm = doc.body();
//            System.out.println(bodyElm.toString());
//        } catch (IOException ex) {
//            Logger.getLogger(TranslatorApi.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        }
    }

    public static String getTranslation(String str, String language) {
        //Create API to translate through google translate
        //return String
        return null;
    }
}
