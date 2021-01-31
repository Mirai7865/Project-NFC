/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

import java.util.Scanner;
import java.io.*;

import java.util.Scanner;
import java.io.IOException;

public class AccessFile {

    public AccessFile() {

    }

    public static String readFile(String path) {
        File file = new File(path);
        StringBuffer strBfer = new StringBuffer();
        //create Scanner
        //try-catch statement
        try {
            Scanner scr = new Scanner(new File(file.getAbsolutePath()), "UTF-8");
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
        File f = new File(new File(path).getAbsolutePath());
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
            System.out.println("Unable to find file at " + f.getAbsolutePath());
        }
    }
}
