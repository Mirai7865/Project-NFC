/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

public class Loc {

    private String language;

    public Loc() {
        this.setLanguage();
    }

    private void setLanguage() {
        language = System.getProperty("user.language");
    }

    public String getLanguage() {
        return language;
    }
}
