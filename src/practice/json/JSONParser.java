package practice.json;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JSONParser {

    private final ScriptEngine scriptEngine;

    public JSONParser() {
        ScriptEngineManager sem = new ScriptEngineManager();
        List<ScriptEngineFactory> engines = sem.getEngineFactories();
        for (ScriptEngineFactory sef : engines) System.out.println("name: " + sef.getEngineName() + " ");
        this.scriptEngine = sem.getEngineByName("JavaScript");
    }

    public void parseJsonIntoMap(String jsonString) throws IOException, ScriptException {
        String script = "Java.asJSONCompatible(" + jsonString + ")";
        Object result = this.scriptEngine.eval(script);
        Map<?, ?> jsonContentMap = (Map<?, ?>) result;
        jsonContentMap.forEach((key, val) -> {
            System.out.println("key: " + key + ", value: " + val);
        });
    }

    public static void main(String[] args) throws ScriptException, IOException {
//        String jsonString = "{\"name\": \"Ajju\",\"number\": \"123\"}";
//        JSONParser jsonParser = new JSONParser();
//        jsonParser.parseJsonIntoMap(jsonString);
//        map.forEach(());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println("t: " + t);
        for (int i = 0; i < t; i++){
            String line = sc.nextLine();
            String[] cities = line.trim().split("\\s+");
            for (String city : cities) System.out.println(city);
        }
    }
}
