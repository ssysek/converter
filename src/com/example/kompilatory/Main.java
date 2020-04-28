package com.example.kompilatory;

import com.example.kompilatory.ConverterUtils.Converter;
import com.example.kompilatory.ConverterUtils.Utils;
import com.example.kompilatory.Exceptions.InvalidFileFormatException;
import com.example.kompilatory.Providers.ConversionType;
import com.example.kompilatory.Validators.InputFileValidator;

public class Main {

    public static void main(String[] args) {
        String filePath = "test2.json";
        String outputFilePath = "test2.csv";
        ConversionType outputConversionType = ConversionType.CSV;

        if (InputFileValidator.validate(filePath)){
            try{
                ConversionType inputConversionType = Utils.getInputFileType(filePath);
                Converter converter = new Converter(filePath, outputFilePath, inputConversionType, outputConversionType);
                converter.convert();
            } catch (InvalidFileFormatException e){
                System.out.println(e.getMessage() + " " + e.getErrorLine());
            }
        }
    }
}
