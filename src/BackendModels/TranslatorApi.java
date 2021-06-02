/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendModels;

public class TranslatorApi {

    private static String URL = "http://translate.google.com/translate?js=n&sl=auto&tl=ja&text=";
    private static String translated;

    public TranslatorApi() {
        //Request http connection
    }

    private static String connect(String str, String language) {
        String text = str;
        //Connect to API and format their data.
        return text;
    }

    public static String getTranslation(String str, String language) {
        //Create API to translate through google translate
        translated = connect(str, language);
        return translated;
    }
}
