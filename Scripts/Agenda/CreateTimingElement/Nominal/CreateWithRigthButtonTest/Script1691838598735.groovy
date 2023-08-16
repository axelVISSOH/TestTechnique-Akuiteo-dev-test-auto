import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import static org.junit.Assert.*

def driver = DriverFactory.getWebDriver()

WebUI.callTestCase(findTestCase('Agenda/NavigateToAgendaTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Agenda/button_Crer'))

WebUI.callTestCase(findTestCase('Agenda/FillForm/FillTimeCreationFormTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Valider'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Agenda/div_Optimal Compta'), 'Optimal Compta')

assertEquals('Optimal Compta / 5h00\nTâche de test 06\nDéplacement', driver.findElement(By.xpath('//*[@id="ui-id-1"]/div[1]/div[2]/small/small')).getText())

driver.findElement(By.xpath('//*[@id="ui-id-1"]/div[2]')).click()

assertTrue(driver.findElement(By.className('fa-trash')).isDisplayed())

driver.findElement(By.className('fa-trash')).click()

WebUI.click(findTestObject('Object Repository/Page_Agenda/button_Ok'))

try {
    driver.findElement(By.xpath('//*[@id="ui-id-1"]/div[2]'))
}
catch (Exception e) {
    assertTrue(e.getMessage().contains('no such element: Unable to locate element:'))
} 

WebUI.closeBrowser()

