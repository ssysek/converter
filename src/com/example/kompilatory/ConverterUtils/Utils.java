package com.example.kompilatory.ConverterUtils;

import com.example.kompilatory.Exceptions.InvalidFileFormatException;
import com.example.kompilatory.Providers.ConversionType;

public class Utils {
    public static ConversionType getInputFileType(String filePath) throws InvalidFileFormatException {
        if (filePath.endsWith(".json"))
            return ConversionType.JSON;
        else if (filePath.endsWith(".csv"))
            return ConversionType.CSV;
        else if (filePath.endsWith(".yaml"))
            return ConversionType.YAML;
        else if (filePath.endsWith(".xml"))
            return ConversionType.XML;
        else
            throw new InvalidFileFormatException("Nie rozpoznano formatu");
    }

    public static void saveFile(String fileContent, String outputPath){

    }
}
