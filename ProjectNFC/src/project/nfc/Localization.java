/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.util.Scanner;

public class Localization {

    private static String language;
    private static String[] langData = new String[50];

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
        String str = AccessFile.readFile(("data" + File.separator + "localization" + File.separator + getLang() + ".txt"));
        Scanner scr = new Scanner(str);
//        System.out.println(str);
        scr.useDelimiter("<<.{0,10}>=");
        int num = 0;
        while (scr.hasNext()) {
//            String temp = scr.next();
//            System.out.println(temp);

//            int index = temp.indexOf("=");
//            System.out.println(index);
            langData[num] = scr.next();
//            System.out.println(langData[num]);
            num++;
        }
//        System.out.println(langData[48]);
    }

    public static String[] getLangData() { //return langData
        return langData;
    }
}
