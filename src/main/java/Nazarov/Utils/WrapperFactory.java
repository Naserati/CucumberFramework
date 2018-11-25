package Nazarov.Utils;

import Nazarov.Controllers.IElement;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by Sergei_Shatilov on 11/18/2015.
 */
@Component
public class WrapperFactory {

    /**
     * Создает экземпляр класса,
     * реализующий IElement интерфейс,
     * вызывая конструктор с аргументом WebElement
     */
    public static IElement createInstance(Class<IElement> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }

}
