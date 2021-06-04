/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;


public class Prefecture extends Region {

    private String majorCityJP;
    private String majorCityEng;
    private double lat;
    private double longi;
    private Weather[] forecast;

    public Prefecture(String prefectureName, int regionNumber, int caseNumber, int population, String majorCityJP, String majorCityEng, double lat, double longi) {
        super(prefectureName, regionNumber, caseNumber, population);
        this.setMajorCityJP(majorCityJP);
        this.setMajorCityEng(majorCityEng);
        this.setCityLat(lat);
        this.setCityLongi(longi);
        this.forecast = new Weather[3];
    }

    private void setCityLat(double lat) {
        this.lat = lat;
    }

    private void setCityLongi(double longi) {
        this.longi = longi;
    }

    public double getCityLat() {
        return this.lat;
    }

    public double getCityLongi() {
        return this.longi;
    }

    private void setMajorCityJP(String city) {
        this.majorCityJP = city;
    }

    public String getMajorCityJp() {
        return this.majorCityJP;
    }

    private void setMajorCityEng(String city) {
        this.majorCityEng = city;
    }

    public String getMajorCityEng() {
        return this.majorCityEng;
    }

    public void setWeather() {
        this.forecast = WeatherAPI.getForecast(this);
    }

    public String getTemp(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "Updating...";
        }
        return "" + this.forecast[day].getTemp() + "\u2103";
    }

    public String getWeather(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "Updating...";
        }
        return this.forecast[day].getWeatherDescription();
    }

    public String getWeatherIconURL(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "";
        }
        String urlStr = "http://openweathermap.org/img/wn/" + this.forecast[day].getWeatherIcon() + "@2x.png";
        return urlStr;
    }

    public String getFeelsLikeTemperature(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "Updating...";
        }
        return this.forecast[day].getFeelsLikeTemperature() + "\u2103";
    }

    public String getMaxTemperature(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "Updating...";
        }
        return this.forecast[day].getMaxTemp() + "\u2103";
    }

    public String getMinTemperature(int day) throws IllegalArgumentException {
        if (day > 2) {
            throw new IllegalArgumentException("Day cannot be beyond 3.");
        }
        if (this.forecast[day] == null) {
            return "Updating...";
        }
        return this.forecast[day].getMinTemp()+ "\u2103";
    }

    @Override
    public String toString() {
        String string = "Region: " + this.getRegionName() + ", Case Number: " + this.getCaseNumber() + " Major City: " + this.getMajorCityEng() + " Weather: " + this.getWeather(0);
        return string;
    }
}
