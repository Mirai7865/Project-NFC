/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YahooApi {

    public YahooApi() {
        //Create http request 
        //client ID dj00aiZpPVJKbXh0dnZ3SllqdSZzPWNvbnN1bWVyc2VjcmV0Jng9M2M-
        String urlStr = "https://map.yahooapis.jp/weather/V1/place?coordinates=139.732293,35.663613&appid=dj00aiZpPVJKbXh0dnZ3SllqdSZzPWNvbnN1bWVyc2VjcmV0Jng9M2M-";
        URL url;
        try {
            url = new URL(new URI(urlStr).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
        } catch (URISyntaxException ex) {
            Logger.getLogger(YahooApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(YahooApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(YahooApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getForecast(HttpURLConnection data) { //The plan is to get weather data by connecting to yahoo weather(one of the most reliable sources). Will be working on this later.
        //create for-loop
        //get weather forecast and store into an array
        //return array
        return null;
    }
}
