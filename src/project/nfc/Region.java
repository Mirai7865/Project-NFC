/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

public class Region {

    private String regionName;
    private int caseNumber;
    private int population;
    private String risk;
    private int caseNumberDelta;

    public Region(String regionName, int caseNumber, int population) {
        this.setRegionName(regionName);
        this.setCaseNumber(caseNumber);
        this.setPopulation(population);
        this.setRisk();
    }

    private void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    private void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public int getCaseNumber() {
        return this.caseNumber;
    }

    public void setCaseNumberDelta(int caseNumberYesterday) {
        this.caseNumberDelta = this.getCaseNumber() - caseNumberYesterday;
    }

    public int getCaseNumberDelta() {
        return this.caseNumberDelta;
    }

    private void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
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

    @Override
    public String toString() {
        return "Region: " + this.getRegionName() + ", Case Number: " + this.getCaseNumber();
    }
}
