package BestTower;

import BestTower.Model.Tower;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leverages the HTTP client functions.
 */
public class ApiGetter {
    OkHttpClient client = new OkHttpClient();

    /**
     * call GET on the url provided, and return the response body.     *
     * @param url - url of the HTTP request
     * @return String - response body
     * @throws IOException throws IOException
     * @throws NullPointerException throws Null Pointer Exception
     */
    public String get(String url) throws IOException, NullPointerException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public Map<String, List<Tower>> getMappedCSV(String url) throws IOException, NullPointerException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            var stream =  response.body().byteStream();
            var reader = new BufferedReader(new InputStreamReader(stream));

            Map<String, List<Tower>> map = new HashMap<>();

            String line = reader.readLine(); // ignore first line
            while((line=reader.readLine())!=null){

                String values[] = line.split(",");
                if(values.length >= 3) {
                    if(!map.containsKey(values[0])) {
                        map.put(values[0], new ArrayList<Tower>(List.of(new Tower[]{new Tower(values[1], Integer.parseInt(values[2]))})));
                    }
                    else {
                        map.get(values[0]).add(new Tower(values[1],Integer.parseInt(values[2])));
                    }
                }
            }

            return map;
        }
    }

}
