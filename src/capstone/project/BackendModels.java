/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.project;

import java.util.Scanner;

public class BackendModels {

    public Region[] japan;

    public BackendModels() {

        String data = AccessFile.readFile("data\\prefecture.dat");
        Scanner scr = new Scanner(data);
        scr.useDelimiter("<");

        int[] caseNumberAry = CaseNumberApi.getCaseNumber();
        StringBuffer info = new StringBuffer();
        int count = 0;
        this.japan = new Prefecture[47];

        while (scr.hasNextLine()) {
            String temp = scr.next();
            Scanner scrT = new Scanner(temp);
            try {
                String prefName = scrT.next();
                int population = scrT.nextInt() * 1000;
                String majorCity = scrT.next();

                //For testing purposes
//                System.out.println(CaseNumberApi.testing[count].substring(CaseNumberApi.testing[count].indexOf("\"name_jp\":\"") + 11, CaseNumberApi.testing[count].indexOf("\",\"npatients")));
//                if (!(CaseNumberApi.testing[count].substring(CaseNumberApi.testing[count].indexOf("\"name_jp\":\"") + 11, CaseNumberApi.testing[count].indexOf("\",\"npatients")).equals(prefName))) {
//                    IllegalArgumentException iAE = new IllegalArgumentException();
//                    throw iAE;
//                }
                japan[count] = new Prefecture(prefName, caseNumberAry[count], population, majorCity);
                
//                info.append(japan[count].getRegionName());
//                info.append(" ");
//                info.append(japan[count].getCaseNumber());
//                info.append("\n");

            } catch (NumberFormatException ex) {
                System.out.println("Exception in creating prefecture objects.");
            } catch (IllegalArgumentException iAE) {
                System.out.println("The prefecture name and the returned data from API has been misassembled. Check prefectureData.txt");
            }
            scrT.close();
            count++;
        }
        scr.close();
    }
}
