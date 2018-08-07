package com.tests.Tests.launcher;

import java.io.FileReader;
import java.util.Map;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class TestNGTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    @org.testng.annotations.Parameters(value={"config","base_url"})
    public void setUp(String config_file, String base_url) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/resources/conf/" + config_file));

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        try {
            Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
            Iterator it = commonCapabilities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(pair.getKey().toString().equals("browserName")){
                    if(pair.getValue().toString().equals("chrome")){
                        driver = new ChromeDriver();
                        break;
                    }else if(pair.getValue().toString().equals("firefox")){
                        driver = new FirefoxDriver();
                        break;
                    }
                }
            }

            try{
                driver.manage().window().maximize();
            }catch (Exception e2){
                e2.printStackTrace();
            }
            driver.get(base_url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        try{
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
