package com.agh.kompilatory.ConverterUtils.Xml;


import com.agh.kompilatory.ConverterUtils.IConverter;

import java.io.FileNotFoundException;


public class XmlConverter implements IConverter {

    private static final XmlConverter INSTANCE = new XmlConverter();

    private XmlConverter(){}

    public static XmlConverter getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean validateFile(String filePath) {
        return false;
    }

    @Override
    public String convertToXml(String filePath) throws FileNotFoundException {
        throw new FileNotFoundException("Converting to same format not allowed");
    }
    @Override
    public String convertToYaml(String filePath) {
        return null;
    }
    @Override
    public String convertToCsv(String filePath) {
        return null;
    }
    @Override
    public String convertToJson(String filePath) {
        return null;
    }

}
