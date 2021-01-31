/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;


public class Calculate {

    public Calculate() {

    }

    public double calculateRisk(int population, int caseNumber) {
        double risk = 0.0;
        risk = caseNumber / population;
        return risk;
    }
}
