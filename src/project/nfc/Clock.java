/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JTextArea;

public class Clock implements Runnable {

    private boolean run;
    public JTextArea textArea;

    public Clock(JTextArea textArea) {
        this.run = true;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        while (run) {
            if (!this.run) {
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));
            Date date = new Date();
            this.textArea.setText(dateFormat.format(date));
        }
    }
}
