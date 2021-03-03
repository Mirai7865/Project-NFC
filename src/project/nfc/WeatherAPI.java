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

public class WeatherAPI {

    private static String apiKey = "02fd994e9f537d6f68bdccd39f801d57";

    public WeatherAPI() {
        //Create http request 
    }

    public static String getForecast(String cityName) { //The plan is to get weather data by connecting to yahoo weather(one of the most reliable sources). Will be working on this later.
        String urlStr = "api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
        StringBuffer strB = new StringBuffer();
        try {
            URL url = new URL(new URI(urlStr + apiKey).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
            while (scr.hasNext()) {
                strB.append(scr.next());
            }
            scr.close();
            con.disconnect();
        } catch (Exception ex) {
            System.out.println("Failed to fetch weather data of " + cityName);
        }
        return strB.toString();
    }
}
