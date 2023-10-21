package BestTower;

import BestTower.Model.Tower;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseHelper {

    /**
     * Turns certain types of JSON responses into a String list.
     * Json converter library has a hard to converting non-list JSON into lists,
     * hence the need for this parser.
     *
     * @param response - Has to be in the format: "{"item1","item2", ...}"
     * @return List of strings that contains "item1", "item2", ...
     */
    public static List<String> ResponseToList(String response) {
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        ArrayList<String> list = new Gson().fromJson(response, listType);
        return list;
    }
}
