import BestTower.BestTower;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTowerTests {

    @Test
    public void TestBestTower() {
        BestTower bestTower = new BestTower();
        var result = bestTower.getBestTower("4cb93fb8-8757-45b2-adde-17805741f14c");
        System.out.println(result);
    }

    @Test
    public void TestGetAverage() {
        BestTower bestTower = new BestTower();
        Map<String, Map<String, List<Integer>>> map = new HashMap<>();
        Map<String, List<Integer>> innerMap = new HashMap<>();
        List<Integer> towerA = new ArrayList<>();
        List<Integer> towerB = new ArrayList<>();

        towerA.add(-10);
        towerA.add(-11);
        towerA.add(-12);

        towerB.add(-20);
        towerB.add(-30);
        towerB.add(-40);

        innerMap.put("towerA",towerA);
        innerMap.put("towerB",towerB);
        map.put("farmA",innerMap);

        bestTower.map = map;
        var result = bestTower.getBestTower("farmA");
        var expected = "towerA";
        Assert.assertEquals(expected,result);
    }

    @Test
    public void TestGetTwoFarms() {
        BestTower bestTower = new BestTower();
        Map<String, Map<String, List<Integer>>> map = new HashMap<>();
        Map<String, List<Integer>> innerMapA = new HashMap<>();
        Map<String, List<Integer>> innerMapB = new HashMap<>();
        List<Integer> towerA = new ArrayList<>();
        List<Integer> towerB = new ArrayList<>();
        List<Integer> towerC = new ArrayList<>();
        List<Integer> towerD = new ArrayList<>();

        towerA.add(-10);
        towerA.add(-11);
        towerA.add(-12);

        towerB.add(-20);
        towerB.add(-30);
        towerB.add(-40);
        towerB.add(-20);

        towerC.add(-5);
        towerC.add(-6);
        towerC.add(-7);

        towerD.add(-2);
        towerD.add(-3);

        innerMapA.put("towerA",towerA);
        innerMapA.put("towerB",towerB);
        innerMapB.put("towerC",towerC);
        innerMapB.put("towerD",towerD);
        map.put("farmA",innerMapA);
        map.put("farmB",innerMapB);

        bestTower.map = map;
        var resultA = bestTower.getBestTower("farmA");
        var expectedA = "towerA";
        Assert.assertEquals(expectedA,resultA);

        var resultB = bestTower.getBestTower("farmB");
        var expectedB = "towerD";
        Assert.assertEquals(expectedB,resultB);
    }

}
