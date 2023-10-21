package BestTower;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTower {

    private ApiGetter getter;
    private Map<String, Map<String,List<Integer>>> map;
    private final String listUrl = "https://api.onizmx.com/lambda/tower_stream";

    public BestTower() {
         getter = new ApiGetter();
    }

    public String getBestTower(String farmId) {
        if(map == null) {
            StartUp();
            System.out.println("Loading values from API");
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
        int min = 0;
        String minTower = null;

        for(String towerId : innerMap.keySet()) {
            int total = 0;
            var list = innerMap.get(towerId);

            for(int rssi : list) {
                total += rssi;
            }
            var average = total / list.size();

            if(average < min) {
                min = average;
                minTower = towerId;
            }
        }

        return minTower;
    }

}
