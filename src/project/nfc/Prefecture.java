/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

public class Prefecture extends Region {

    private String majorCityJP;
    private String majorCityEng;
    private String weatherForecast;

    public Prefecture(String prefectureName, int regionNumber, int caseNumber, int population, String majorCityJP, String majorCityEng) {
        super(prefectureName, regionNumber, caseNumber, population);
        this.setMajorCityJP(majorCityJP);
        this.setMajorCityEng(majorCityEng);
    }

    private void setMajorCityJP(String city) {
        this.majorCityJP = city;
    }

    public String getMajorCityNameJp() {
        return this.majorCityJP;
    }

    private void setMajorCityEng(String city) {
        this.majorCityEng = city;
    }

    public String getMajorCityNameEng() {
        return this.majorCityEng;
    }

    public void setWeatherForecast(String weather) {
        this.weatherForecast = weather;
    }

    public String getWeatherForecast() {
        return this.weatherForecast;
    }
}
