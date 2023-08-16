package helpers
import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords


class TestSimpleHeper {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
	
	@Keyword
	static Map<String, Date> generateWeekdayDateMap() {
		Map<String, Date> weekdayDateMap = new HashMap()
	
		Calendar calendar = Calendar.getInstance()
	
		for (int i = Calendar.MONDAY; i <= Calendar.SATURDAY; i++) {
			String dayOfWeekAbbreviation = getDayOfWeekAbbreviation(i)
	
			Date date = calendar.getTime()
	
			weekdayDateMap.put(dayOfWeekAbbreviation, date)
	
			calendar.add(Calendar.DATE, 1)
		}
		
		Calendar.SUNDAY
	
		Date date = calendar.getTime()
	
		weekdayDateMap.put('dim', date)
	
		return weekdayDateMap
	}
	
	@Keyword
	static String getDayOfWeekAbbreviation(int dayOfWeek) {
		List<String> daysOfWeek = Arrays.asList('lun', 'mar', 'mer', 'jeu', 'ven', 'sam', 'dim')	
		return daysOfWeek.get(dayOfWeek - 2)
	}
	
	@Keyword
	static WebElement getCircleButtonWebElement(WebDriver driver, Date date) {		
		String cssSelector	= "button[data-date='" + generateDateDisplay(date, "yyyy-MM-dd")+ "']"
		return driver.findElement(By.cssSelector(cssSelector))
	}
	
	@Keyword
	static String generateDateDisplay(Date date, String format) {		
		return (new SimpleDateFormat(format)).format(date)
	}
}