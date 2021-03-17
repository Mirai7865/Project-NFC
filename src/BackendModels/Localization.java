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
        File folder = new File("data" + File.separator + "localization");
        File[] langFiles = folder.listFiles();

        if (langFiles == null) {
            System.out.println("Found no lang data files.");
            return;
        }

        boolean matched = false;
        for (File langFile : langFiles) {
//            System.out.println((langFile.getName()).replaceAll(".txt", ""));
            if ((langFile.getName()).replaceAll(".txt", "").equals(lang)) {
                language = lang;
//                System.out.println("Found lang file.");
                matched = true;
                break;
            }
        }
        if (matched == false) {
            language = "en";
        }
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
        if (index <= -1) {
            return null;
        }
        String str = langData.get(index);
        return str.substring(str.indexOf("=") + 1, str.length());
    }

    public static int indexOf(String word) {
        for (int i = 0; i < langData.size(); i++) {
            if (langData.get(i).contains(word)) {
                return i;
            }
        }
        return -1;
    }
}
