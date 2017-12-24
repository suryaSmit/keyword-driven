package keyworddriven;

import org.openqa.selenium.By;

public class Locator {
	static By loc =null;
	
	public static By locateElement(String locType,String locValue) {
		switch (locType.toLowerCase()) {
		case "id":
			loc = By.id(locValue);
			break;
		case "name":
			loc = By.name(locValue);
			break;
		case "linktext":
			loc = By.linkText(locValue);
			break;
		case "partiallinktext":
			loc = By.partialLinkText(locValue);
			break;
		case "xpath":
			loc = By.xpath(locValue);
			break;
		case "cssselector":
			loc = By.cssSelector(locValue);
			break;
		default:
			System.out.println("please enter valid locator type");
			break;
		}
		return loc;
	}

}
