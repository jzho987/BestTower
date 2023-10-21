import BestTower.BestTower;
import org.junit.Test;

public class BestTowerTests {

    @Test
    public void TestBestTower() {
        BestTower bestTower = new BestTower();
        var result = bestTower.getBestTower("4cb93fb8-8757-45b2-adde-17805741f14c");
        System.out.println(result);
    }

}
