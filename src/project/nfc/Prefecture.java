/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

public class Prefecture extends Region {
    
    private int population;
    private String risk;
    private String majorCity;
    private String weatherForecast;
    
    public Prefecture(String prefectureName, int caseNumber, int population, String majorCity) {
        super(prefectureName, caseNumber);
        this.setPopulation(population);
        this.setmajorCity(majorCity);
        this.setRisk();
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
    
    private void setRisk() {
        double risk = Calculate.calculateRisk(this.getPopulation(), this.getCaseNumber());
        if (risk > 0.003) {
            this.risk = "High";
        } else if (risk > 0.002) {
            this.risk = "Moderate";
        } else {
            this.risk = "Low";
        }
    }
    
    public String getRisk() {
        return this.risk;
    }
}
