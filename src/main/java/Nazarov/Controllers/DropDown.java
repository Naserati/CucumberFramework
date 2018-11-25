package Nazarov.Controllers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElment {

    public DropDown(WebElement element) {
        super(element);
    }

    @Override
    public void setValue(String  value){
        if (!isChecked()) {
            Select selectByValue = new Select(element);
            selectByValue.selectByValue(value);
        }
    }

    @Override
    public String getValue() {
        return element.getAttribute("value");
    }

    @Override
    public String getText(String value) {
        return value;
    }

    public boolean isChecked() {
        return element.isSelected();
    }

}
