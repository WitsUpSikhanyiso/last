import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleIT extends TestBenchTestCase {

    @Before
    public void setup() throws Exception {
        // Create a new browser instance
        setDriver(new ChromeDriver());
        // Open the application
        getDriver().get("http://localhost:8080/");
    }

    @Test
    public void clickButton() {
        // Find the first button (<vaadin-button>) on the page
        ButtonElement button = $(ButtonElement.class).first();

        // Click it
        button.click();

        // Check the the value of the button is "Clicked"
        Assert.assertEquals("Clicked", button.getText());
    }

    @After
    public void tearDown() throws Exception {
        // close the browser instance when all tests are done
        getDriver().quit();
    }

}


