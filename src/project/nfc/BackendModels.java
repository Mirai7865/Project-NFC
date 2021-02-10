/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.io.File;
import java.util.Scanner;

public class BackendModels {

    public Region[] japan;

    public BackendModels() {
        this.initialSetUp();
    }

    private void initialSetUp() {
        String data = AccessFile.readFile(("data" + File.separator + "prefecture.txt"));
        Scanner scr = new Scanner(data);
        scr.useDelimiter("@");

        int[] caseNumberAry = CaseNumberApi.getCaseNumber();
        int count = 0;
        this.japan = new Prefecture[47];
        while (scr.hasNextLine()) {
            Scanner prefData = new Scanner(scr.next());
            try {
                String prefName = prefData.next();
                int population = prefData.nextInt() * 1000;
                String majorCity = prefData.next();
                japan[count] = new Prefecture(prefName, caseNumberAry[count], population, majorCity);
            } catch (NumberFormatException ex) {
                System.out.println("Exception in creating prefecture objects.");
            }
            prefData.close();
            count++;
        }
        scr.close();
    }
}
