package com.example.kompilatory.ConverterUtils;

import com.example.kompilatory.Providers.ConversionType;

public class Converter {
    private IConverter converter;
    private ConversionType outputType;
    private String inputPath;
    private String outputPath;

    public Converter(String inputPath, String outputPath, ConversionType inputType, ConversionType outputType){
        setConverter(inputType);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.outputType = outputType;
    }

    public void convert(){
        String outputFileContent = null;

        switch (outputType){
            case JSON:
                outputFileContent = converter.convertToJson(inputPath);
                break;
            case XML:
                break;
            case CSV:
                break;
            case YAML:
                break;
        }
        Utils.saveFile(outputFileContent, outputPath);
    }

    private void setConverter(ConversionType inputType){
        switch (inputType){
            case JSON:
                this.converter = JsonConverter.getInstance();
                break;
            case XML:
                break;
            case CSV:
                break;
            case YAML:
                break;
        }
    }
}
