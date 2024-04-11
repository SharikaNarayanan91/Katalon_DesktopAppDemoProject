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

'Get the name of the existing tab.'
String existingTabName = Windows.getText(findWindowsObject('NotepadObjects/ele_tabName')).split('\\.')[0]

'If the name of the existing tab is not equal to \'Untitled\', click add new tab icon.'
if (!(existingTabName.equals('Untitled'))) {
    Windows.click(findWindowsObject('NotepadObjects/btn_newTab'))
}

'Enter the required text in the text area field.'
Windows.setText(findWindowsObject('NotepadObjects/txt_mainTextArea'), Text)

'Click on the \'File\' menu.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_fileMenu'))

'Click on the \'Save\' option.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_save_fileMenu'))

'Get location of the current project directory.'
String dirName = RunConfiguration.projectDir

'Set the file location.'
String fileLocation = (dirName.replace('/', '\\') + '\\OutputFiles\\NotepadFiles\\') + FileName

'Enter the required name of the file in the \'File Name\' field on the \'Save As\' popup.'
Windows.setText(findWindowsObject('Object Repository/NotepadObjects/txt_fileName_saveAsPopUp'), fileLocation)

'Click on the \'Save\' button on the \'Save As\' popup.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_save_saveAsPopUp'))

'If \'Confirm Save As\' popup is displayed click on the \'Save\' '
try {
    if (Windows.verifyElementPresent(findWindowsObject('NotepadObjects/btn_save_confirmSaveAsPopUp'), 10) == true) {
        Windows.click(findWindowsObject('NotepadObjects/btn_save_confirmSaveAsPopUp'))
    }
}
catch (Exception e) {
    println('The \'Confirm Save As\' popup is not displayed.')
} 

'Get the name of the tab.'
newTabName = (Windows.getText(findWindowsObject('NotepadObjects/ele_tabName')).split('\\.')[0])

'Verify that the actual name of the tab is equal to the saved File name.'
Windows.verifyEqual(newTabName, FileName)

'Click on the \'File\' menu.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_fileMenu'))

'Click on the \'Close Tab\' option.'
Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_closeTab_fileMenu'))

'Close the tab if a tab is still open.'
try {
    if (Windows.verifyElementPresent(findWindowsObject('NotepadObjects/ele_tabName'), 10)) {
        // Click on the 'File' menu.
        Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_fileMenu'))

        // Click on the 'Close Tab' option.
        Windows.click(findWindowsObject('Object Repository/NotepadObjects/btn_closeTab_fileMenu'))
    }
}
catch (Exception e) {
    println('The application is closed')
} 

