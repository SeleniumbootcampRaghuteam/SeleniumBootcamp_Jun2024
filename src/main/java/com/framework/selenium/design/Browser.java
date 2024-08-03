package com.framework.selenium.design;

import org.openqa.selenium.By;

public interface Browser {
	void disableNotifications();

	void browserInstantiate();

	void browserMaximize();

	void implicitWait(int seconds);

	void goToUrl(String url);

	void closeWindow();

	void quitBrowser();

	void switchFrameByIndex(Integer index);

	void switchFrameByNameOrId(String nameOrId);

	void switchFrameByFrameLocator(By frameLocator);
	
	void switchFrameToDefaultContent();

}
