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

    ApiGetter getter;
    private final String listUrl = "https://api.onizmx.com/lambda/tower_stream";

    public BestTower() {
         getter = new ApiGetter();
    }

    public void StartUp() {
        try {
            var response = getter.get(listUrl);
            var list = ParseHelper.ResponseToList(response);

            // will hold all the values from all the files
            Map<String, Map<String,List<Integer>>> map = new HashMap<>();

            // loop through all the file links and get mapped
            for (String s : list) {
                getter.getMappedCSV(s, map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String bestTower(String id) {
        
    }

}
