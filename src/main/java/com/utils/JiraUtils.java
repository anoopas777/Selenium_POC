/**
 * 
 */
package com.utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Issue.FluentCreate;

import java.io.File;



public class JiraUtils {
	
	public static JiraClient jira;
	public static String project;
	
	public static void JiraMain(String SCFilePath)
	{
	
	boolean isTicketReady = true;
	if (isTicketReady) {
		// raise jira ticket:
		System.out.println("is ticket ready for JIRA: " + isTicketReady);
		JiraServiceProvider(PropertyFileReader.JiraUrl,PropertyFileReader.JiraUsername,PropertyFileReader.JiraAPIToken,PropertyFileReader.JiraProjectName);
		String issueSummary = "Test step failed due to some assertion or exception";
		String issueDescription = "Test step failed due to assertion, error details are below:";
		createJiraTicket("Bug", issueSummary, issueDescription,PropertyFileReader.JiraReporterName,SCFilePath);
	}
	}

public static void JiraServiceProvider(String jiraUrl, String username, String password, String projectname) {
	BasicCredentials creds = new BasicCredentials(username, password);
	jira = new JiraClient(jiraUrl, creds);
	project=projectname;
}

public static void createJiraTicket(String issueType, String summary, String description, String reporterName,String FilePath) {

	try {
		FluentCreate fleuntCreate = jira.createIssue(project, issueType);
		fleuntCreate.field(Field.SUMMARY, summary);
		fleuntCreate.field(Field.DESCRIPTION, description);
		fleuntCreate.field(Field.PRIORITY, "High");
		fleuntCreate.field(Field.ASSIGNEE, PropertyFileReader.JiraReporterName);
		//Field.STATUS, ATTACHMENT
		//fleuntCreate.field(Field.STATUS, "IN PROGRESS");
		Issue newIssue = fleuntCreate.execute();
		File file = new File(FilePath);
		newIssue.addAttachment(file);
		newIssue.addComment("***Jira Issue Created Via Automation***");
		System.out.println("New issue created in jira with ID: " + newIssue);

	} catch (JiraException e) {
		e.printStackTrace();
	}

}

}
