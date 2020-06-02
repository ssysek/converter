package com.example.kompilatory.ConverterUtils.Xml;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    }
    @Override
    public String convertToCsv(String filePath) {

    }
    @Override
    public String convertToJson(String filePath) {

    }

}
