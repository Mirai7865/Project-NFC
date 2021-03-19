/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class WeatherAPI {

    private static String apiKey = "02fd994e9f537d6f68bdccd39f801d57";

    public WeatherAPI() {
        //Create http request 
    }

    public static void getForecast(Prefecture pref) { //The plan is to get weather data by connecting to yahoo weather(one of the most reliable sources). Will be working on this later.
        String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" + pref.getMajorCityEng() + "&appid=" + apiKey;
        StringBuffer strB = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) (url.openConnection());
            con.connect();
            Scanner scr = new Scanner(url.openStream());
            while (scr.hasNext()) {
                strB.append(scr.next());
            }
            scr.close();
            con.disconnect();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to get weather data from API", "Error", ERROR_MESSAGE);
            System.exit(0);
        }

        String data = strB.toString();
//        System.out.println(data);
        try {
            String weather = data.substring(data.indexOf("\"main\":\"") + 8, data.indexOf(",\"description\"") - 1);
            double tempKelvin = Double.valueOf(data.substring(data.indexOf("\"temp\":") + 7, data.indexOf(",\"feels_like\"") - 1));
            int temp = (int) Math.round(tempKelvin - 273.15);
            pref.setTemp(temp);
            pref.setWeather(weather);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to process weather data.", "Error", ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
