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
}
