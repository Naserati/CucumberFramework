package Nazarov.Controllers;


import org.openqa.selenium.WebElement;

public class Link extends BaseElment {

    public Link(WebElement element) {
        super(element);
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return element.getAttribute("value");
    }

    @Override
    public String getText(String value) {
        return value;
    }
}
