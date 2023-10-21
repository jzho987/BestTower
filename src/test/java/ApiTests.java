import BestTower.ApiGetter;
import BestTower.BestTower;
import com.sun.source.tree.AssertTree;
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

    @Test
    public void TestApiGetListSize() {
        String response;

        try {
            response = getter.get("https://api.onizmx.com/lambda/tower_stream");

            BestTower bestTower = new BestTower();
            var list = bestTower.ResponseToList(response);
            Assert.assertEquals(6, list.size());

        } catch (IOException e) {
            fail("This should not throw any exceptions");
        }
    }
}
