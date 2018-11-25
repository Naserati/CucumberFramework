package Nazarov.Controllers;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public abstract class BaseElment implements IElement {

    protected WebElement element;

    public BaseElment(WebElement element) {
        this.element = element;
    }

    public WebElement getWebElement() {
        return element;
    }

    public boolean isEnable() {
        if (isVisible()) return element.isEnabled();
        else throw new ElementNotVisibleException("IElement is not visible: " + element);
    }

    public boolean isVisible() {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(){
        if(element.isEnabled()) element.click();
        else throw new NoSuchElementException("IElement is disable: " + element);
    }
}
