package com.agh.kompilatory.ConverterUtils.Xml;


import com.agh.kompilatory.ConverterUtils.IConverter;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;


public class XmlConverter implements IConverter {

    private static final XmlConverter INSTANCE = new XmlConverter();

    private XmlConverter(){}

    public static XmlConverter getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean validateFile(String filePath) {
        return true;
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
        ArrayList<String> content = new ArrayList<String>();
        ArrayList<String> marks = new ArrayList<String>();
        StringBuilder output = new StringBuilder();
        File file = new File(filePath);
        BufferedReader reader;
        output = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String pat1 = ".*<.*>.*</.*>.*";
            String pat2 = ".*<.*>.*";
            String pat3 = ".*</.*>.*";
            Pattern pattern1 = Pattern.compile(pat1);
            Pattern pattern2 = Pattern.compile(pat2);
            Pattern pattern3 = Pattern.compile(pat3);
            boolean matchFound1;
            boolean matchFound2;
            boolean matchFound3;
            int open=0;
            while (line != null) {
                Matcher matcher1 = pattern1.matcher(line);
                matchFound1=matcher1.matches();
                Matcher matcher2 = pattern2.matcher(line);
                matchFound2=matcher2.matches();
                Matcher matcher3 = pattern3.matcher(line);
                matchFound3=matcher3.matches();
                if(line.contains("<?")){
                    output.append("\n");
                }
//                else if(line.contains("root")){
//                  output.append("[");
//                  output.append("\n");
//                }
                else if(matchFound1 && open%2==0){
                    String buff="";
                    String kk="";
                    String kk2="";
                    String res="";
                    boolean flag=false;
                    for (int i = 2; i < line.length(); i++) {
                        if(line.charAt(i-1)=='>'){
                            flag=true;
                        }
                        if(line.charAt(i)=='<' && line.charAt(i+1)=='/'){
                            flag=false;
                        }
                        if(flag){
                            buff+=line.charAt(i);
                        }else{
                            kk+=line.charAt(i);
                        }
                    }
                    kk=kk.replaceAll("\\P{L}+", "");
                    kk2 = kk.substring(0, (kk.length()/2));
                    res="\""+kk2+"\": \""+buff+"\",";
                    //System.out.println(res);
                    output.append(res);
                    output.append("\n");
                } else if(matchFound1 && open%2==1){
                    String buff="";
                    String kk="";
                    String kk2="";
                    String res="";
                    boolean flag=false;
                    for (int i = 2; i < line.length(); i++) {
                        if(line.charAt(i-1)=='>'){
                            flag=true;
                        }
                        if(line.charAt(i)=='<' && line.charAt(i+1)=='/'){
                            flag=false;
                        }
                        if(flag){
                            buff+=line.charAt(i);
                        }else{
                            kk+=line.charAt(i);
                        }
                    }
                    kk=kk.replaceAll("\\P{L}+", "");
                    kk2 = kk.substring(0, (kk.length()/2));
                    res="\""+buff+"\",";
                    //System.out.println(res);
                    output.append(res);
                    output.append("\n");
                } else if(matchFound3) {
                    if (open % 2==1){
                    output.append("],");
                    output.append("\n");}
                    else{
                        output.append("},");
                        output.append("\n");
                    }
                    open-=1;

                }else if(matchFound2) {
                    if (open % 2 == 0) {
                        output.append("\"" + line.replaceAll("\\P{L}+", "") + "\": [");
                    } else {
                        output.append("{");
                    }
                    output.append("\n");
                    open += 1;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

}
