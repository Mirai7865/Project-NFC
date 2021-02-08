/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class CaseNumberApi {

//    private static String data = "";
//    public static String[] testing = new String[47];
    public CaseNumberApi() {
    }

    public static int[] getCaseNumber() {
        //use switch statement to count the caseNumbers for each prefecture
        String urlStr = "https://opendata.corona.go.jp/api/Covid19JapanAll";
        StringBuffer strB = new StringBuffer();

        try {
            URL url = new URL(new URI(urlStr).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
            while (scr.hasNext()) {
                strB.append(scr.next());
            }
//            data = strB.toString();
            scr.close();
        } catch (Exception ex) {
            System.out.println("Unable to grant connection to " + urlStr);
        }

        Scanner scr = new Scanner(strB.toString());
        scr.useDelimiter("\"d");
        String str = "";
        int startingIndex = 0;
        int endingIndex = 0;
        int[] caseNumber = new int[47];
        str = scr.next();

        if (str.equalsIgnoreCase("{\"errorInfo\":{\"errorFlag\":\"0\",\"errorCode\":null,\"errorMessage\":null},\"itemList\":[]}")) {
            System.out.println("Error in obtaining data from server.");
        }
        for (int i = 0; i < 47; i++) {
            str = scr.next();
//            System.out.println(str);
//            testing[i] = str;
            startingIndex = str.indexOf("\"npatients\":") + 13;
            endingIndex = str.indexOf("\"},");
            caseNumber[i] = Integer.parseInt(str.substring(startingIndex, endingIndex));
        }
        return caseNumber;
    }
}
