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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.navigateToUrl(GlobalVariable.G_SiteURL)

    String currentURL = WebUI.getUrl()

    String expectedURL = 'https://www.saucedemocomm/'

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Navigated to URL: ' + currentURL)

    if (currentURL == expectedURL) {
        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('URL matches: ' + currentURL)
    } else {
        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'((('URL mismatch! Expected: ' + expectedURL) + 
            ' but found: ') + currentURL)

        throw new AssertionError((('URL does not match! Expected: ' + expectedURL) + ' but found: ') + currentURL)
    }
    
    WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Enter valid user')

    WebUI.setEncryptedText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'qcu24s4901FyWDTwXGr6XA==')

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Enter valid password')

    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Open Menu'))

    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/a_Logout'))

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Logout successfully')

    WebUI.closeBrowser()

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Browser close successfully')
}
catch (AssertionError e) {
    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Assertion failed: ' + e.getMessage())

    CustomKeywords.'com.katalon.extent.report.ExtentReport.addScreenshot'()

    WebUI.closeBrowser()

    throw e
} 
catch (Exception e) {
    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('An error occurred: ' + e.getMessage())

    CustomKeywords.'com.katalon.extent.report.ExtentReport.addScreenshot'()

    WebUI.closeBrowser()

    throw e
} // Handle assertion errors separately to log failure