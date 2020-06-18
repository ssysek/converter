package com.agh.test.kompilatory.conversion;

import com.agh.kompilatory.ConverterUtils.Converter;
import com.agh.kompilatory.Providers.ConversionType;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


class XmlTests {
    //String sampleCsvFile = "mock_data/xml_test_data/CSV-MOCK.csv";
    String sampleJsonFile = "mock_data/xml_test_data/JSON-MOCK.json";
    String sampleYamlFile = "mock_data/xml_test_data/YAML-MOCK.yaml";
    String sampleXmlFile = "mock_data/xml_test_data/XML-MOCK.xml";


    @Test
    public void shouldConvertSampleJsonFileToCorrespondingYaml() throws IOException {
        ConversionType inputConversionType = ConversionType.XML;
        ConversionType outputConversionType = ConversionType.YAML;
        String output = "CONVERTED_XML_TO_YAML.yaml";
        Converter converter = new Converter(sampleXmlFile, output, inputConversionType, outputConversionType, true);
        converter.convert();
        File outputFile = new File(output);
        Assertions.assertTrue(FileUtils.contentEquals(new File(sampleYamlFile), outputFile));
        outputFile.deleteOnExit();
    }

    @Test
    public void shouldConvertSampleXmlFileToCorrespondingJson() throws IOException {
        ConversionType inputConversionType = ConversionType.XML;
        ConversionType outputConversionType = ConversionType.JSON;
        String output = "CONVERTED_XML_TO_JSON.json";
        Converter converter = new Converter(sampleXmlFile, output, inputConversionType, outputConversionType, true);
        converter.convert();
        File outputFile = new File(output);
        Assertions.assertTrue(FileUtils.contentEquals(new File(sampleJsonFile), outputFile));
        outputFile.deleteOnExit();
    }
}