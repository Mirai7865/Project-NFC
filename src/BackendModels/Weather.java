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
    private String minTemp;
    private String maxTemp;

    public Weather() {
        this.weatherDscrptn = "";
        this.temperature = "";
        this.feelsLike = "";
        this.icon = "";
        this.minTemp = "";
        this.maxTemp = "";
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

    public void setMaxTemperature(int temperature) {
        this.maxTemp = "" + temperature;
    }

    public void setMinTemperature(int temperature) {
        this.minTemp = "" + temperature;
    }

    public void setWeatherIcon(String icon) {
        this.icon = icon;

//        String urlStr = "http://openweathermap.org/img/wn/" + icon + "png";
//        try {
//            AccessImage img = new AccessImage(new URL(urlStr));
//        } catch (MalformedURLException ex) {
//            JOptionPane.showMessageDialog(null, "Something went wrong with getting the weather icon...", "Error", ERROR_MESSAGE);
//        }
//    }
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

    public String getMaxTemp() {
        return this.maxTemp;
    }

    public String getMinTemp() {
        return this.minTemp;
    }

}
