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

//        try {
        Scanner scn = new Scanner(data);
        scn.useDelimiter("\"dt\"");
        String daily[] = new String[4];
        int dayCount = 0;
        while (scn.hasNext() && dayCount < 4) {
            daily[dayCount] = scn.next();
            dayCount++;
        }
        for (int i = 1; i <= forecast.length; i++) {
            String weather = daily[i].substring(daily[i].indexOf("\"main\":\"") + 8, daily[i].indexOf(",\"description\"") - 1);
//                System.out.println(weather);
            String icon = daily[i].substring(daily[i].indexOf("\"icon\":") + 8, daily[i].indexOf("\"icon\":") + 11);
//            System.out.println(icon);
            forecast[i - 1] = new Weather();

            double tempKelvin = 0.0;
            double feelsLikeKelvin = 0.0;
            double maxKelvin = 0.0;
            double minKelvin = 0.0;

            if (i == 1) {
                tempKelvin = Double.valueOf(daily[i].substring(daily[i].indexOf("\"temp\":") + 7, daily[i].indexOf(",\"feels_like\"")));
                feelsLikeKelvin = Double.valueOf(daily[i].substring(daily[i].indexOf("\"feels_like\"") + 13, daily[i].indexOf(",\"pressure\"")));
            } else {
                String cache = daily[i].substring(daily[i].indexOf("\"temp\""), daily[i].indexOf("\"feels_like\""));
                tempKelvin = Double.valueOf(cache.substring(cache.indexOf("\"day\":") + 6, cache.indexOf(",\"min\"")));
                minKelvin = Double.valueOf(cache.substring(cache.indexOf("\"min\":") + 6, cache.indexOf(",\"max\"")));
                maxKelvin = Double.valueOf(cache.substring(cache.indexOf("\"max\":") + 6, cache.indexOf(",\"night\"")));
//                System.out.println(minKelvin + "  " + maxKelvin);

                forecast[i - 1].setMaxTemperature((int) (maxKelvin - 273.15));
                forecast[i - 1].setMinTemperature((int) (minKelvin - 273.15));

                cache = daily[i].substring(daily[i].indexOf("\"feels_like\""), daily[i].indexOf("\"pressure"));
                feelsLikeKelvin = Double.valueOf(cache.substring(cache.indexOf("\"day\":") + 6, cache.indexOf(",\"night\"")));
            }
//            System.out.println(feelsLikeKelvin);
//            int minTemp = (int) Math.round(tempMinKelvin - 273.15);
//            int maxTemp = (int) Math.round(tempMaxKelvin - 273.15);
            int temp = (int) Math.round(tempKelvin - 273.15);
            int feelsLike = (int) Math.round(feelsLikeKelvin - 273.15);

            forecast[i - 1].setTemperature(temp);
            forecast[i - 1].setWeatherDescription(weather);
            forecast[i - 1].setWeatherIcon(icon);
            forecast[i - 1].setFeelsLikeTemperature(feelsLike);
        }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Unable to process weather data.", "Error", ERROR_MESSAGE);
//        }
        return forecast;
    }
}
