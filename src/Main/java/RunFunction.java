import BestTower.BestTower;

public class RunFunction {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please enter valid parameters");
            return;
        }

        var farmId = args[0];

        BestTower bestTower = new BestTower();
        var towerId = bestTower.getBestTower(farmId);

        if(towerId != null) {
            System.out.println("The tower with the lowest RSSI is id: \"" + towerId + "\".");
        }
        else {
            System.out.println("No tower Id found");
        }
    }
}
