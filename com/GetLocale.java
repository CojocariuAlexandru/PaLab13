package com;

import app.LocaleExplore;

import java.util.Locale;

/**
 * Gets a locale by country name
 */

public class GetLocale {
    private Locale availableLocales[] = Locale.getAvailableLocales();

    /**
     * Gets a locale by country name 'localeName'
     * @param localeName
     * @return
     */
    public Locale getLocaleByName(String localeName){
        for(Locale locale : availableLocales){
            if(locale.getDisplayCountry().compareTo(localeName) == 0){
                return locale;
            }
        }
        return null;
    }
}
