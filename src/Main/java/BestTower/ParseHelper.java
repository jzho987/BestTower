package BestTower;

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
