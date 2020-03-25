package com.example.kompilatory.ConverterUtils;

import com.example.kompilatory.Exceptions.InvalidFileFormatException;

public interface IConverter {
    //metodka sprawdzająca, czy plik nie ma niezgodności ze swoim formatem - rzuca wyjątek, w którym można rzucić
    //numer linii, w której wystąpił błąd
    public boolean validateFile(String filePath) throws InvalidFileFormatException;

    //metodki zwracające przekonwertowaną treść pliku (może też zwracać to np. w formie byte[], whatever)
    public String convertToCsv(String filePath);
    public String convertToYaml(String filePath);
    public String convertToXml(String filePath);
    public String convertToJson(String filePath);
}
