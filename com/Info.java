package com;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import sun.util.resources.LocaleData;

/**
 * Prints on screen information about a locale
 */

public class Info {
    private DateFormatSymbols dateFormatSymbols;
    private Calendar calendar;
    int firstDayOfWeek;
    int dayOfWeek;
    int firstMonthsOfYear;
    int monthOfYear;

    /**
     * Displays on screen information about a locale.
     * If no parameter is given, use the default locale.
     */
    public void displayInformationLocale(){
        printInformationLocale(Locale.getDefault());
    }

    public void displayInformationLocale(Locale locale) {
        printInformationLocale(locale);
    }


    /**
     * Prints the country, language, curency, days of the week and moths of the year
     * @param locale
     */
    private void printInformationLocale(Locale locale){
        this.dateFormatSymbols = new DateFormatSymbols(locale);
        calendar = Calendar.getInstance(locale);

        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + NumberFormat.getCurrencyInstance(locale).format(0d));

        System.out.println("Days of week: ");
        String weekdays[] = dateFormatSymbols.getWeekdays();
        for (dayOfWeek = 0; dayOfWeek < weekdays.length; dayOfWeek++){
            System.out.println("\t" + weekdays[dayOfWeek]);
        }

        System.out.println("Months of the year: ");
        String months[] = dateFormatSymbols.getMonths();
        for(monthOfYear = 0; monthOfYear < months.length; monthOfYear++){
            System.out.println("\t" + months[monthOfYear]);
        }

        System.out.println("Current day: ");
        System.out.println(calendar.getTime());
    }
}
