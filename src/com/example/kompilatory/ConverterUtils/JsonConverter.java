package com.example.kompilatory.ConverterUtils;

import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        File file = new File(filePath);
        StringBuilder output = new StringBuilder();

        Pattern opening = Pattern.compile("(\")([a-zA-Z0-9]+)(\": [{\\[])");
        Pattern oneLine = Pattern.compile("([\\s]+)(\")([a-zA-Z0-9]+)(\": \")([^\"]+)(\"[,]?)");
        Pattern arrayEl = Pattern.compile("(\")([^\"]+)(\"[,]?)");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                Matcher openingMatcher = opening.matcher(st);
                Matcher oneLineMatcher = oneLine.matcher(st);
                Matcher arrayElMatcher = arrayEl.matcher(st);

                if (openingMatcher.find()) {
                    output.append(openingMatcher.replaceFirst("$2:"));
                    output.append('\n');
                } else if (oneLineMatcher.find()){
                    output.append(oneLineMatcher.replaceFirst("$$13: $5"));
                    output.append('\n');
                } else if (arrayElMatcher.find()){
                    output.append(arrayElMatcher.replaceFirst("\t- $2"));
                    output.append('\n');
                }
            }
            System.out.println(output.toString());
        }catch (Exception e){
            output = null;
            System.out.println(e.getMessage());
        }

        return output.toString();
    }

    @Override
    public String convertToXml(String filePath) {

        File file = new File(filePath);
        Stack<String> closers = new Stack<>();
        StringBuilder output = new StringBuilder();

        Pattern opening = Pattern.compile("(\")([a-zA-Z0-9]+)(\": [{\\[])");
        Pattern oneLine = Pattern.compile("([\\s]+)(\")([a-zA-Z0-9]+)(\": \")([^\"]+)(\"[,]?)");
        Pattern closure = Pattern.compile("([}\\]][,]?)");
        Pattern arrayEl = Pattern.compile("(\")([^\"]+)(\"[,]?)");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                Matcher openingMatcher = opening.matcher(st);
                Matcher oneLineMatcher = oneLine.matcher(st);
                Matcher closureMatcher = closure.matcher(st);
                Matcher arrayElMatcher = arrayEl.matcher(st);

                if (openingMatcher.find()) {
                    output.append(openingMatcher.replaceFirst("<$2>"));
                    closers.push(openingMatcher.group(2));
                    output.append('\n');
                } else if (oneLineMatcher.find()){
                    output.append(oneLineMatcher.replaceFirst("$1<$3>\n\t$1$5\n$1</$3>"));
                    output.append('\n');
                } else if (closureMatcher.find()){
                    if (!closers.empty()) {
                        output.append(closureMatcher.replaceFirst("</" + closers.pop() + ">"));
                        output.append('\n');
                    }
                } else if (arrayElMatcher.find()){
                    output.append(arrayElMatcher.replaceFirst("<item>$2</item>"));
                    output.append('\n');
                }
            }
        }catch (Exception e){
            output = null;
            System.out.println(e.getMessage());
        }

        return output.toString();
    }

    @Override
    public String convertToJson(String filePath) {
        return null;
    }
}
