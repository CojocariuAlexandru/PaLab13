package com;

import app.LocaleExplore;

import java.util.Locale;


/**
 * Calls the application loop
 */
public class Main {
    private static LocaleExplore localeExplore;

    public static void main(String[] args) {
        localeExplore = new LocaleExplore();
        localeExplore.startApplication();
    }
}
