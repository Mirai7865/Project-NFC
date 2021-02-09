/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;

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
        this.article = AccessFile.readFile("data" + File.separator + "articles" + File.separator + this.path + ".txt");
        this.article = this.article.replaceFirst("@", "");
        this.article = this.article.replaceAll("@", "\n");
    }

    public String getArticle() {
        return this.article;
    }
    
    public String getArticleTitle() {
        return this.articleTitle;
    }
}
