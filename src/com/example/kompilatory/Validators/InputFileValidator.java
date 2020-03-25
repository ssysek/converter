package com.example.kompilatory.Validators;

import jdk.jshell.spi.ExecutionControl;

public class InputFileValidator{
    public static boolean validate(String filePath){
        return (checkFileExtension(filePath) && checkIfFileExists(filePath));
    }

    private static boolean checkIfFileExists(String filePath){
        throw new UnsupportedOperationException();
    }

    private static boolean checkFileExtension(String filePath){
        return filePath.toLowerCase().endsWith(".json")
                || filePath.toLowerCase().endsWith(".xml")
                || filePath.toLowerCase().endsWith("yaml")
                || filePath.toLowerCase().endsWith(".csv");
    }
}
