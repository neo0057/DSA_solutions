package practice.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpCall {
    private void sendGet() throws Exception {
        String url = "https://www.google.com/search?q=mkyong";
        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();
        // optional default is GET
        httpClient.setRequestMethod("GET");
        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            //print result
            System.out.println(response.toString());
        }
    }

    public void post(String completeUrl, String body) throws IOException {
        URL url = new URL("https://reqres.in/api/users");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);

        //JSON String need to be constructed for the specific resource.
        //We may construct complex JSON using any third-party JSON libraries such as jackson or org.json
        String jsonInputString = "{\"name\": \"Ajeet\", \"job\": \"Programmer\"}";
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        
        int code = con.getResponseCode();
        System.out.println(code);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
        }
    }

    private void sendPost() throws Exception {

        // url is missing?
        //String url = "https://selfsolve.apple.com/wcResults.do";
        String url = "https://httpbin.org/post";

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reuqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            //print result
            System.out.println(response.toString());
        }
    }

    public static void main(String[] args) throws Exception {

        HttpCall obj = new HttpCall();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();

        System.out.println("Testing 2 - Send Http POST request");
        obj.sendPost();

    }
}
