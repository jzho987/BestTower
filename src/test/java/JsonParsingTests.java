import BestTower.BestTower;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonParsingTests {

    BestTower bestTower;

    @Before
    public void setup() {
        bestTower = new BestTower();
    }

    @Test
    public void TestParsingJson() {
        var JSON = "{\"item1\",\"item2\",\"item3\"}";

        var expected = new ArrayList<>(List.of(new String[]{"item1", "item2", "item3"}));
        var actual = bestTower.ResponseToList(JSON);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestParseOneJson() {
        var JSON = "{\"item1\"}";

        var expected = new ArrayList<>(List.of(new String[]{"item1"}));
        var actual = bestTower.ResponseToList(JSON);

        Assert.assertEquals(expected, actual);
    }
}
