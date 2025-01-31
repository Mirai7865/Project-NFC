/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.util.Comparator;

public class CompareByRisk implements Comparator {

    @Override
    public int compare(Object obj, Object secondObj) {
        Region region1 = (Region) obj;
        Region region2 = (Region) secondObj;
        if (region1.getRiskValue() < region2.getRiskValue()) {
            return -1;
        } else if (region1.getRiskValue() > region2.getRiskValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}
