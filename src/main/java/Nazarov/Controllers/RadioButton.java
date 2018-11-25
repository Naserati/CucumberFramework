package Nazarov.Controllers;

import org.openqa.selenium.WebElement;

public class RadioButton extends BaseElment {

    public RadioButton(WebElement element) {
        super(element);
    }

    public void setOption(boolean value) {
        if (value != isChecked()) {
            click();
        }
    }

    public boolean isChecked() {
        return element.isSelected();
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
