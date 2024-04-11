import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

'Open the \'Notepad\' application.'
Windows.startApplicationWithTitle('C:\\Windows\\notepad.exe', 'notepad')

'Enter the required text in the text area field.'
Windows.setText(findWindowsObject('NotepadObjects/txt_mainTextArea'), Text)

'Click on the \'File\' menu.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_fileMenu'))

'Click on the \'Save\' option.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_save_fileMenu'))

'Get the location of the current project directory.'
String dirName = RunConfiguration.getProjectDir()

'Set the location of the file.'
String fileLocation = (dirName.replace('/', '\\') + '\\OutputFiles\\NotepadFiles\\') + FileName

'Enter the file name in the \'File Name\' field on the \'Save As\' popup.'
Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_fileName_saveAsPopUp'), fileLocation)

'Click on the \'Save\' button on the \'Save As\' popup.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_save_saveAsPopUp'))

'If \'Confirm Save As\' popup is displayed click on the \'Save\' button.'
try {
    if (Windows.verifyElementPresent(findWindowsObject('NotepadObjects/btn_save_confirmSaveAsPopUp'), 10)) {
        Windows.click(findWindowsObject('NotepadObjects/btn_save_confirmSaveAsPopUp'))
    }
}
catch (Exception e) {
    println('The \'Confirm Save As\' popup is not displayed.')
} 

'Get the name of the tab.'
actualTabName = (Windows.getText(findWindowsObject('NotepadObjects/ele_tabName')).split('\\.')[0])

'Verify that the actual name of the tab is equal to the saved File name.'
Windows.verifyEqual(actualTabName, FileName)

'Click on the \'Edit\' menu.'
Windows.click(findWindowsObject('NotepadObjects/btn_editMenu'))

'Click on the option \'Replace\' under Edit menu.'
Windows.click(findWindowsObject('NotepadObjects/btn_replace_editMenu'))

'Clear the text in the Find field.'
Windows.clearText(findWindowsObject('NotepadObjects/txt_find_replacePopUp'))

'Enter the required text to be replaced in the Find field.'
Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_find_replacePopUp'), Text)

'Clear the text in the Replace field.'
Windows.clearText(findWindowsObject('Object Repository/NotepadObjects/txt_replace_replacePopUp'))

'Enter the new text in the Replace field.'
Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_replace_replacePopUp'), NewText)

'Click on the \'Replace\' button on the Replace pop up.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_replace_replacePopUp'))

'Click on the \'Close\' icon on the Replace pop up.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_close_replacePopUp'))

'Get the current text in the main text area.'
newText = Windows.getText(findWindowsObject('NotepadObjects/txt_mainTextArea'))

'Verify the current text is equal to the new text.'
Windows.verifyEqual(newText, Text)

'Click on the \'File\' menu.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_fileMenu'))

'Click on the \'Save\' option.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_save_fileMenu'))

'Close the Notepad application.'
Windows.click(findWindowsObject('NotepadObjects/btn_closeWindow'))

