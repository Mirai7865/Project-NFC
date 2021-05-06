/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import BackendModels.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Guide {

    private Article article;
    private JScrollPane articlePane;
    private JPanel articlePanel;
    private JTextArea articleTextArea;
    private JLabel[] articleImage;
    private String[] imageTitle;
    private JTextArea hyperLinkWiki;
    private JTextArea hyperLinkGoogleMap;

    private int locationRegionNum;

    public Guide(String articleTitle, String path, int regionNum) {
        this.article = new Article(articleTitle, path);
        if (regionNum <= 47) {
            this.locationRegionNum = regionNum;
        } else {
            return;
        }

        this.articlePanel = new JPanel(new GridBagLayout());
        this.articlePanel.setBackground(Color.WHITE);

        this.articlePane = new JScrollPane(this.articlePanel);
        this.articlePane.setPreferredSize(new Dimension(700, 600));
        this.articlePane.getVerticalScrollBar().setUnitIncrement(15);

        this.articleTextArea = new JTextArea();
        this.articleTextArea.setText(this.article.getArticleContent());
        this.articleTextArea.setEditable(false);
        this.articleTextArea.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        this.articleTextArea.setLineWrap(true);
        this.articleTextArea.setWrapStyleWord(true);

        File folder = new File("data" + File.separator + "images" + File.separator + this.article.getArticleTitle());
        File[] images = folder.listFiles();

        if (images == null) {
            this.articleImage = null;
        } else {
            this.articleImage = new JLabel[images.length];
            this.imageTitle = new String[images.length];
            for (int i = 0; i < images.length; i++) {
                AccessImage img = new AccessImage(this.article.getArticleTitle() + File.separator + images[i].getName());
                this.articleImage[i] = new JLabel(img.getScaledImage(600, 600));
                this.imageTitle[i] = images[i].getName().substring(0, images[i].getName().lastIndexOf("."));
                this.articleImage[i].setBorder(BorderFactory.createTitledBorder(this.imageTitle[i]));
            }
        }

        this.addComponents();
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.01;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        this.articlePanel.add(this.articleTextArea, gbc);

        if (this.article.getPath().equals("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + this.article.getArticleTitle())) {
            this.hyperLinkWiki = new JTextArea();
            this.hyperLinkWiki.setEditable(false);
            this.hyperLinkWiki.setOpaque(false);
            this.hyperLinkWiki.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            this.hyperLinkWiki.setText("(From Wikipedia)");
            this.hyperLinkWiki.setForeground(Color.BLUE);

            this.hyperLinkGoogleMap = new JTextArea();
            this.hyperLinkGoogleMap.setEditable(false);
            this.hyperLinkGoogleMap.setOpaque(false);
            this.hyperLinkGoogleMap.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            this.hyperLinkGoogleMap.setText("See in Google Map\n\n");
            this.hyperLinkGoogleMap.setForeground(Color.BLUE);

            gbc.gridx = 0;
            gbc.gridy = gbc.gridy + 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = 0;
            gbc.anchor = GridBagConstraints.SOUTHWEST;
            this.articlePanel.add(this.hyperLinkWiki, gbc);

            gbc.gridx = 0;
            gbc.gridy = gbc.gridy + 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            this.articlePanel.add(this.hyperLinkGoogleMap, gbc);
        }

        int relativeY = gbc.gridy;

        if (this.articleImage != null) {
            for (int i = 0; i < this.articleImage.length; i++) {
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = relativeY + 1 + i;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.anchor = GridBagConstraints.NORTHWEST;
                this.articlePanel.add(this.articleImage[i], gbc);
            }
        }

    }

    public JScrollPane getArticleComponent() {
        return this.articlePane;
    }

    public String getArticleTitle() {
        return this.article.getArticleTitle().replaceAll("_", " ");
    }

    public String getArticlePath() {
        if (this.pathIsURL()) {
            return "https://en.wikipedia.org/wiki/" + this.article.getArticleTitle();
        } else {
            return this.article.getPath();
        }
    }

    public boolean pathIsURL() {
        return this.article.getPath().equals("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + this.article.getArticleTitle());
    }

    public int getRegionNum() {
        return this.locationRegionNum;
    }

    public JTextArea getHyperLinkWiki() {
        return this.hyperLinkWiki;
    }

    public JTextArea getHyperLinkGoogleMap() {
        return this.hyperLinkGoogleMap;
    }
}
