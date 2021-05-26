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
    private String feelsLike;
    private String icon;

    public Weather() {
//        this.longi = pref.getCityLongi();
//        this.lati = pref.getCityLat();
        this.weatherDscrptn = "Updating...";
        this.temperature = "Updating...";
        this.feelsLike = "Updating...";
        this.icon = "Updating...";
    }

    public void setWeatherDescription(String weather) {
        this.weatherDscrptn = weather;
    }

    public void setTemperature(int temperature) {
        this.temperature = "" + temperature;
    }

    public void setFeelsLikeTemperature(int temperature) {
        this.feelsLike = "" + temperature;
    }

    public void setWeatherIcon(String icon) {
        this.icon = icon;
    }

    public String getWeatherDescription() {
        return this.weatherDscrptn;
    }

    public String getTemp() {
        return this.temperature;
    }

    public String getWeatherIcon() {
        return this.icon;
    }

    public String getFeelsLikeTemperature() {
        return this.feelsLike;
    }
}
