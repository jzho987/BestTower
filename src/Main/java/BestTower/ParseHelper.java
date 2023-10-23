package BestTower;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to help with parsing data from the JSON and file data from the endpoints into usable Java variables.
 * The helper methods should all be static to minimize overhead from initialisations.
 */
public class ParseHelper {

    /**
     * Turns a string array in JSON format into a Java ArrayList
     *
     * @param response JSON list e.g.: "["item1","item2", ...]"
     * @return List of strings that contains "item1", "item2", ...
     */
    public static List<String> ResponseToList(String response) {
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        ArrayList<String> result = new Gson().fromJson(response, listType);
        return result;
    }

    /**
     * Turns a InputStream which contains a CSV file into a nested HashMap with an innerList.
     * The Outside Hashmap's key in this context is the farm ID.
     * The Inner Hashmap's key is the tower ID.
     * The List of Integers mapped to each tower are the RSSIs per tower for the farm.
     * The use of Hashmap is to speed up query since the IDs are GUIDs which are efficiently indexed.
     *
     * @param stream CSV file input stream
     * @param out Output map that needs to be supplied to get the output ref
     * @throws IOException error from reader
     */
    public static void CSVstreamToMap(InputStream stream, Map<String, Map<String,List<Integer>>> out) throws IOException {

        Map<String, Map<String,List<Integer>>> map = new HashMap<>();
        if(out != null) {
            map = out;
        }

        var reader = new BufferedReader(new InputStreamReader(stream));

        String line = reader.readLine(); // ignore first line
        while((line=reader.readLine())!=null){

            String values[] = line.split(",");
            if(values.length >= 3) {
                if(!map.containsKey(values[0])) {
                    Map<String,List<Integer>> innerMap = new HashMap<>();
                    var rssi = new ArrayList<Integer>();
                    rssi.add(Integer.parseInt(values[2]));
                    innerMap.put(values[1],rssi);
                    map.put(values[0], innerMap);
                }
                else {
                    var innerMap = map.get(values[0]);
                    if(innerMap.containsKey(values[1])) {
                        innerMap.get(values[1]).add(Integer.parseInt(values[2]));
                    }
                    else {
                        var rssi = new ArrayList<Integer>();
                        rssi.add(Integer.parseInt(values[2]));
                        innerMap.put(values[1],rssi);
                    }
                }
            }
        }
    }
}
