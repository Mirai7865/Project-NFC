/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class AccessFile {

    public AccessFile() {

    }

    public static String readFile(String path) {
        StringBuffer strBfer = new StringBuffer();
        boolean isThisFirstLine = true;
        //create Scanner
        //try-catch statement
        try {
//            File f = new File(path.toURI());
            Scanner scr = new Scanner(new File(path), "UTF-8");
            //make while-loop
            while (scr.hasNext()) {
                //store the components into a String
                if (isThisFirstLine == true) { //First line contains formatting.
                    scr.nextLine();
                    isThisFirstLine = false;
                    continue;
                }
                strBfer.append("@");
                strBfer.append(scr.nextLine());
            }
            //close Scanner
            scr.close();
            //return String
            if (strBfer.toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Nothing found inside " + path, "Error", ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No such file found at " + path, "Error", ERROR_MESSAGE);
            System.exit(0);
        }
        return strBfer.toString();
    }

    public static void writeFile(String str, String path) {
        try {
            File f = new File(path);
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
            JOptionPane.showMessageDialog(null, "No such file found at " + path, "Error", ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
