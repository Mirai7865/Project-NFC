/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class JpnGoverntApi implements COVID_API {

    private static final String API_URL = "https://opendata.corona.go.jp/api/Covid19JapanAll";
    private int[] caseNumber;

    public JpnGoverntApi() {
        this.caseNumber = new int[47 * 15];
    }

    public int[] getCaseNumber() {
        //use switch statement to count the caseNumbers for each prefecture
        StringBuffer strB = new StringBuffer();

        try {
            URL url = new URL(new URI(API_URL).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
            while (scr.hasNext()) {
                strB.append(scr.next());
            }
            scr.close();
            con.disconnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to connect to " + API_URL, "Error", ERROR_MESSAGE);
            System.exit(0);
        }

        Scanner scr = new Scanner(strB.toString());
        scr.useDelimiter("\"d");
        String str = "";
        int startingIndex = 0;
        int endingIndex = 0;
        str = scr.next();

        if (str.equalsIgnoreCase("{\"errorInfo\":{\"errorFlag\":\"0\",\"errorCode\":null,\"errorMessage\":null},\"itemList\":[]}")) {
            JOptionPane.showMessageDialog(null, "No data returned from API", "Error", ERROR_MESSAGE);
            System.exit(0);
        }
        for (int i = 0; i < 47 * 15; i++) {
            str = scr.next();
            startingIndex = str.indexOf("\"npatients\":") + 13;
            endingIndex = str.indexOf("\"},");
            this.caseNumber[i] = Integer.parseInt(str.substring(startingIndex, endingIndex));
        }
        return this.caseNumber;
    }

    public String getAPIURL() {
        return API_URL;
    }
}
