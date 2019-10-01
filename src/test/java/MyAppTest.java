import org.junit.Assert;
import org.junit.Test;

public class MyAppTest extends ParallelTest {

private static final String URL="http://localhost";
private static final String PORT="8080";

@Before
public void setup() throws Exception {
    setDriver(new FirefoxDriver());
    //Open the web page
    getDriver().get(URL+":"+PORT);
}

@After
public void tearDown() throws Exception {
    //close the browser window
    getDriver().quit();
}

@Test
public void test() {
    //Get a reference to the button
    ButtonElement button = $(ButtonElement.class).first();

    //Simulate button click;
    button.click();

    //Get text field value;
    String actualValue = $(LabelElement.class).first().getText();

    //Check that the value is not empty
    Assert.assertFalse(actualValue.isEmpty());
}
}
