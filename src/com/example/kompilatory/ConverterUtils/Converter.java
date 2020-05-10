package com.example.kompilatory.ConverterUtils;

import com.example.kompilatory.ConverterUtils.Csv.CsvConverter;
import com.example.kompilatory.ConverterUtils.Json.JsonConverter;
import com.example.kompilatory.Providers.ConversionType;

public class Converter {
    private IConverter converter;
    private ConversionType outputType;
    private String inputPath;
    private String outputPath;
    private boolean csvHasHeaders = false;

    public Converter(String inputPath, String outputPath, ConversionType inputType, ConversionType outputType, boolean csvHasHeaders) {
        this.csvHasHeaders = csvHasHeaders;
        setConverter(inputType);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.outputType = outputType;
    }

    public Converter(String inputPath, String outputPath, ConversionType inputType, ConversionType outputType) {
        setConverter(inputType);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.outputType = outputType;
    }

    public void convert() {
        String outputFileContent = null;

        try {
            switch (outputType) {
                case JSON:
                    outputFileContent = converter.convertToJson(inputPath);
                    break;
                case XML:
                    outputFileContent = converter.convertToXml(inputPath);
                    break;
                case CSV:
                    outputFileContent = converter.convertToCsv(inputPath);
                    break;
                case YAML:
                    outputFileContent = converter.convertToYaml(inputPath);
                    break;
            }
            Utils.saveFile(outputFileContent, outputPath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setConverter(ConversionType inputType) {

        switch (inputType) {
            case JSON:
                this.converter = JsonConverter.getInstance();
                break;
            case XML:
                break;
            case CSV:
                this.converter = CsvConverter.getInstance();
                ((CsvConverter) this.converter).setHasHeaders(this.isCsvHasHeaders());
            case YAML:
                break;
        }
    }

    private boolean isCsvHasHeaders() {
        return csvHasHeaders;
    }
}
