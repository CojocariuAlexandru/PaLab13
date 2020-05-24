package com;

import java.util.Locale;

/**
 * Prints all available locales
 */
public class DisplayLocales {
    private Info displayInfo;
    private Locale availableLocales[] = Locale.getAvailableLocales();

    public DisplayLocales(){
        displayInfo = new Info();
    }

    /**
     * Prints on screen all available locales
     */
    public void displayLocales(){
        System.out.println("Available locales:");
        for(Locale locale : availableLocales){
            displayInfo.displayInformationLocale(locale);
            if(locale.getDisplayCountry() == "")
                System.out.print("NO_COUNTRY_NAME");
            else{
                System.out.print(locale.getDisplayCountry());
            }

            System.out.print("   ");

            if(locale.getDisplayLanguage(locale) == ""){
                System.out.println("NO_LANGUAGE_NAME");
            }
            else{
                System.out.println(locale.getDisplayLanguage(locale));
            }
        }
    }
}
