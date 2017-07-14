package com.cs504;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;


        try{
            input = new FileInputStream("resource/config.properties");
            prop.load(input);

            String adsDataFilePath = prop.getProperty("adsDataFilePath");
            String budgetDataFilePath = prop.getProperty("budgetDataFilePath");
            String memcachedServer = prop.getProperty("memcachedServer");
            String memcachedPortalStr = prop.getProperty("memcachedPortal");
            int memcachedPortal = Integer.valueOf(memcachedPortalStr);
            String mysqlHost = prop.getProperty("mysqlHost");
            String mysqlDB =  prop.getProperty("mysqlDB");
            String user = prop.getProperty("mysqlDBuser");
            String passwd = prop.getProperty("mysqlDBpassword");
            AdsEngine engine = new AdsEngine(adsDataFilePath, budgetDataFilePath, memcachedServer, memcachedPortal, mysqlHost, mysqlDB, user, passwd);
            boolean indexBuildSuccess = engine.init();
            System.out.println("IndexBuild success = " + indexBuildSuccess);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
