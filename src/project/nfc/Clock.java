/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.nfc;

import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Clock implements Runnable {

    private boolean run;
    public JTextArea textArea;

    public Clock(JTextArea textArea) {
        this.run = true;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        while (true) {
            if (!this.run) {
                return;
            }

            long dateInMillisecond = new Date().getTime();
            this.textArea.setText(Long.toString(dateInMillisecond));
        }
    }
}
