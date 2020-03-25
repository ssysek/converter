package com.example.kompilatory.ConverterUtils;

public class JsonConverter implements IConverter{

    private static final JsonConverter INSTANCE = new JsonConverter();

    private JsonConverter(){}

    public static JsonConverter getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean validateFile(String filePath) {
        return false;
    }

    @Override
    public String convertToCsv(String filePath) {

        return filePath;
    }

    @Override
    public String convertToYaml(String filePath) {

        return filePath;
    }

    @Override
    public String convertToXml(String filePath) {

        return filePath;
    }

    @Override
    public String convertToJson(String filePath) {

        return filePath;
    }
}
