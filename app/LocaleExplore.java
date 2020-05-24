package app;

import com.GetLocale;
import com.Info;
import com.SetLocale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Reads commands from the user and executes them in a loop
 */

public class LocaleExplore {
    private Scanner scanner;
    private String command;
    private String currentLocaleMessage;
    private String informationAboutMessage;
    private String promptMessage;
    private String availableLocalesMessage;
    private String invalidMessage;
    private String currentCountry;
    private String setCommand;
    private String getCommand;
    private String exitCommand;
    private Info informationDisplayer;
    private GetLocale localeGetter;
    private SetLocale localeSetter;
    private ResourceBundle resourceBundle;
    private ResourceBundle messages;
    boolean isLanguageRO;

    public LocaleExplore(){
        scanner = new Scanner(System.in);
        informationDisplayer = new Info();
        localeGetter = new GetLocale();
        localeSetter = new SetLocale();
    }

    /**
     * The application loop is implemented here
     */
    public void startApplication(){
        while(true){
            //Ask for language in order to use the appropriate locale
            System.out.println("Language? (RO/EN)");
            command = scanner.nextLine();
            if(command.compareTo("RO") == 0){
                isLanguageRO = true;
                break;
            }
            else if(command.compareTo("EN") == 0){
                isLanguageRO = false;
                break;
            }
            else{
                System.out.println("Please choose a valid option");
            }
        }

        // Once we have the language, prepare the messages
        if(isLanguageRO == true){
            prepareMessagesToUser(Locale.forLanguageTag("ro"));
        }
        else{
            prepareMessagesToUser(Locale.getDefault());
        }

        // Everything is set up so we can start reading commands
        startReadingCommands();
    }

    /**
     * Implements the which reads and implements commands
     */
    public void startReadingCommands(){
        while(true){
            System.out.println(promptMessage);
            command = scanner.nextLine();

            //If exit, break the loop
            if(command.compareTo(exitCommand) == 0){
                break;
            }
            //If set, read the name of country which is wished to be the current locale
            else if(command.compareTo(setCommand) == 0){
                command = scanner.nextLine();
                localeSetter.setCurrentLocale(localeGetter.getLocaleByName(command));
                currentCountry = command;
            }
            //If get, display on screen information about that country
            else if(command.compareTo(getCommand) == 0){
                updateInformationAboutMessage(currentCountry);
                System.out.println(informationAboutMessage);
                informationDisplayer.displayInformationLocale();
            }
            //Else, print an invalid message
            else{
                System.out.println(invalidMessage);
            }
        }
    }


    /**
     * Prepare the messages which corresponds to the locale
     */
    private void prepareMessagesToUser(Locale currentLocale){
        String baseName = "res.Commands";
        messages = ResourceBundle.getBundle(baseName, Locale.getDefault());
        getCommand = messages.getString("info-locale.command");
        setCommand = messages.getString("set-locale.command");
        exitCommand = messages.getString("info-locale.exit");


        baseName = "res.Messages";
        messages = ResourceBundle.getBundle(baseName, currentLocale);

        promptMessage = messages.getString("prompt");
        availableLocalesMessage = messages.getString("locales");
        invalidMessage = messages.getString("invalid");

        String patternLocaleSet = messages.getString("locale.set");
        Object argumentsLocaleSet[] = {currentLocale.getDisplayLanguage()};
        currentLocaleMessage = new MessageFormat(patternLocaleSet).format(argumentsLocaleSet);


    }

    /**
     * Update the parameter from the file '.properties'.
     * Like in "Information about {0}:"
     * @param country
     */
    private void updateInformationAboutMessage(String country){
        String patternInfo = messages.getString("info");
        Object arguments[] = {country};
        informationAboutMessage = new MessageFormat(patternInfo).format(arguments);
    }
}
