package Nazarov.Controllers;

import org.openqa.selenium.WebElement;

public class Textbox extends BaseElment {

    public Textbox(WebElement element) {
        super(element);
    }

    @Override
    public void setValue(String value) {
        if (isEnable()) {
            clearText();
            click();
            element.sendKeys(value);
        }
    }

    @Override
    public String getValue() {
        return element.getText();
    }

    @Override
    public String getText(String value) {
        return value;
    }

    public void clearText() {
        if (isEnable()) element.clear();
    }
}
