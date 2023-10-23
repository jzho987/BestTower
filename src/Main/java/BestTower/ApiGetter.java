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
     * @param url url of the HTTP request
     * @return String response body
     * @throws IOException throws IO Exception
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

    /**
     * Turns the response of any HTTP requests that responds with an Input Stream of CSV data into the mapped format.
     * The out put is captured by providing an "out" map in the input.
     *
     * @param url url of the HTTP request
     * @param out pointer to the output that needs to be supplied to get output from the function
     * @throws IOException throws IO Exception
     * @throws NullPointerException throws Null Pointer Exception
     */
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

            ParseHelper.CSVstreamToMap(stream, map);
        }
    }

}
