package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__ Woreceipt", summary = "", page = "Woreceipt", namespacePrefix = "rstk", object = "rstk__worcpt__c", connection = "QARSF_Admin")
public class rstk__Woreceipt {

	public WebDriver driver;

	public rstk__Woreceipt(WebDriver driver) {
		this.driver = driver;
	}

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Sort by Item Number']/ancestor::th/following-sibling::td//input")
	public WebElement sortByItemNumber;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Work Order']/ancestor::span/ancestor::th/following-sibling::td//select")
	public WebElement workOrder;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Override Receipt Template']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement overrideReceiptTemplate;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='WO Receipt Traveler']/ancestor::span/ancestor::th/following-sibling::td//select")
	public WebElement wOReceipt_Traveler;

	@ButtonType()
	@FindBy(xpath = "//label[normalize-space(.)='WO Receipt Traveler']/ancestor::span/ancestor::th/following-sibling::td//input[@type='submit']")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Date']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement transactionDate;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Date']/ancestor::span/ancestor::th/following-sibling::td//a")
	public WebElement transactionDateTodayLink;

	@ButtonType()
	@FindBy(xpath = "//table[@id='bodyTable']//div/input")
	public WebElement reloadWorkOrderS;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Operation']/ancestor::span/ancestor::th/following-sibling::td//select")
	public WebElement operation;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Inventory Location ID']/ancestor::span/ancestor::th/following-sibling::td//select")
	public WebElement inventoryLocationID;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Inventory Location Number']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement inventoryLocationNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Qty Remaining']/ancestor::span/ancestor::th/following-sibling::td/span")
	public WebElement qtyRemaining;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Qty to be Accepted']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement qtyToBeAccepted;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Lot Expiration Date']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement lotExpirationDate;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Comments']/ancestor::span/ancestor::th/following-sibling::td//textarea")
	public WebElement transactionComments;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Location Comments']/ancestor::span/ancestor::th/following-sibling::td//textarea")
	public WebElement locationComments;

	@ButtonType()
	@FindByLabel(label = "Perform Work Order Receipt")
	public WebElement performWorkOrderReceipt;

	public void selectWorkOrder(String WorkOrder) throws InterruptedException {
		List<WebElement> options = driver.findElements(
				By.xpath("//label[normalize-space(.)='Work Order']/ancestor::th/following-sibling::td//option"));
		for (WebElement option : options) {
			if (option.getText().contains(WorkOrder)) {
				option.click();
				break;
			}
		}
	}

	public void selectSerialNumber(Integer NumberOfSerialTobeSelected) throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> ele = driver.findElements(By.xpath("//select[contains(@id,'serials')]/option"));
		// testLogger.info("Size" + ele.size());
		Select listbox = new Select(driver.findElement(By.xpath("//select[contains(@id,'serials')]")));
		listbox.deselectAll();

		for (int i = 1; i <= NumberOfSerialTobeSelected; i++) {

			WebElement element = driver.findElement(By.xpath("//select[contains(@id,'serials')]/option[" + i + "]"));
			// testLogger.info("Serial Number:" + element.getText());
			element.click();

		}

	}
}
