package Nazarov.Controllers;

import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElment {

    public CheckBox(WebElement element) {
        super(element);
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            click();
        }
    }

    public boolean isChecked() {
        return element.isSelected();
    }

    @Override
    public void setValue(String value) {
        if (Boolean.parseBoolean(value) != isChecked()) {
            element.click();
        }
    }

    @Override
    public String getValue() {
        return String.valueOf(isChecked());
    }

    @Override
    public String getText(String value) {
        return value;
    }
}
