package BestTower;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
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

    public void getMappedCSV(String url, Map<String, Map<String,List<Integer>>> out) throws IOException, NullPointerException {

        Map<String, Map<String,List<Integer>>> map = new HashMap<>();

        if(out != null) {
            map = out;
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            var stream =  response.body().byteStream();
            var reader = new BufferedReader(new InputStreamReader(stream));

            ParseHelper.CSVstreamToMap(stream, map);
        }
    }

}
