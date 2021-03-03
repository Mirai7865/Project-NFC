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

public class WeatherAPI {

    public WeatherAPI() {
        //Create http request 
        String apiKey = "02fd994e9f537d6f68bdccd39f801d57";
        String urlStr = "api.openweathermap.org/data/2.5/weather?q=" + "&appid=" + apiKey;
        URL url;
        try {
            url = new URL(new URI(urlStr).toASCIIString());
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
        } catch (URISyntaxException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getForecast(HttpURLConnection data) { //The plan is to get weather data by connecting to yahoo weather(one of the most reliable sources). Will be working on this later.
        //create for-loop
        //get weather forecast and store into an array
        //return array
        return null;
    }
}
