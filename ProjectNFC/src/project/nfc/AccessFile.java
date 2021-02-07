/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.util.Scanner;
import java.io.*;

import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccessFile {

    public AccessFile() {

    }

    public static String readFile(String path) {
        StringBuffer strBfer = new StringBuffer();
        //create Scanner
        //try-catch statement
        try {
//            File f = new File(path.toURI());
            Scanner scr = new Scanner(new File(path), "UTF-8");
            //make while-loop
            while (scr.hasNext()) {
                //store the components into a String
                strBfer.append("<");
                strBfer.append(scr.nextLine());
            }
            //close Scanner
            scr.close();
            //return String
            if (strBfer.toString().equals("")) {
                System.out.println("Nothing inside file");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file at " + path);
        }
        return strBfer.toString();
    }

    public static void writeFile(String str, String path) {
        File f = new File(path);
        try {
            //create FileWriter object
            FileWriter fw = new FileWriter(f);
            //create PrintWriter object
            PrintWriter pw = new PrintWriter(fw);
            //write the str object into file
            pw.append(str);
            //close PrintWriter
            pw.close();
            //close FileWriter
            fw.close();
            //catch IOException
        } catch (IOException IOE) {
            System.out.println("Unable to find file at " + f.getPath());
        }
    }
}
