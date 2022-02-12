/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covidWS;

import entity.Covid;

public class WSUtils {
    
      public static CovidData newCovid(Covid covidInput){
        CovidData covid = new CovidData();
        covid.setIsoCode(covidInput.getIsoCode());
        covid.setDate(covidInput.getDate1());
        covid.setTotalCases(covidInput.getTotalCases());
        covid.setNewCases(covidInput.getNewCases());
        covid.setNewCasesSmoothed(covidInput.getNewCasesSmoothed());
        covid.setTotalDeaths(covidInput.getTotalDeaths());
        covid.setNewDeaths(covidInput.getNewDeaths());
        covid.setNewDeathsSmoothed(covidInput.getNewDeathsSmoothed());
        covid.setReproductionRate(covidInput.getReproductionRate());
        covid.setNewTests(covidInput.getNewTests());
        covid.setTotalTests(covidInput.getTotalTests());
        covid.setStringencyIndex(covidInput.getStringencyIndex());
        covid.setNewDeathsPerCase(covidInput.getNewDeathsPerCase());
        return covid;
    }
    
}
