package interviews.india.yalochat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Random;

public class Round2 {

    BucketToken bucketToken = new BucketToken(20, new Date().getSeconds());

    static class CSVData {
        String phoneNumber;
        String code;

        public CSVData(String phoneNumber, String code) {
            this.phoneNumber = phoneNumber;
            this.code = code;
        }
    }

    // https://api-staging2.yalochat.com/awesome-bank/v1/messages
    public CSVData mockCSVData() {
        int leftLimit = 48;
        int rightLimit = 58;
        int numberLength = 10;
        int codeLength = 10;
        Random random = new Random();
        String generatedNumberStr = random.ints(leftLimit, rightLimit).limit(numberLength).toString();

        int codeLeftLimit = 48;
        int codeRightLimit = 122;
        String generatedCode = random.ints(codeLeftLimit, codeRightLimit).limit(codeLength).toString();
        return new CSVData(generatedNumberStr, generatedCode);
    }

    /**
     * {
     * "recipient_type": "individual",
     * "to": "<phone>",
     * "type": "text",
     * "text": {
     * "body": "Hello, your code is: *<code>*"
     * }
     * }
     *
     * @return
     */

    static class BucketToken {
        int numberOfToken;
        int second;

        public BucketToken(int numberOfToken, int second) {
            this.numberOfToken = numberOfToken;
            this.second = second;
        }
    }

    public int callAPI() {
        try {
            URL url = new URL("https://api-staging2.yalochat.com/awesome-bank/v1/messages");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            String token = "";
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Type", "application/json");
//            connection.set
            String body = "";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = body.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return -1;
    }

    public synchronized boolean isAPILimitReached(int currentSecond) {
        if (currentSecond == bucketToken.second) {
            if (bucketToken.numberOfToken > 0) {
                bucketToken.numberOfToken--;
                return true;
            } else {
                return false;
            }
        } else if (currentSecond > bucketToken.second) {
            bucketToken = new BucketToken(20, new Date().getSeconds());
            bucketToken.numberOfToken--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
