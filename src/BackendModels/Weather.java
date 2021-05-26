/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

public class Weather {

//    private double longi;
//    private double lati;
    private String weatherDscrptn;
    private String temperature;

    public Weather() {
//        this.longi = pref.getCityLongi();
//        this.lati = pref.getCityLat();
        this.weatherDscrptn = "Updating...";
        this.temperature = "Updating...";
    }

    public void setWeatherDescription(String weather) {
        this.weatherDscrptn = weather;
    }

    public void setTemperature(int temperature) {
        this.temperature = "" + temperature;
    }

    public String getWeatherDescription() {
        return this.weatherDscrptn;
    }

    public String getTemp() {
        return this.temperature;
    }

}
