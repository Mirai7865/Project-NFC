/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

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
            langData.add(scr.next());
        }
    }

    public static List<String> getLangData() { //return langData
        return langData;
    }
    
    public static String getLangDataAt(int index) { //return langData at a particular index
        String str = langData.get(index);
        return str.substring(str.indexOf("=") + 1, str.length());
    }

    public static String getLangDataContaining(String word) {
        for (String data : langData) {
            if (data.contains(word)) {
                return data.substring(data.indexOf("=") + 1, data.length());
            }
        }
        return null;
    }
}
