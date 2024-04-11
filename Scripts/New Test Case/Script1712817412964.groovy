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

Windows.startApplicationWithTitle('C:\\Windows\\notepad.exe', 'notepad')

Windows.getText(findWindowsObject('Object Repository/NotepadObjects/Document'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/MenuItem'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/MenuItem(1)'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/MenuItem'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_replace_editMenu'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/MenuItem'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_replace_editMenu'))

Windows.clearText(findWindowsObject('Object Repository/NotepadObjects/txt_replace_replacePopUp'))

Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_replace_replacePopUp'), 'Welcome to my world')

Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_replace_replacePopUp'), 'Welcome to my worl')

Windows.clearText(findWindowsObject('Object Repository/NotepadObjects/txt_find_replacePopUp'))

Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_find_replacePopUp'), 'Hiiiii My name is KLPLL')

Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_replace_replacePopUp'))

Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_close_replacePopUp'))

Windows.getText(findWindowsObject('Object Repository/NotepadObjects/Document'))

