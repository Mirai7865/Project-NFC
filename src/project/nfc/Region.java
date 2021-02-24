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
    private double caseNumberAverage;
    private double riskValue;

    public Region(String regionName, int caseNumber, int population) {
        this.setRegionName(regionName);
        this.setCaseNumber(caseNumber);
        this.setPopulation(population);
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

    public void setCaseNumberDeltaWithDayPrior(int caseNumberYesterday) {
        this.caseNumberDelta = this.getCaseNumber() - caseNumberYesterday;
    }

    public int getCaseNumberDeltaWithDayPrior() {
        return this.caseNumberDelta;
    }

    public void setCaseNumberAverage(int caseNumber14daysAgo) {
        this.caseNumberAverage = (this.getCaseNumber() - caseNumber14daysAgo) / 14.0;
    }

    public double getCaseNumberAverage() {
        return this.caseNumberAverage;
    }

    private void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setRisk() {
        this.riskValue = Calculate.calculateRisk(this.getPopulation(), this.getCaseNumber(), this.getCaseNumberAverage());
        if (this.riskValue > 0.003) {
            this.risk = "High";
        } else if (this.riskValue > 0.002) {
            this.risk = "Moderate";
        } else {
            this.risk = "Low";
        }
    }

    public String getRisk() {
        return this.risk;
    }

    public double getRiskValue() {
        return this.riskValue;
    }

    @Override
    public String toString() {
        return "Region: " + this.getRegionName() + ", Case Number: " + this.getCaseNumber();
    }
}
