package com.example.carbcalculator.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url =https://www.calculator.net/carbohydrate-calculator.html
public class CarbCalculatorPage {
    public SelenideElement unitsTabs = $("div#topmenu");
    public SelenideElement ageInput = $("input#cage");
    public SelenideElement genderMaleRadioButton = $("input#csex1");
    public SelenideElement genderFemaleRadioButton = $("input#csex2");
    public SelenideElement heightMetricInput = $("input#cheightmeter");
    public SelenideElement heightFeetInput = $("input#cheightfeet");
    public SelenideElement heightInchInput = $("input#cheightinch");
    public SelenideElement weightMetricInput = $("input#ckg");
    public SelenideElement weightPoundInput = $("input#cpound");
    public SelenideElement activityDropdown = $("select#cactivity");
    public SelenideElement settingsLink = $("div#ccsettingtitle a");
    public SelenideElement settingsContent = $("div#ccsettingcontent");
    public SelenideElement mifflinStJeorRadioButton = $("input#cformula1");
    public SelenideElement katchMcArdleRadioButton = $("input#cformula2");
    public SelenideElement bodyFatInput = $("input.inpct");
    public SelenideElement calculateButton = $("input[name='x']");
    public SelenideElement clearButton = $("input[onclick='clearForm(document.calform);']");

    public SelenideElement usUnitsTab() {
        return unitsTabs.find("li", 0);
    }

}
