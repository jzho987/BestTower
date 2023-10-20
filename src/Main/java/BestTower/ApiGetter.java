package BestTower;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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

}
