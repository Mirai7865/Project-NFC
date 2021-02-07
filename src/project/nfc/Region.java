/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.util.Formatter;

abstract class Region {

    private String regionName;
    private int caseNumber;

    public Region(String regionName, int caseNumber) {
        this.setRegionName(regionName);
        this.setCaseNumber(caseNumber);
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

    @Override
    public String toString() {
        return "Region: "+ this.getRegionName() + " Case Number: " + this.getCaseNumber();
    }
}
