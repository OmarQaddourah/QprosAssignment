package testPackage.test.common;

import com.utils.PropReader;
import drivers_initializer.drivers.SelInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import static drivers_initializer.drivers.SelInstance.getWebDriver;

public class BaseTest {

  public static WebDriver webDriver;

  @BeforeMethod()
  public void defineDriver() {
    webDriver = getWebDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    webDriver.get(PropReader.readConfig("QprosUrl"));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(Method method) {
    try {
      webDriver.quit();
    } finally {
      SelInstance.webDriver.set(null);
    }
  }
}
