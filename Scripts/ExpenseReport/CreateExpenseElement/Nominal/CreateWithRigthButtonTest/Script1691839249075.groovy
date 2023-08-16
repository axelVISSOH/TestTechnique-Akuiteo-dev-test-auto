import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.junit.Assert.*
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import helpers.TestSimpleHeper as TestSimpleHeper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('ExpenseReport/NavigateToExpenseReportTest'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Login/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

Date dateForTest = new Date()

driver.findElement(By.className('new-expense')).click()

assertTrue(driver.findElement(By.className('expense-form-container')).isDisplayed())

//driver.findElement(By.cssSelector("mat-icon[data-mat-icon-name='fa-caret-down']")).click()
//assertTrue(driver.findElement(By.id("mat-autocomplete-1")).isDisplayed())
//Nature
driver.findElement(By.id('mat-input-2')).click()

//driver.findElement(By.id("mat-input-2")).sendKeys("Avion")
driver.findElement(By.id('mat-option-8')).click()

//verify todaydate is set
assertEquals(TestSimpleHeper.generateDateDisplay(dateForTest, 'dd/MM/yyyy'), driver.findElement(By.id('mat-input-3')).getAttribute(
        'value'))

//amount
driver.findElement(By.id('mat-input-5')).click()

driver.findElement(By.id('mat-input-5')).sendKeys('1000')

//tva
driver.findElement(By.id('mat-input-10')).click()

driver.findElement(By.id('mat-option-17')).click()

//driver.findElement(By.id("mat-input-10")).sendKeys("01 (20 %)")
//amount after tva
//assertEquals("166,67", driver.findElement(By.id("mat-input-11")).getText())
//Comment
driver.findElement(By.id('mat-input-16')).click()

driver.findElement(By.id('mat-input-16')).sendKeys('Avion')

//client
driver.findElement(By.id('mat-input-19')).click()

driver.findElement(By.id('mat-input-19')).sendKeys('C9006 - Zodiac conception')

//afectation
JavascriptExecutor jsExecutor = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

jsExecutor.executeScript('arguments[0].scrollIntoView(true);', driver.findElement(By.cssSelector('div[class=\'description\']')))

//class="mat-button-height-30 mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base ng-star-inserted"
driver.findElement(By.xpath('/html/body/app-root/ng-component/ak-app-overlay/ng-component/akm-form/form/akm-form-content/fieldset/div[10]/com-assignment-form-field/div[2]/mat-form-field/div[1]/div[2]/div/div/button')).click()

driver.findElement(By.id('mat-input-22')).click()

driver.findElement(By.id('mat-input-22')).sendKeys('ZOD')

Thread.sleep(5000 //bad practice
    )

//WebDriverWait wait = WebDriverWait(driver, 15)
//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"cdk-overlay-6\"]/com-assignment-modal-list/com-assignment-list/div[2]/mat-action-list/button[4]/span/div/span"))))
driver.findElement(By.xpath('//*[@id="cdk-overlay-6"]/com-assignment-modal-list/com-assignment-list/div[2]/mat-action-list/button[4]')).click()

//driver.findElement(By.cssSelector("button[class='PROJECT']"))
//refacturable
//driver.findElement(By.id("mat-mdc-checkbox-1-input")).click()
//assertEquals("Avion", driver.findElement(By.id("mat-input-2")).getAttribute("value"))
//assertEquals("1 000,00", driver.findElement(By.id("mat-input-5")).getAttribute("value"))
//assertEquals("EUR", driver.findElement(By.id("mat-input-5")).getAttribute("value"))
//assertEquals("Avion", driver.findElement(By.id("mat-input-16")).getAttribute("value"))
//assertEquals("C9006 - Zodiac conception", driver.findElement(By.id("mat-input-19")).getAttribute("value"))
//assertEquals("Zodiac conception", driver.findElement(By.cssSelector("div[class='description']")).getText())
//save
driver.findElement(By.xpath('/html/body/app-root/ng-component/ak-app-overlay/ng-component/akm-form/form/akm-form-footer/div/div[2]/button[2]')).click()

assertTrue(driver.findElement(By.xpath('/html/body/app-root/ak-app-root/div/div/ng-component/ng-component/ng-component/ak-expense-report[1]/table/tbody/tr')).isDisplayed())

assertTrue(driver.findElement(By.xpath('/html/body/app-root/ak-app-root/div/div/ng-component/ng-component/ng-component/ak-expense-report[1]/table/tbody/tr/td[5]/div/div/div')).getText().equals(
        '1 000,00 €'))

//delete
driver.findElement(By.xpath('/html/body/app-root/ak-app-root/div/div/ng-component/ng-component/ng-component/ak-expense-report[1]/table/thead/tr/th[3]/div/ak-expense-report-actions/button')).click()

driver.findElement(By.xpath('//*[@id="mat-menu-panel-3"]/div/button[2]')).click()

driver.findElement(By.xpath('//*[@id="mat-mdc-dialog-1"]/div/div/akm-confirm-popup/div/div[2]/div/button[2]')).click()

WebUI.closeBrowser()

