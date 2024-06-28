package com.example.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeEach
    public void setUp() {
        open("https://www.calculator.net/carbohydrate-calculator.html");
    }

    // Test NT-1
    @Test
    public void testAgeFieldDoesNotAcceptValueLessThan18() {
        mainPage.ageInput.clear();
        mainPage.ageInput.sendKeys("17");
        mainPage.calculateButton.click();
        $("div > div > font[color='red']").shouldBe(visible);
        assertEquals("Please provide an age between 18 and 80.", $("div > div > font[color='red']").getText());
    }

    // Test NT-2
    @Test
    public void testAgeFieldDoesNotAcceptValueGreaterThan80() {
        mainPage.ageInput.clear();
        mainPage.ageInput.sendKeys("81");
        mainPage.calculateButton.click();
        $("div > div > font[color='red']").shouldBe(visible);
        assertEquals("Please provide an age between 18 and 80.", $("div > div > font[color='red']").getText());
    }

    // Test NT-3
    @Test
    public void testAgeFieldDoesNotAcceptValueLessThanZero() {
        mainPage.ageInput.clear();
        mainPage.ageInput.sendKeys("-1");
        $("div#cageifcErr").shouldBe(visible);
        assertEquals("positive numbers only", $("div#cageifcErr").getText());
    }
    // Test FT-1
    @Test
    public void testDefaultValuesMetricUnits() {
        assertEquals("25", mainPage.ageInput.getAttribute("value"));
        assertTrue(mainPage.genderMaleRadioButton.isSelected());
        assertFalse(mainPage.genderFemaleRadioButton.isSelected());
        assertEquals("180", mainPage.heightMetricInput.getAttribute("value"));
        assertEquals("60", mainPage.weightMetricInput.getAttribute("value"));
        assertEquals(6, mainPage.activityDropdown.getOptions().size());
        assertEquals("Light: exercise 1-3 times/week", mainPage.activityDropdown.getSelectedOptionText());
        mainPage.settingsContent.shouldNotBe(visible);
        mainPage.settingsLink.click();
        mainPage.settingsContent.shouldBe(visible);
        assertTrue(mainPage.mifflinStJeorRadioButton.isSelected());
        assertFalse(mainPage.katchMcArdleRadioButton.isSelected());
        assertEquals("20", mainPage.bodyFatInput.getAttribute("value"));
    }

    // Test FT-2 & FT-4
    @Test
    public void testDefaultValuesUSUnits() {
        mainPage.usUnitsTab().click();
        assertEquals("25", mainPage.ageInput.getAttribute("value"));
        assertTrue(mainPage.genderMaleRadioButton.isSelected());
        assertFalse(mainPage.genderFemaleRadioButton.isSelected());
        assertEquals("5", mainPage.heightFeetInput.getAttribute("value"));
        assertEquals("10", mainPage.heightInchInput.getAttribute("value"));
        assertEquals("160", mainPage.weightPoundInput.getAttribute("value"));
        assertEquals(6, mainPage.activityDropdown.getOptions().size());
        assertEquals("Light: exercise 1-3 times/week", mainPage.activityDropdown.getSelectedOptionText());
        mainPage.settingsContent.shouldNotBe(visible);
        mainPage.settingsLink.click();
        mainPage.settingsContent.shouldBe(visible);
        assertTrue(mainPage.mifflinStJeorRadioButton.isSelected());
        assertFalse(mainPage.katchMcArdleRadioButton.isSelected());
        assertEquals("20", mainPage.bodyFatInput.getAttribute("value"));


    }

    // Test FT-3
    @Test
    public void testMetricUnitsTabBMREstimationDefaultValues() {
        mainPage.settingsLink.click();
        mainPage.settingsContent.shouldBe(visible);
        assertTrue(mainPage.mifflinStJeorRadioButton.isSelected());
        assertFalse(mainPage.katchMcArdleRadioButton.isSelected());
        assertEquals("20", mainPage.bodyFatInput.getAttribute("value"));
    }

    // Test FT-3
    @Test
    public void testUSUnitsTabBMREstimationDefaultValues() {
        mainPage.usUnitsTab().click();
        mainPage.settingsLink.click();
        mainPage.settingsContent.shouldBe(visible);
        assertTrue(mainPage.mifflinStJeorRadioButton.isSelected());
        assertFalse(mainPage.katchMcArdleRadioButton.isSelected());
        assertEquals("20", mainPage.bodyFatInput.getAttribute("value"));
    }

    // Test FT-9
    @Test
    public void testClearButtonClearsAllFields() {
        mainPage.clearButton.click();
        assertEquals("", mainPage.ageInput.getAttribute("value"));
        assertEquals("", mainPage.heightMetricInput.getAttribute("value"));
        assertEquals("", mainPage.weightMetricInput.getAttribute("value"));
        mainPage.settingsLink.click();
        assertEquals("", mainPage.bodyFatInput.getAttribute("value"));
    }
}
