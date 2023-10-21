import BestTower.ApiGetter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class ApiTests {

    ApiGetter getter;

    @Before
    public void Setup() {
        getter = new ApiGetter();
    }

    @Test
    public void TestApiGetNoErrors() {

        String response;

        try {
            response = getter.get("https://api.onizmx.com/lambda/tower_stream");
        } catch (IOException e) {
            fail("This should not throw any exceptions");
        }
    }
}
