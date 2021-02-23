/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Guide {

    private String articleTitle;
    private String article;
    private String path;

    public Guide(String articleTitle, String path) {
        this.articleTitle = articleTitle;
        this.path = path;
        this.loadArticle();
    }

    private void loadArticle() {
//        this.article = AccessFile.readFile("data" + File.separator + "articles" + File.separator + this.path + ".txt");
//        this.article = this.article.replaceFirst("@", "");
//        this.article = this.article.replaceAll("@", "\n");
        String urlStr = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Senso-ji";
        StringBuffer strB = new StringBuffer();

        try {
            URL url = new URL(new URI(urlStr).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
            while (scr.hasNext()) {
                strB.append(scr.next());
                strB.append(" ");
            }
            scr.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println("Unable to grant connection to " + urlStr);
        }
        this.article = strB.toString();
    }

    public String getArticle() {
        return this.article;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }
}
