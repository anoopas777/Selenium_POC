Dim objOutl,dtsnow
dtsnow = Now()
Set objOutl = CreateObject("Outlook.Application")
Set objMailItem = objOutl.CreateItem(olMailItem)
'comment the next line if you do not want to see the outlook window
objMailItem.Subject = "Automation Execution Reports" & Space(1) & dtsnow 
objMailItem.To = "anooas@deloitte.com"
objMailItem.Cc = "anooas@deloitte.com"
objMailItem.Body = "Hi Team,"+ vbNewLine + vbNewLine +"Please find the attached automation execution reports."+ vbNewLine + vbNewLine +"Thanks & Regards,"+ vbNewLine + "Automation Team."
WScript.Sleep 10000
objMailItem.Attachments.Add "C:\Users\anooas\eclipse-workspace\Selenium_POC\test-output\PdfReport\ExtentPdf.pdf"
objMailItem.Attachments.Add "C:\Users\anooas\eclipse-workspace\Selenium_POC\test-output\SparkReport\Index.html"
objMailItem.Send
Set objMailItem = nothing
Set objOutl = nothing