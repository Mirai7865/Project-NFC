/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

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

    public String getMajorCityJp() {
        return this.majorCityJP;
    }

    private void setMajorCityEng(String city) {
        this.majorCityEng = city;
    }

    public String getMajorCityEng() {
        return this.majorCityEng;
    }

    public void setWeatherForecast() {
        this.weatherForecast = WeatherAPI.getForecast(this.getMajorCityEng());
    }

    public String getWeatherForecast() {
        return this.weatherForecast;
    }

    @Override
    public String toString() {
        String string = "Region: " + this.getRegionName() + ", Case Number: " + this.getCaseNumber() + " Major City: " + this.getMajorCityEng() + " Weather: " + this.getWeatherForecast();
        return string;
    }
}
