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

    private static final String API_KEY = "02fd994e9f537d6f68bdccd39f801d57";

    public WeatherAPI() {
        //Create http request 
    }

    public static Weather[] getForecast(Prefecture pref) { //The plan is to get weather data by connecting to yahoo weather(one of the most reliable sources). Will be working on this later.
        String urlStr = "https://api.openweathermap.org/data/2.5/onecall?lat=" + pref.getCityLat() + "&lon=" + pref.getCityLongi() + "&exclude=minutely,hourly" + "&appid=" + API_KEY;
        StringBuffer strB = new StringBuffer();
        Weather forecast[] = new Weather[3];
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
//        Scanner sc = new Scanner(data);
//        sc.useDelimiter(",");
//        while (sc.hasNext()) {
//            System.out.println(sc.next());
//        }
        for (int i = 0; i < forecast.length; i++) {
            try {
                String weather = data.substring(data.indexOf("\"main\":\"") + 8, data.indexOf(",\"description\"") - 1);
//                System.out.println(weather);
//            String icon = data.substring(data.indexOf("\"icon\":") + 8, data.indexOf("\"}],\"base\"") - 1);
////            System.out.println(icon);
                double tempKelvin = Double.valueOf(data.substring(data.indexOf("\"temp\":") + 7, data.indexOf(",\"feels_like\"")));
//            double tempMinKelvin = Double.valueOf(data.substring(data.indexOf("\"temp_min\":") + 11, data.indexOf(",\"temp_max") - 1));
//            double tempMaxKelvin = Double.valueOf(data.substring(data.indexOf("\"temp_max\":") + 11, data.indexOf(",\"pressure\":") - 1));
//            int minTemp = (int) Math.round(tempMinKelvin - 273.15);
//            int maxTemp = (int) Math.round(tempMaxKelvin - 273.15);
                int temp = (int) Math.round(tempKelvin - 273.15);
//            System.out.println(minTemp);
//            System.out.println(maxTemp);
//            System.out.println(tempKelvin);
//                System.out.println(temp);
                forecast[i] = new Weather();
                forecast[i].setTemperature(temp);
                forecast[i].setWeatherDescription(weather);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to process weather data.", "Error", ERROR_MESSAGE);
            }
        }
        return forecast;
    }
}
