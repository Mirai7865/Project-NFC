/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

/**
 *
 * @author 1100000436
 */
public class Guide {

    private String articleTitle;
    private String article;
    private String path;

    public Guide(String articleTitle, String path) {
        this.articleTitle = articleTitle;
        this.path = path;
    }

    public void loadArticle() {
        this.article = AccessFile.readFile(this.path);
    }

    public String getArticle() {
        return this.article;
    }
}
