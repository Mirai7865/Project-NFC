/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.json.*;

public class Article {

    private String articleTitle;
    private String articleContent;
    private String path;

    public Article(String articleTitle, String path) {
        this.articleTitle = articleTitle;
        this.path = path;
        if (this.path == null) {
            this.loadArticleFromWiki();
        } else {
            this.loadArticleFromDisk(this.path);
        }
    }

    private void loadArticleFromDisk(String path) {
        this.articleContent = AccessFile.readFile("data" + File.separator + "articles" + File.separator + this.path + ".txt");
        this.articleContent = this.articleContent.replaceFirst("@", "");
        this.articleContent = this.articleContent.replaceAll("@", "\n");
        this.articleContent = this.articleContent + "\n\n";
    }

    private void loadArticleFromWiki() {
        this.path = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + this.articleTitle;
        StringBuffer strB = new StringBuffer();

        try {
            URL url = new URL(new URI(this.path).toASCIIString());
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
            this.articleContent = "Article not found.";
        }
        String parsedArticle = parseJSON(strB.toString());
        this.articleContent = parsedArticle.substring(parsedArticle.toString().indexOf("\"extract\":\"") + "\"extract\":\"".length(), parsedArticle.toString().lastIndexOf("\",\"ns\""));
    }

    public String getArticleContent() {
        return this.articleContent;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public String getPath() {
        return this.path;
    }

    private String parseJSON(String jsonStr) {
        JSONObject obj = new JSONObject(jsonStr);
        return obj.toString();
    }
}
