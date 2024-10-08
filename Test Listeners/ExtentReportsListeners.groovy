import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import java.nio.file.Path
import java.nio.file.Paths;
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class ExtentReportsListeners {
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		CustomKeywords.'com.katalon.extent.report.ExtentReport.deleteFolderContents'()
		CustomKeywords.'com.katalon.extent.report.ExtentReport.attachEReport'(testSuiteContext, "Extent Report", "QA Test Report")
	}
	
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		CustomKeywords.'com.katalon.extent.report.ExtentReport.startEReport'(testCaseContext)
	}
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) throws IOException {
		CustomKeywords.'com.katalon.extent.report.ExtentReport.takeScreenshotFailure'(testCaseContext)
	}
	
	@AfterTestSuite
	def sampleAfterTestSuite() {
		CustomKeywords.'com.katalon.extent.report.ExtentReport.flushEReport'()
	}
}