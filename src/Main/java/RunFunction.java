import BestTower.BestTower;

/**
 * Runs the function directly. This will take a while since it gets the data everytime this is run.
 * For better performance and repeated use, use the "Main.main()" function.
 */
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
