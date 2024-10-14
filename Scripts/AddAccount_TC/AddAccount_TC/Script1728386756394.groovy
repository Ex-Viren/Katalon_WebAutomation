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

try {
    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.navigateToUrl(GlobalVariable.NewUsers)

    String currentURL = WebUI.getUrl()

    //WebUI.navigateToUrl('https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login')
    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Navigated to URL: ' + currentURL)

    WebUI.click(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/button_Bank Manager Login'))

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Click on the bank manager login')

    WebUI.click(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/button_Add Customer'))

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Page navigate to manager login successfully')

    WebUI.setText(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/input_First Name_form-control ng-pristine n_693e51'), 
        'Viren')

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Enter valid first name')

    WebUI.setText(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/input_Last Name_form-control ng-pristine ng_64913d'), 
        'Chauhan')

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Enter valid last name')

    WebUI.setText(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/input_Post Code_form-control ng-pristine ng_b8fd27'), 
        '392001')

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Enter valid post code')

    WebUI.click(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/button_Add Customer_1'))

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Click on the Add customer button')

    WebUI.click(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/button_Customers'))

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Click on the customer button')

    WebUI.setText(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/input_First Name_form-control ng-pristine n_693e51'), 
        'Viren')

    WebUI.verifyTextPresent('Viren!', true)

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Search registered customer name')

    //    WebUI.click(findTestObject('Object Repository/AddAccount/Page_XYZ Bank/button_Delete'))
    //
    //    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Deleted registered customer name')
    WebUI.closeBrowser()

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Browser close successfully')
}
catch (Exception e) {
    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('An error occurred: ' + e.getMessage())

    CustomKeywords.'com.katalon.extent.report.ExtentReport.addScreenshot'()

    WebUI.closeBrowser()

    throw e
} 

