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
        this.article = this.article + "\n\n";
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
            JOptionPane.showMessageDialog(null, "Unable to find " + this.articleTitle, "Error", ERROR_MESSAGE);
            System.exit(0);
        }
        String parsedArticle = parseJSON(strB.toString());
        this.article = parsedArticle.substring(parsedArticle.toString().indexOf("\"extract\":\"") + "\"extract\":\"".length(), parsedArticle.toString().lastIndexOf("\",\"ns\""));
        this.article = this.article + "\n\n";
    }

    public String getArticle() {
        return this.article;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    private String parseJSON(String jsonStr) {
        JSONObject obj = new JSONObject(jsonStr);
        return obj.toString();
    }
}
