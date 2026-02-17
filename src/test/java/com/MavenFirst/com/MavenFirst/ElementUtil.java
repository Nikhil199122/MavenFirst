package com.MavenFirst.com.MavenFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil 
{
	 private static WebDriver driver;
	
	 // Constructor
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }
    
    // Get element
    public static WebElement getElement(By locator) 
    {
        return driver.findElement(locator);
    }
    
    /**
     * Generic method to check if an element exists on the page.
     * This method does NOT use isDisplayed(), isEnabled(), or isSelected().
     * It only checks if the element is present in the DOM.
     * 
     * @param locator - By locator of the elements
     * @return List<String> - List of visible text values
     */
    public List<String> getElementsTextList(By locator) 
    {
        List<WebElement> elements = driver.findElements(locator);
        List<String> textList = new ArrayList<>();

        for (WebElement e : elements) 
        {
            String text = e.getText().trim();
            if (!text.isEmpty()) 
            {
                textList.add(text);
            }
        }

        return textList;
    }

    // Send keys (only for enabled elements)
    public static void doSendKeys(By locator, String value) 
    {
        WebElement element = getElement(locator);
        if (element.isEnabled()) 
        {
            //element.clear();
            element.sendKeys(value);
            System.out.println("Entered value: " + value);
        } else 
        {
            System.out.println("Element is disabled. Skipping input: " + locator.toString());
        }
    }

    // Click method
    public static void doClick(By locator) 
    {
        WebElement element = getElement(locator);
        if (element.isEnabled()) 
        {
            element.click();
            System.out.println("Clicked: " + locator.toString());
        } else 
        {
            System.out.println("Element disabled: " + locator.toString());
        }
    }

    // Get text
    public static String doGetText(By locator) 
    {
        return getElement(locator).getText();
    }
    
    // Select dropdown by visible text
    public static void selectDropdownByVisibleText(By locator, String text) 
    {
        WebElement dropdown = getElement(locator);
        if (dropdown.isEnabled()) 
        {
            Select select = new Select(dropdown);
            select.selectByVisibleText(text);
            System.out.println("Dropdown selected: " + text);
        } else 
        {
            System.out.println("Dropdown is disabled: " + locator.toString());
        }
    }

    // Get selected dropdown text
    public String getSelectedOptionText(By locator) 
    {
        Select select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }
 
    // ==========================================
    // Generic ComboTree Dropdown Method
    // ==========================================
    public void selectComboTreeOption(By dropdownLocator, By optionsLocator, String... values) {
        // open dropdown first
        doClick(dropdownLocator);

        // fetch all options
        List<WebElement> optionsList = driver.findElements(optionsLocator);

        if (values[0].equalsIgnoreCase("all")) 
        {
            for (WebElement option : optionsList) 
            {
                if (!option.getText().isEmpty())
                {
                    option.click();
                    System.out.println("Selected: " + option.getText());
                }
            }
        } else 
        {
            for (String value : values) 
            {
                for (WebElement option : optionsList) 
                {
                    if (option.getText().equalsIgnoreCase(value)) 
                    {
                        option.click();
                        System.out.println("Selected: " + option.getText());
                        break;
                    }
                }
            }
        }
    }

    // ==========================================
    // Switch-case method to handle selection type
    // ==========================================
    public void handleComboTreeSelection(String selectionType, By dropdownLocator, By optionsLocator) 
    {
        switch (selectionType.toLowerCase()) 
        {
            case "single":
                selectComboTreeOption(dropdownLocator, optionsLocator, "choice 1");
                break;

            case "multiple":
                selectComboTreeOption(dropdownLocator, optionsLocator, "choice 2", "choice 6 2", "choice 3");
                break;

            case "all":
                selectComboTreeOption(dropdownLocator, optionsLocator, "all");
                break;

            default:
                System.out.println("Invalid selection type: Not able to select items");
        }
    }
    
    // Generic method to get footer links by section name
    public List<String> getFooterLinksBySection(String sectionName) 
    {
        String dynamicXPath = "//footer//div[contains(.,'" + sectionName + "')]/following-sibling::ul//a";
        List<WebElement> links = driver.findElements(By.xpath(dynamicXPath));
        List<String> sectionLinks = new ArrayList<>();

        for (WebElement link : links) 
        {
            String text = link.getText().trim();
            if (!text.isEmpty()) 
            {
                sectionLinks.add(text);
            }
        }

        return sectionLinks;
    }  
    
    /**
     * Generic method to get text list of all elements for any section.
     * It takes a locator and a section name (for printing).
     */
    public List<String> getSectionLinksText(By locator, String sectionName) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> textList = new ArrayList<>();

        System.out.println(sectionName + " Links:");
        if (elements.isEmpty()) {
            System.out.println("No links found for: " + sectionName);
        } else {
            for (WebElement e : elements) {
                String text = e.getText().trim();
                if (!text.isEmpty()) {
                    textList.add(text);
                    System.out.println(text);
                }
            }
        }
        return textList;
    }
    //Generic method to check if an element exists on the page.
    /**
     * 
     * @param locator - By locator of the element
     * @return true if element exists, false otherwise
     */
    public boolean isElementExists(By locator) 
    {
        List<WebElement> elements = driver.findElements(locator);

        // If list size > 0, element exists in DOM
        if (elements.size() > 0) 
        {
            System.out.println("Element found: " + locator.toString());
            return true;
        } else 
        {
            System.out.println("Element NOT found: " + locator.toString());
            return false;
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Selection items from submenu using Actions class
    public static void selectSubMenu(String tagname, String parentMenu, String childMenu) throws InterruptedException 
    {
        // Create dynamic XPaths
        By parentTP = By.xpath("//" + tagname + "[text()='" + parentMenu + "']");
        By childT = By.xpath("//" + tagname + "[text()='" + childMenu + "']");
        // Hover on parent menu
        WebElement TP = getElement(parentTP);
        Actions act = new Actions(driver);
        act.moveToElement(TP).build().perform();
        Thread.sleep(2000);
        // Click on child menu
        WebElement T = getElement(childT);
        T.click();
        Thread.sleep(2000);
    }
    
   
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * Generic 3-level menu method:
     * parentMenu -> subMenu -> childMenu
     */
    public static void selectSubMenu(String mainMenu, String subMenu)throws InterruptedException
    {
    	 Actions act = new Actions(driver);

         // Step 1: Click "Shop by Category"
         WebElement shopByCategory = driver.findElement(By.xpath("//button[contains(.,'Shop by Category')]"));
         shopByCategory.click();
         System.out.println("Clicked on: Shop by Category");
         Thread.sleep(3000);
        
		 // Step 2: Hover over main category (e.g., Beverages)
         WebElement mainCategory = driver.findElement(By.xpath("//a[contains(text(),'" + mainMenu + "')]"));
         act.moveToElement(mainCategory).build().perform();
         System.out.println("Hovered over: " + mainMenu);
         Thread.sleep(3000);
        
		 // Step 3: Click subcategory (e.g., Tea)
         WebElement subCategory = driver.findElement(By.xpath("//a[contains(text(),'" + subMenu + "')]"));
         act.moveToElement(subCategory).click().perform();
         System.out.println(" Clicked on: " + subMenu);
         Thread.sleep(5000);
    }
    /*public static void selectSubMenu(String tagname, String parentMenu, String subMenu, String childMenu) throws InterruptedException 
    {
        // Locators for each level
        By parentTP = By.xpath("//" + tagname + "[text()='" + parentMenu + "']");
        By subTP = By.xpath("//" + tagname + "[text()='" + subMenu + "']");
        By childT = By.xpath("//" + tagname + "[text()='" + childMenu + "']");
        // Hover over parent
        WebElement parentElement = getElement(parentTP);
        Actions act = new Actions(driver);
        act.moveToElement(parentElement).build().perform();
        Thread.sleep(3000);
        // Hover over sub-menu
        WebElement subElement = getElement(subTP);
        act.moveToElement(subElement).build().perform();
        Thread.sleep(3000);
        // Click child item
        WebElement childElement = getElement(childT);
        childElement.click();
        Thread.sleep(5000); 
    }*/
    
 /*// Generic method to click a button using Actions
    public static void clickElement(By locator) throws InterruptedException 
    {
        WebElement element = driver.findElement(locator);
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
        System.out.println("Clicked element: " + element.getText());
        Thread.sleep(2000);
    }*/

    // Generic method to handle alert and confirm boxes
    public static void handleAlert(String alertType, boolean accept) throws InterruptedException {
        // Click the corresponding button based on alertType
        By button = By.xpath("//button[text()='Generate " + alertType + " Box']");
        driver.findElement(button).click();

        Thread.sleep(2000); // Wait for alert to appear

        // Switch to alert and handle based on type
        Alert alert = driver.switchTo().alert();
        System.out.println(alertType + " text: " + alert.getText());

        if (accept) {
            alert.accept();
            System.out.println(alertType + " accepted");
        } else {
            alert.dismiss();
            System.out.println(alertType + " dismissed");
        }
        Thread.sleep(2000);
    }

    // Generic method for drag and drop
    public static void dragAndDrop(By sourceLocator, By targetLocator) throws InterruptedException {
        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).build().perform();

        System.out.println("Drag and drop completed successfully");
        Thread.sleep(2000);
    }

    /**
     * Generic method to perform click, right-click, or double-click using Actions class
     * @param locator - element locator
     * @param actionType - "click", "rightClick", or "doubleClick"
     */
    public static void performAction(By locator, String actionType) {
        WebElement element = driver.findElement(locator);

        switch (actionType.toLowerCase()) {
            case "click":
            	Actions act1 = new Actions(driver);
                act1.moveToElement(element).click().perform();
                System.out.println("Performed single click using Actions on: " + locator);
                break;

            case "rightclick":
            	Actions act2 = new Actions(driver);
                act2.moveToElement(element).contextClick().perform();
                System.out.println("Performed right click using Actions on: " + locator);
                break;

            case "doubleclick":
            	Actions act3 = new Actions(driver);
                act3.moveToElement(element).doubleClick().perform();
                System.out.println("Performed double click using Actions on: " + locator);
                break;

            default:
                System.out.println("Invalid action type. Use: click, rightClick, or doubleClick");
        }
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * Generic method to handle all types of alerts using Actions class.
     * @param locator Button locator to trigger the alert
     * @param actionType "accept" or "dismiss"
     * @param inputText Optional text for prompt alert
     */
    public static void handleAlertWithActions(By locator, String actionType, String inputText) throws InterruptedException 
    {

        // Move to element and click using Actions
        WebElement alertButton = driver.findElement(locator);
        Actions act = new Actions(driver);
        act.moveToElement(alertButton).click().build().perform();
        System.out.println("Clicked button using Actions: " + locator);
        Thread.sleep(5000);
        
        // Switch to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        
        // Handle prompt alerts
        if (inputText != null) 
        {
            alert.sendKeys(inputText);
            System.out.println("Entered text: " + inputText);
        }
        
        // Accept or dismiss alert
        if (actionType.equalsIgnoreCase("accept"))
        {
            alert.accept();
            System.out.println("Alert accepted");
        } else if (actionType.equalsIgnoreCase("dismiss")) 
        {
            alert.dismiss();
            System.out.println("Alert dismissed");
        }
        Thread.sleep(1500);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Generic method for uploading a file
    public static void uploadFile(By locator, String filePath) throws InterruptedException 
    {
        WebElement uploadInput = driver.findElement(locator);
        uploadInput.sendKeys(filePath);
        System.out.println("File path entered for upload: " + filePath);
        Thread.sleep(5000);
        System.out.println("File uploaded successfully");
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * Generic method to click a button (for download)
     */
    public static void clickDownloadButton(By locator) 
    {
        WebElement downloadBtn = driver.findElement(locator);
        downloadBtn.click();
        System.out.println("Download button clicked");
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Scroll to element
    public static void scrollToElement(By locator) 
    {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to bottom of page
    public static void scrollToBottom() 
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Click element
    public static void clickElement(WebDriver driver, By locator) 
    {
        WebElement element = driver.findElement(locator);
        element.click();
        System.out.println("Clicked on element: " + locator);
    }
    
 // ---------- GENERIC METHODS ----------

    // Switch to frame using WebElement
    public static void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
        System.out.println("Switched to frame successfully.");
    }

    // Switch back to main content
    public static void switchToMainPage() {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page.");
    }
    
 // ----------- GENERIC METHODS -----------

    public static void type(By locator, String value) 
    {
        WebElement ele = driver.findElement(locator);
        ele.clear();
        ele.sendKeys(value);
    }
    
    public static void click(By locator) 
    {
        driver.findElement(locator).click();
    }
    
    public static void uploadFile1(By locator, String filePath) 
	 {
	        driver.findElement(locator).sendKeys(filePath);
	        System.out.println("File uploaded.");
	 }
    
    // Generic method to click state by name
    public static void clickState(List<WebElement> list, String stateName) 
    {
        for (WebElement st : list) 
        {
            if (st.getAttribute("name").equals(stateName)) 
            {
                System.out.println("Selected State: " + stateName);
                st.click();
                break;
            }
        }
    }
    
    public List<WebElement> getElements(By locator) 
    {
        return driver.findElements(locator);
    }
    
    public String getAttribute(WebElement element, String attrName) 
    {
        return element.getAttribute(attrName);
    }
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }
     
    // ---------------- Generic Shadow Root Method ----------------
    public static SearchContext getShadowRoot(SearchContext context, By locator) 
    {
        WebElement root = context.findElement(locator);
        return root.getShadowRoot();
    }
    
 // --------------------------------------------------
    // Generic method: returns shadow root as WebElement
    // Works in all Selenium versions
    // --------------------------------------------------
    public static WebElement getShadowRoot(WebDriver driver, WebElement host, WebDriverWait wait) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until shadow root is available
        wait.until((Function<WebDriver, Boolean>) d ->(Boolean) js.executeScript("return arguments[0].shadowRoot != null;", host));

        // Return shadow root as WebElement
        return (WebElement) js.executeScript("return arguments[0].shadowRoot;", host);
    }

    // Generic method to return shadowRoot of any element
    public static WebElement expandShadowRoot(WebDriver driver, WebElement host) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", host);
    }
    
    // =================================================================
    // Generic method to locate a row by text on paginated tables
    // =================================================================
    public static void findAndClickRow(WebDriver driver, String searchText) throws InterruptedException 
    {

        while (true) 
        {

            // 1. Check if text exists on the current page
            if (driver.findElements(By.xpath("//td[text()='" + searchText + "']")).size() > 0) 
            {

                // Click the first column cell of that row
                driver.findElement(By.xpath("//td[text()='" + searchText + "']")).click();

                System.out.println("Found and clicked: " + searchText);
                break;
            }

            // 2. If not found, check if Next button is disabled
            WebElement nextBtn = driver.findElement(By.xpath("//a[@id='example_next']"));

            String nextBtnClass = nextBtn.getAttribute("class");

            if (nextBtnClass.contains("disabled")) 
            {
                System.out.println("End of page. Data not found.");
                break;
            }

            // 3. If enabled, click Next and continue loop
            nextBtn.click();
            Thread.sleep(1500);
        }
    }
    
    // Generic method to click pagination links
    public static void clickPagination(WebDriver driver, String xpath) 
    {
        WebElement page = driver.findElement(By.xpath(xpath));
        page.click();
        System.out.println("Clicked page using XPath: " + xpath);
    }
    
 // =========================================================
    // GENERIC METHOD – CHECK FIELD (Pseudo + Empty Check)
    // =========================================================
    public static void checkField(WebDriver driver, String forAttribute, String fieldName) throws InterruptedException 
    {
        System.out.println("\n--- Checking: " + fieldName + " ---");
        String star = getPseudoContent(driver, forAttribute, "::before");
        System.out.println("Pseudo content: " + star);
        WebElement element = driver.findElement(By.name(fieldName));
        element.clear();
        // Sample input
        switch (fieldName) 
        {
            case "firstname":  element.sendKeys("Nikhil"); break;
            case "lastname":   element.sendKeys("Shahane"); break;
            case "email":      element.sendKeys("nshahane@gmail.com"); break;
            case "telephone":  element.sendKeys("8715647449"); break;
            case "password":   element.sendKeys("Nikhil@10"); break;
            case "confirm":    element.sendKeys("Nikhil@10"); break;
        }
        Thread.sleep(800);
        if (star.contains("*")) 
        {
            System.out.println("This field is required.");
            if (isBlank(element)) 
            {
                System.out.println("Field is blank → You must enter a value.");
            } else 
            {
                System.out.println("Value entered.");
            }
        } else 
        {
            System.out.println("This field is NOT required.");
        }
    }

    // =========================================================
    // GET PSEUDO ELEMENT (::before / ::after)
    // =========================================================
    public static String getPseudoContent(WebDriver driver, String forAttribute, String pseudoType) 
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "var el = document.querySelector(\"label[for='" + forAttribute + "']\");"
                + "if(!el){return '';} "
                + "return window.getComputedStyle(el, \"" + pseudoType + "\").getPropertyValue('content');";

        String content = (String) js.executeScript(script);

        if (content != null && content.length() > 2) 
        {
            content = content.substring(1, content.length() - 1);
        }
        return content;
    }
    // =========================================================
    // CHECK IF FIELD IS BLANK
    // =========================================================
    public static boolean isBlank(WebElement element) 
    {
        String value = element.getAttribute("value");
        return value == null || value.trim().equals("");
    }

    // =========================================================
    // FIXED → CHECK PRIVACY POLICY CHECKBOX
    // =========================================================
    public static void checkPrivacyPolicy(WebDriver driver) throws InterruptedException 
    {

        System.out.println("\n--- Checking Privacy Policy Checkbox ---");
        WebElement checkbox = driver.findElement(By.name("agree"));
        if (!checkbox.isSelected()) 
        {
            System.out.println("Checkbox not selected → clicking");
            checkbox.click();
        } else 
        {
            System.out.println("Already selected");
        }
        Thread.sleep(800);
    }
    
    // Generic method to fetch shadow root
    public static WebElement getShadowRoot(WebDriver driver, WebElement host) 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", host);
    }

    // Generic method to click inside shadow DOM
    public static void clickShadowElement(WebDriver driver, WebElement host, By locator) 
    {
        WebElement shadowRoot = getShadowRoot(driver, host);
        WebElement elementInside = shadowRoot.findElement(locator);
        elementInside.click();
    } 
    // ================================================================
    // Generic Shadow DOM method (unlimited nested root support)
    // First argument = host
    // remaining = nested shadow elements / final element
    // ================================================================
    public static WebElement getShadowElement(String... selectors) 
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "let el = document.querySelector(arguments[0]);" +
                "for (let i = 1; i < arguments.length; i++) {" +
                "    el = el.shadowRoot.querySelector(arguments[i]);" +
                "}" +
                "return el;";

        return (WebElement) js.executeScript(script, (Object[]) selectors);
    }
    
   
}
