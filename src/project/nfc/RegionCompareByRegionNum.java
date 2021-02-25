/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.util.Comparator;

public class RegionCompareByRegionNum implements Comparator {

    @Override
    public int compare(Object obj, Object secondObject) {
        Region reg = (Region) obj;
        Region secondReg = (Region) secondObject;
        if (reg.getRegionNumber() > secondReg.getRegionNumber()) {
            return 1;
        } else if (reg.getRegionNumber() < secondReg.getRegionNumber()) {
            return 1;
        } else {
            return 0;
        }
    }
}
