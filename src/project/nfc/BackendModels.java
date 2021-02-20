/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.util.Scanner;

public class BackendModels {

    public Prefecture[] japanPrefecture;
    public Region japan;

    public BackendModels() {
        this.initialSetUp();
    }

    private void initialSetUp() {
        String data = AccessFile.readFile(("data" + File.separator + "prefecture.txt"));
        Scanner scr = new Scanner(data);
        scr.useDelimiter("@");

        int[] caseNumberAry = CaseNumberApi.getCaseNumber();
        int count = 0;
        int allJapanCaseNumber = 0;
        int allJapanPopulation = 0;
        this.japanPrefecture = new Prefecture[47];
        while (count < 47) {
            Scanner prefData = new Scanner(scr.next());
            try {
                String prefName = prefData.next();
                int population = prefData.nextInt() * 1000;
                String majorCity = prefData.next();
                japanPrefecture[count] = new Prefecture(prefName, caseNumberAry[count], population, majorCity);
                allJapanCaseNumber += caseNumberAry[count];
                allJapanPopulation += population;
//                System.out.println(caseNumberAry[count]);
            } catch (NumberFormatException ex) {
                System.out.println("Exception in creating prefecture objects.");
            }
            prefData.close();
            count++;
        }
        this.japan = new Region(scr.next(), allJapanCaseNumber, allJapanPopulation);

        int allJapanCaseNumberDayBefore = 0;
        while (count >= 47 && count < 47 * 2) {
            japanPrefecture[count - 47].setCaseNumberDelta(caseNumberAry[count]);
            allJapanCaseNumberDayBefore += caseNumberAry[count];
//            System.out.println(caseNumberAry[count]);
            count++;
        }
        this.japan.setCaseNumberDelta(allJapanCaseNumberDayBefore);
//        System.out.println(this.japan.getCaseNumberDelta());
        scr.close();
    }
}
