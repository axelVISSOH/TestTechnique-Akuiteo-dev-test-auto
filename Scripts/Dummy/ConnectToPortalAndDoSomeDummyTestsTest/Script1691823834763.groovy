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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://akuiteo-recrut-qa.akuiteo.fr/akuiteo.collabs')

WebUI.setText(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/input_Connexion_username'), 'axel.vissoh')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/input_Connexion_password'), '08wzdkwaLOEVYYvCmYsXSw==')

WebUI.click(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/i_Connexion_password-icon'))

WebUI.click(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/span_Connexion'))

WebUI.navigateToUrl('https://akuiteo-recrut-qa.akuiteo.fr/akuiteo.collabs/a#/employees/expenses')

not_run: WebUI.click(findTestObject('Object Repository/Page_Notes de frais/span_Agenda'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Mon activit'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Mes temps passs/span_Demandes dabsence'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Demandes dabsence/span_Notes de frais'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Notes de frais/a_Agenda'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/i_ven. 11_fa fa-plus'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/div_Temps                        Planning  _bd4560'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/a_Fermer'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/h2_S32  Du 7  au 13 aot 2023'))

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Agenda/h2_S32  Du 7  au 13 aot 2023'), 0)

not_run: WebUI.rightClick(findTestObject('Object Repository/Page_Agenda/button_mer. 9_add-material-button btn-warning'))

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Agenda/i_ven. 11_fa fa-plus'), 0)

not_run: WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Agenda/i_ven. 11_fa fa-plus'))

not_run: WebUI.closeBrowser()

not_run: WebUI.navigateToUrl('https://akuiteo-recrut-qa.akuiteo.fr/akuiteo.collabs/login/login.html')

not_run: WebUI.setText(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/input_Connexion_username'), 'axel.vissoh')

not_run: WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/input_Connexion_password'), 
    '08wzdkwaLOEVYYvCmYsXSw==')

not_run: WebUI.click(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/i_Connexion_password-icon'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Login - Akuiteo Collabs/span_Connexion'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Notes de frais/span_Agenda'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/span_Mon activit'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Mes temps passs/span_Demandes dabsence'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Demandes dabsence/span_Notes de frais'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Notes de frais/a_Agenda'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/i_ven. 11_fa fa-plus'))

not_run: WebUI.click(findTestObject('Object Repository/Page_Agenda/a_Fermer'))

WebUI.click(findTestObject('Object Repository/Page_Agenda/div_Optimal Compta  3h30Tche de test 06Abse_dca116'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Agenda/div_Optimal Compta  3h30Tche de test 06Abse_dca116'))

WebUI.doubleClick(findTestObject('Object Repository/Page_Agenda/div_Optimal Compta  3h30Tche de test 06Abse_dca116'))

WebUI.click(findTestObject('Object Repository/Page_Agenda/a_Fermer'))

WebUI.closeBrowser()

