/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

import java.util.Comparator;

public class CompareByCase implements Comparator {

    @Override
    public int compare(Object reg1, Object reg2) {
        Region region1 = (Region) reg1;
        Region region2 = (Region) reg2;
        if (region1.getCaseNumber() > region2.getCaseNumber()) {
            return 1;
        } else if (region1.getCaseNumber() < region2.getCaseNumber()) {
            return -1;
        } else {
            return 0;
        }
    }
}
