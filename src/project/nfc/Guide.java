/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

public class Guide {

    private String articleTitle;
    private String article;
    private String path;

    public Guide(String articleTitle, String path) {
        this.articleTitle = articleTitle;
        this.path = path;
        if (this.path == null) {
            this.loadArticleFromWiki();
        } else {
            this.loadArticleFromDisk(this.path);
        }
    }

    public void loadArticleFromDisk(String path) {
        this.article = AccessFile.readFile("data" + File.separator + "articles" + File.separator + this.path + ".txt");
        this.article = this.article.replaceFirst("@", "");
        this.article = this.article.replaceAll("@", "\n");
    }

    private void loadArticleFromWiki() {
        String urlStr = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + this.articleTitle;
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
            if (strB.toString().contains(",\"missing\":")) {
                IOException ex = new IOException();
                throw ex;
            }

            scr.close();
            con.disconnect();
        } catch (Exception ex) {
            this.article = "Unable to find " + this.articleTitle;
            return;
        }
        String parsedArticle = parseJSON(strB.toString());
        this.article = parsedArticle.substring(parsedArticle.toString().indexOf("\"extract\":\"") + "\"extract\":\"".length(), parsedArticle.toString().lastIndexOf("\",\"ns\""));

    }

    public String getArticle() {
        return this.article;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public String parseJSON(String jsonStr) {
        JSONObject obj = new JSONObject(jsonStr);
//        System.out.println(obj);
        return obj.toString();
    }
}
