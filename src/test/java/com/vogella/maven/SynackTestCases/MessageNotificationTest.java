package com.vogella.maven.SynackTestCases;

import org.junit.Test;
import com.vogella.maven.Synack.MessageNotification;
import junit.framework.Assert;

public class MessageNotificationTest extends BaseClassTest {

	@Test
	public void notificationTest() throws InterruptedException {

		MessageNotification messageNotif = new MessageNotification();
		String page = "notification_message_rendered";
		messageNotif.setBrowser();
		messageNotif.setUrl(page);
		String message = messageNotif.getMessage();
		message = message.replace("\n", "");
		Assert.assertEquals("Action successful", message);
		messageNotif.exitBrowser();
	}
}