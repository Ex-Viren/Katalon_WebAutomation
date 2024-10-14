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

    String expectedURL = 'https://www.saucedemo.com/'

    CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Navigated to URL: ' + currentURL)

    if (currentURL == expectedURL) {
        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('URL matches: ' + currentURL)
    } else {
        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'((('URL mismatch! Expected: ' + expectedURL) + 
            ' but found: ') + currentURL)

        throw new AssertionError((('URL does not match! Expected: ' + expectedURL) + ' but found: ') + currentURL)
    }
    
    WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standarduser')

    String inputString = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 
        'value')

    String regexPattern = '^[a-zA-Z_]+$'

    if (inputString.matches(regexPattern)) {
        WebUI.comment('The string is valid. It contains only alphabets and optional underscores.')

        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Username is invalid. Username should be enter valid formate.')
    } else if (inputString.isEmpty()) {
        WebUI.comment('The input field is empty.')

        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Username field is empty.')
    } else {
        WebUI.comment('The string is invalid. It contains characters besides alphabets and underscores.')

        CustomKeywords.'com.katalon.extent.report.ExtentReport.attachLog'('Username is invalid, Username should be enter valid formate.')
    }
      
    WebUI.setEncryptedText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'qcu24s4901FyWDTwXGr6XA==')
	
	WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

//    WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h3_Epic sadface Username and password do not match any user in this service'), 
//        'Epic sadface: Username and password do not match any user in this service')

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