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

    /**
     * Turns certain types of JSON responses into a String list.
     * Json converter library has a hard to converting non-list JSON into lists,
     * hence the need for this parser.
     *
     * @param response - Has to be in the format: "{"item1","item2", ...}"
     * @return List of strings that contains "item1", "item2", ...
     */
    public List<String> ResponseToList(String response) {
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        ArrayList<String> list = new Gson().fromJson(response, listType);
        return list;
    }
}
