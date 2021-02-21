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
    private String data;

    public BackendModels() {
        this.initialSetUp();
    }

    private void initialSetUp() {
        int[] caseNumberAry = CaseNumberApi.getCaseNumber();
        this.prefectureArraySetup(caseNumberAry);
        this.deltaSetup(caseNumberAry);
        this.averageIncreaseSetup(caseNumberAry);
    }

    private void prefectureArraySetup(int[] caseNumberAry) {
        data = AccessFile.readFile(("data" + File.separator + "prefecture.txt"));
        Scanner scr = new Scanner(data);
        scr.useDelimiter("@");

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
        scr.close();
    }

    private void deltaSetup(int[] caseNumberAry) {
        int allJapanCaseNumberDayBefore = 0;
        int count = 47;
        while (count >= 47 && count < 47 * 2) {
            japanPrefecture[count - 47].setCaseNumberDeltaWithDayPrior(caseNumberAry[count]);
            allJapanCaseNumberDayBefore += caseNumberAry[count];
//            System.out.println(caseNumberAry[count]);
            count++;
        }
        this.japan.setCaseNumberDeltaWithDayPrior(allJapanCaseNumberDayBefore);
    }

    private void averageIncreaseSetup(int[] caseNumberAry) {
        int caseNumber14daysAgoJapanTotal = 0;
        for (int i = 0; i < 47; i++) {
            this.japanPrefecture[i].setCaseNumberAverage((caseNumberAry[47 * 14 + i]));
            this.japanPrefecture[i].setRisk();
            caseNumber14daysAgoJapanTotal += caseNumberAry[47 * 14 + i];
//            System.out.println(this.japanPrefecture[i].getCaseNumberAverage());
        }
        this.japan.setCaseNumberAverage(caseNumber14daysAgoJapanTotal);
        this.japan.setRisk();
    }
}
