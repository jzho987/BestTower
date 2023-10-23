package BestTower;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main functional class for handling the logic for calculating the best tower for the given farm
 * The "map" variable is only public for testing purposes and use of Interfaces should be done when progressing further.
 * The class runs start up when querying the best tower the first time, and speeds up on subsequent runs.
 *
 * Changing ListUrl into a constructor variable will help with scaling
 *
 */
public class BestTower {

    private ApiGetter getter;
    public Map<String, Map<String,List<Integer>>> map; // public for testing purposes
    private final String listUrl = "https://api.onizmx.com/lambda/tower_stream";

    public BestTower() {
         getter = new ApiGetter();
    }

    public String getBestTower(String farmId) {
        if(map == null) {
            System.out.println("Loading values from API...");
            StartUp();
            System.out.println("Values loaded.");
        }

        return bestTower(farmId);
    }

    private void StartUp() {
        try {
            var response = getter.get(listUrl);
            var list = ParseHelper.ResponseToList(response);

            // will hold all the values from all the files
            map = new HashMap<>();

            // loop through all the file links and get mapped
            for (String s : list) {
                getter.getMappedCSV(s, map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String bestTower(String farmId) {

        if(map == null) {
            return null;
        }

        if(!map.containsKey(farmId)) {
            System.out.println("Farm id does not exist");
            return null;
        }

        var innerMap = map.get(farmId);
        int max = (int) Double.NEGATIVE_INFINITY;
        String maxTower = null;

        for(String towerId : innerMap.keySet()) {
            int total = 0;
            var list = innerMap.get(towerId);

            for(int rssi : list) {
                total += rssi;
            }
            var average = total / list.size();

            if(average > max) {
                max = average;
                maxTower = towerId;
            }
        }

        return maxTower;
    }

}
