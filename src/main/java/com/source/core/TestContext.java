package com.source.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.ArrayList;

public class TestContext {
    DriverManager driverManager;
    PageObjectManager pageObjectManager;
    ScenarioContext scenarioContext;

    public void contextSetup(Scenario scenario){
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.launchDriver(scenario.getName(), (ArrayList<String>) scenario.getSourceTagNames()));
        scenarioContext = new ScenarioContext();
    }

    public DriverManager getDriverManager(){
        return driverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }

    @Before // FOR CUCUMBER BDD SUPPORT
    public void setupCucumberBDD(Scenario scenario){
        System.out.println("Executing Scenario "+scenario.getName());
        this.contextSetup(scenario);
    }

    @After // FOR CUCUMBER BDD SUPPORT
    public void closeAppAndDevice(Scenario scenario) {
        try {
            System.out.println("Execution completed for scenario: "+scenario.getName()+ " with test status - "+scenario.getStatus());
             getDriverManager().getDriver().quit();
        }catch (Exception e){
            System.out.println("Driver not initialized. ");
        }
    }
}
