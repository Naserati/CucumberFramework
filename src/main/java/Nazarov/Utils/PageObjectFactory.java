package Nazarov.Utils;


import Nazarov.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Map;


/**
 * Created by Sergei_Shatilov on 11/25/2015.
 */
@Component
public class PageObjectFactory {

    public static WebDriver driver = WebDiverConfig.setFirefoxPofile();
    static private Map<Class<? extends BasePage>, BasePage> map = new Hashtable<>();

    static public synchronized <T> T getPageObject(Class<? extends BasePage> clazz){
        BasePage obj = map.get(clazz);
        if (obj == null){
            try {
                obj = clazz.getConstructor(WebDriver.class).newInstance(driver);
                map.put(clazz, obj);
                return (T) obj;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                e.getMessage();
            }  catch (NoSuchMethodException e) {
                e.printStackTrace();
                e.getStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                e.getCause();
            } catch (StackOverflowError e){
                e.getCause();
            }
        }
        return (T) obj;
    }

}
