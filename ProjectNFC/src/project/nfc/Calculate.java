/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;


public class Calculate {

    public Calculate() {

    }

    public static double calculateRisk(int population, int caseNumber) {
        double risk = (double)caseNumber / (double)population;
//        System.out.println(risk);
        return risk;
    }
}
