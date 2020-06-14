package com.agh.test.kompilatory.conversion;

import com.agh.kompilatory.ConverterUtils.Converter;
import com.agh.kompilatory.Providers.ConversionType;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


class ConverterTests {
    String sampleCsvFile = "MOCK_DATA.csv";
    String sampleJsonFile = "MOCK_DATA.json";
    String sampleYamlFile = "MOCK_DATA.yaml";
    String sampleXmlFile = "MOCK_DATA.xml";

    @Test
    public void shouldConvertSampleCsvFileToCorrespondingJson() throws IOException {
        ConversionType inputConversionType = ConversionType.CSV;
        ConversionType outputConversionType = ConversionType.JSON;
        String output = "CONVERTED_CSV_TO_JSON.json";
        Converter converter = new Converter(sampleCsvFile, output, inputConversionType, outputConversionType, true);
        converter.convert();
        File outputFile = new File(output);
        Assertions.assertTrue(FileUtils.contentEquals(new File(sampleJsonFile), outputFile));
        outputFile.deleteOnExit();
    }

    @Test
    public void shouldConvertSampleCsvFileToCorrespondingYaml() throws IOException {
        ConversionType inputConversionType = ConversionType.CSV;
        ConversionType outputConversionType = ConversionType.YAML;
        String output = "CONVERTED_CSV_TO_YAML.json";
        Converter converter = new Converter(sampleCsvFile, output, inputConversionType, outputConversionType, true);
        converter.convert();
        File outputFile = new File(output);
        Assertions.assertTrue(FileUtils.contentEquals(new File(sampleYamlFile), outputFile));
        outputFile.deleteOnExit();
    }

    @Test
    public void shouldConvertSampleCsvFileToCorrespondingXml() throws IOException {
        ConversionType inputConversionType = ConversionType.CSV;
        ConversionType outputConversionType = ConversionType.XML;
        String output = "CONVERTED_CSV_TO_XML.json";
        Converter converter = new Converter(sampleCsvFile, output, inputConversionType, outputConversionType, true);
        converter.convert();
        File outputFile = new File(output);
        Assertions.assertTrue(FileUtils.contentEquals(new File(sampleXmlFile), outputFile));
        outputFile.deleteOnExit();
    }
}