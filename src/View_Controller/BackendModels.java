/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import BackendModels.DrawMap;
import BackendModels.*;
import java.io.File;
import java.util.Scanner;

public class BackendModels {

    public Prefecture[] japanPrefecture;
    public Region japan;
    public DrawMap map;
    public Clock clock;
    public Thread cThread;

    public BackendModels() {
        int[] caseNumberAry = CaseNumberApi.getCaseNumber();

        this.setPrefectureArray(caseNumberAry);
        this.countDelta(caseNumberAry);
        this.setAverageIncrease(caseNumberAry);

        Localization.setLang(System.getProperty("user.language"));

        this.map = null;
        this.clock = null;
        this.cThread = null;
    }

    private void setPrefectureArray(int[] caseNumberAry) {
        String data = AccessFile.readFile(("data" + File.separator + "prefecture data" + File.separator + "prefecture.txt"));
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
                String majorCityJP = prefData.next();
                String majorCityEng = prefData.next();
                double lat = prefData.nextDouble();
                double longi = prefData.nextDouble();
                japanPrefecture[count] = new Prefecture(prefName, count + 1, caseNumberAry[count], population, majorCityJP, majorCityEng, lat, longi);
                allJapanCaseNumber += caseNumberAry[count];
                allJapanPopulation += population;
//                System.out.println(caseNumberAry[count]);
            } catch (NumberFormatException ex) {
                System.out.println("Exception in creating prefecture objects.");
            }
            prefData.close();
            count++;
        }
        this.japan = new Region(scr.next(), 0, allJapanCaseNumber, allJapanPopulation);
        scr.close();
    }

    private void countDelta(int[] caseNumberAry) {
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

    private void setAverageIncrease(int[] caseNumberAry) {
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
