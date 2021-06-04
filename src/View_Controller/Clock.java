/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JTextArea;

public class Clock implements Runnable {
    
    private boolean run;
    private JTextArea textArea;
    private SimpleDateFormat dateFormat;
    private Date date;
    
    public Clock(JTextArea textArea) {
        this.run = true;
        this.textArea = textArea;
        this.dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));
        this.date = new Date();
    }
    
    @Override
    public void run() {
        while (run) {
            if (!this.run) {
                return;
            }
            this.date = new Date();
            this.textArea.setText(this.dateFormat.format(this.date));
        }
    }
    
    public void stop() {
        this.run = false;
    }
    
    public boolean getCurrentState() {
        return this.run;
    }
}
