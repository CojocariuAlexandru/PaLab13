package com;

import java.util.Locale;

/**
 * Implements the functionality of setting the current locale
 */

public class SetLocale {
    public void setCurrentLocale(Locale currentLocale){
        Locale.setDefault(currentLocale);
    }
}
