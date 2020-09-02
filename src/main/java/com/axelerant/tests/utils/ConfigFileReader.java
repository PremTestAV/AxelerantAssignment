package com.axelerant.tests.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyfilepath = System.getProperty("user.dir") + "\\" + "config.properties";

    /**
     * Objective: Read the Config File objects based on the input passed. Config.properties stores all the dynamic
     *            information of the project like driver executables, Application URL etc..
     * @Author: Premkumar
     * @Date: 09/01/2020
     */

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyfilepath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at" + propertyfilepath);
        }

    }

    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("ChromeDriverPath");
        if(driverPath!=null){
            return driverPath;
        }else
            throw new RuntimeException("driverPath not specified in the config.properties file");

    }

    public String getFirefoxDriverPath(){
        String driverPath = properties.getProperty("FirefoxDriverPath");
        if(driverPath!=null){
            return driverPath;
        }else
            throw new RuntimeException("driverPath not specified in the config.properties file");

    }

    public String getIEDriverPath(){
        String driverPath = properties.getProperty("IEDriverPath");
        if(driverPath!=null){
            return driverPath;
        }else
            throw new RuntimeException("driverPath not specified in the config.properties file");

    }

    public String getApplicationUrl(){
        String driverPath = properties.getProperty("AppURL");
        if(driverPath!=null){
            return driverPath;
        }else
            throw new RuntimeException("AppURL not specified in the config.properties file");

    }

}
