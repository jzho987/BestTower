import BestTower.ParseHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonParsingTests {


    @Test
    public void TestParsingJson() {
        var JSON = "[\"item1\",\"item2\",\"item3\"]";

        var expected = new ArrayList<>(List.of(new String[]{"item1", "item2", "item3"}));
        var actual = ParseHelper.ResponseToList(JSON);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestParseOneJson() {
        var JSON = "[\"item1\"]";

        var expected = new ArrayList<>(List.of(new String[]{"item1"}));
        var actual = ParseHelper.ResponseToList(JSON);

        Assert.assertEquals(expected, actual);
    }
}
