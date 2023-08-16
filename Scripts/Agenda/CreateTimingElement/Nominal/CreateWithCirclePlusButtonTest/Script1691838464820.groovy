import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import helpers.TestSimpleHeper as TestSimpleHeper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Map<String, Date> weekdayDateMap = TestSimpleHeper.generateWeekdayDateMap()

Random randomIndexForDate = new Random()

String dateKey = TestSimpleHeper.getDayOfWeekAbbreviation(randomIndexForDate.nextInt((6 - 2) + 1) + 2)

Date dateForTest = weekdayDateMap.get(dateKey)

WebUI.callTestCase(findTestCase('Agenda/NavigateToAgendaTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebElement circleButtonForDateElement = TestSimpleHeper.getCircleButtonWebElement(driver, dateForTest // Special handling for Sunday
    )

JavascriptExecutor jsExecutor = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

jsExecutor.executeScript('arguments[0].scrollIntoView(true);', circleButtonForDateElement)

circleButtonForDateElement.click()

assertTrue(driver.findElement(By.className('modal-body')).isDisplayed())

String dateDisplay = TestSimpleHeper.generateDateDisplay(dateForTest, 'dd/MM/yyyy')

println(dateDisplay)

assertEquals(dateDisplay, driver.findElement(By.id('date')).getAttribute('value'))

WebUI.callTestCase(findTestCase('Agenda/CreateTimingElement/FillForm/FillTimeCreationFormTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Valider'))

WebUI.acceptAlert()

