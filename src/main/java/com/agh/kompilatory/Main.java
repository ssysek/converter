package com.agh.kompilatory;

import com.agh.kompilatory.ConverterUtils.Converter;
import com.agh.kompilatory.ConverterUtils.Utils;
import com.agh.kompilatory.Exceptions.InvalidFileFormatException;
import com.agh.kompilatory.Providers.ConversionType;
import com.agh.kompilatory.Validators.InputFileValidator;

public class Main {

    public static void main(String[] args) {
        String filePath = "MOCK_DATA.csv";
        String outputFilePath = "MOCK_DATA.xml";
        ConversionType outputConversionType = ConversionType.XML;
        if (InputFileValidator.validate(filePath)) {
            try {
                ConversionType inputConversionType = Utils.getInputFileType(filePath);
                Converter converter = new Converter(filePath, outputFilePath, inputConversionType, outputConversionType, true);
                converter.convert();

            }
            catch (InvalidFileFormatException e) {
                System.out.println(e.getMessage() + " " + e.getErrorLine());
            }

        }
    }
}
