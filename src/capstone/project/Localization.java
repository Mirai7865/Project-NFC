/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

/**
 *
 * @author Owner
 */
public class Localization {
public static String[] langData;

    public Localization() {
        //get region data
        this.loadLang();
    }

    private void loadLang() {
        //load language files
    }

    public static String[] getLang() { //return langData
        return langData;
    }
}
