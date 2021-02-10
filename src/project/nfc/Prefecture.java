/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

public class Prefecture extends Region {

    private String majorCity;
    private String weatherForecast;

    public Prefecture(String prefectureName, int caseNumber, int population, String majorCity) {
        super(prefectureName, caseNumber, population);
        this.setmajorCity(majorCity);
    }

    private void setmajorCity(String city) {
        this.majorCity = city;
    }

    public String getMajorCityName() {
        return this.majorCity;
    }

    private void setWeatherForecast(String weather) {
        this.weatherForecast = weather;
    }

    public String getWeatherForecast() {
        return this.weatherForecast;
    }
}
