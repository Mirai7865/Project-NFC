/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

/**
 *
 * @author 1100000436
 */
public class Prefecture extends Region {

    private int population;
    private String majorCity;
    private String weatherForecast;

    public Prefecture(String prefectureName, int caseNumber, int population, String majorCity) {
        super(prefectureName, caseNumber);
        this.population = population;
        this.majorCity = majorCity;
    }

    private void setPopulation(int population) {
        this.population = population;
    }

    private void setmajorCity(String city) {
        this.majorCity = city;
    }

    public int getPopulation() {
        return this.population;
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
