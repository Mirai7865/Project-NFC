/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Localization {
    
    private static String language;
    private static List<String> langData = new ArrayList<String>();
    
    public Localization() {
    }
    
    public static void setLang(String lang) {
        language = lang;
        loadLang();
    }
    
    public static String getLang() {
        return language;
    }
    
    private static void loadLang() {
        //load language files
        langData.clear();
        String str = AccessFile.readFile("data" + File.separator + "localization" + File.separator + getLang() + ".txt");
        Scanner scr = new Scanner(str);
        scr.useDelimiter("@");
        while (scr.hasNext()) {
            String s = scr.next();
            langData.add(s.substring(s.indexOf("=") + 1, s.length()));
        }
    }
    
    public static List<String> getLangData() { //return langData
        return langData;
    }
    
    public static String getLangDataAtIndex(int index) { //return langData at a particular index
        return langData.get(index);
    }
}
