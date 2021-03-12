/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

public class Calculate {

    public Calculate() {

    }

    public static double calculateRisk(int population, int caseNumber, double averageCaseNumberIncrease) {
        double risk = ((double) (averageCaseNumberIncrease) / (double) (population));
//        System.out.println(risk);
        return risk;
    }
}
