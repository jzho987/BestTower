package BestTower;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BestTower {

    ApiGetter getter;
    private final String listUrl = "https://api.onizmx.com/lambda/tower_stream";

    public BestTower() {
         getter = new ApiGetter();
    }

    public void Run() {
        try {
            var response = getter.get(listUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
