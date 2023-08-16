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

import org.openqa.selenium.By
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver

import static org.junit.Assert.*

def driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Runion visio_input-group-addon input-g_5495f8'))

WebUI.click(findTestObject('Object Repository/Page_Agenda/div_Optimal Compta (OPTI-COMPT)'))

WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Runion visio_input-group-addon input-g_5495f8_1'))

WebUI.click(findTestObject('Object Repository/Page_Agenda/div_Dplacement (DPMNT)'))

WebUI.setText(findTestObject('Object Repository/Page_Agenda/input_Runion visio_duree'), '5')

String xpathSelector = "//*[@id=\"calendarEventForm\"]/div[1]/div[2]/div[11]/div/div/span[2]"
driver.findElement(By.xpath(xpathSelector)).click()

WebUI.click(findTestObject('Object Repository/Page_Agenda/div_CHESSY  Optimal Compta  9 impasse du but'))

assertEquals("Optimal Compta", driver.findElement(By.id("nomAppelClient")).getAttribute("value"))
assertEquals("Optimal Compta", driver.findElement(By.id("nomAffaire")).getAttribute("value"))
assertEquals("Tâche de test 06", driver.findElement(By.id("libelleTache")).getAttribute("value"))
assertEquals("Déplacement", driver.findElement(By.id("nomAction")).getAttribute("value"))
assertEquals("5", driver.findElement(By.id("duree")).getAttribute("value"))
assertEquals("CHESSY", driver.findElement(By.id("lieu")).getAttribute("value"))
assertEquals("Déplacement", driver.findElement(By.id("commentaire")).getAttribute("value"))
