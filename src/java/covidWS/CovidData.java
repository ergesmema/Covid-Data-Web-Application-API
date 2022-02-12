/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covidWS;

import java.util.Date;


public class CovidData {
    private String isoCode;
    private Date date;
    private Long totalCases;
    private Long newCases;
    private Double newCasesSmoothed;
    private Long totalDeaths;
    private Long newDeaths;
    private Double newDeathsSmoothed;
    private Double reproductionRate;
    private Long newTests;
    private Long totalTests;
    private Double stringencyIndex;
    private Double newDeathsPerCase;

    
    public CovidData(){}
    
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public Long getNewCases() {
        return newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Double getNewCasesSmoothed() {
        return newCasesSmoothed;
    }

    public void setNewCasesSmoothed(Double newCasesSmoothed) {
        this.newCasesSmoothed = newCasesSmoothed;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Double getNewDeathsSmoothed() {
        return newDeathsSmoothed;
    }

    public void setNewDeathsSmoothed(Double newDeathsSmoothed) {
        this.newDeathsSmoothed = newDeathsSmoothed;
    }

    public Double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public Long getNewTests() {
        return newTests;
    }

    public void setNewTests(Long newTests) {
        this.newTests = newTests;
    }

    public Long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Long totalTests) {
        this.totalTests = totalTests;
    }

    public Double getStringencyIndex() {
        return stringencyIndex;
    }

    public void setStringencyIndex(Double stringencyIndex) {
        this.stringencyIndex = stringencyIndex;
    }

    public Double getNewDeathsPerCase() {
        return newDeathsPerCase;
    }

    public void setNewDeathsPerCase(Double newDeathsPerCase) {
        this.newDeathsPerCase = newDeathsPerCase;
    }
    
    
    

    
}
