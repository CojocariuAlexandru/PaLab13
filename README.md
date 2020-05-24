

# PA Laborator 13

[![Version](https://badge.fury.io/gh/tterb%2FHyde.svg)](https://badge.fury.io/gh/tterb%2FHyde)

## Students

  - Cojocariu Alexandru, II A2

## Description

This project implements an application for displaying information about locales. All the messages are configurable, the user can select the locale to be used by typing the country's name.

## Features

  - (Compulsory) All the .properties files are in the 'res' package
  - (Compulsory) All information about a locale can be displayed on screen
  - (Compulsory) A loop of reading commands is implemented and all messages are configurable
  - (Optional) Also I have a .properties file for the commands and i use them in order to configure the commands names
  
 ```
  String baseName = "res.Commands";
  messages = ResourceBundle.getBundle(baseName, Locale.getDefault());
  getCommand = messages.getString("info-locale.command");
  setCommand = messages.getString("set-locale.command");
  exitCommand = messages.getString("info-locale.exit");
 ```
## Not resolved

  - (Optional) Calling an external API to display additional information about a country
  
