package practice.http;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpCallJava11 {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    /**
     * Java 11
     *
     * @throws Exception
     */
    private void sendGet() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());
    }

    /**
     * Java 11
     *
     * @throws Exception
     */
    private void sendPost() throws Exception {
        // form parameters
        Map<Object, Object> data = new HashMap<>();
        data.put("username", "abc");
        data.put("password", "123");
        data.put("custom", "secret");
        data.put("ts", System.currentTimeMillis());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());
    }

    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) builder.append("&");
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder);
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    public static void main(String[] args) throws Exception {
        HttpCallJava11 httpCallJava11 = new HttpCallJava11();
        System.out.println("Testing 1 - Send Http GET request");
        httpCallJava11.sendGet();
        System.out.println("Testing 2 - Send Http POST request");
        httpCallJava11.sendPost();
    }
}
