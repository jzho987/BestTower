import BestTower.ApiGetter;
import BestTower.ParseHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public class ApiTests {

    ApiGetter getter;

    @Before
    public void Setup() {
        getter = new ApiGetter();
    }

    @Test
    public void TestApiGetNoErrors() {
        try {
            getter.get("https://api.onizmx.com/lambda/tower_stream");
        } catch (IOException e) {
            fail("This should not throw any exceptions");
        }
    }

    @Test
    public void TestApiGetListSize() {

        String response;

        try {
            response = getter.get("https://api.onizmx.com/lambda/tower_stream");

            var list = ParseHelper.ResponseToList(response);
            Assert.assertEquals(6, list.size());

        } catch (IOException e) {
            fail("This should not throw any exceptions");
        }
    }

    @Test
    public void TestApiGetStreamSuccess() {
        try {
            Map<String, Map<String, List<Integer>>> map = new HashMap<>();
            getter.getMappedCSV("https://comms-tech-test.s3.ap-southeast-2.amazonaws.com/tower_stream/tower-stream-2023-10-19T06%3A58%3A24.613Z.csv", map);
            Assert.assertNotNull(map);
        } catch (IOException e) {
            fail("This should not throw any exceptions");
        }
    }
}
