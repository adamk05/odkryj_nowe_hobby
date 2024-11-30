package chlopaki.z.frontu.hobby.services;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${google.gemini.api-key}")
    private String apiKey;

    private String hobby1;

    public String generateContent(String prompt) {
        final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, String> textMap = new HashMap<>();
        textMap.put("text", prompt);

        // Wrap the "text" map in a list (parts array)
        List<Map<String, String>> partsList = new ArrayList<>();
        partsList.add(textMap);

        // Create the "parts" map
        Map<String, Object> partsMap = new HashMap<>();
        partsMap.put("parts", partsList);

        // Wrap the "parts" map in a list (contents array)
        List<Map<String, Object>> contentsList = new ArrayList<>();
        contentsList.add(partsMap);

        // Create the top-level map
        Map<String, Object> topLevelMap = new HashMap<>();
        topLevelMap.put("contents", contentsList);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(topLevelMap, headers);

        ResponseEntity<String> response = restTemplate.exchange(GEMINI_URL, HttpMethod.POST, entity, String.class);

        /*String jasonString = response.getBody();

        JSONArray jsonArray = new JSONArray(jasonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject hobbyObject = jsonArray.getJSONObject(i);

            if (hobbyObject.has("hobby1") && hobbyObject.has("opis hobby1")) {
                hobby1 = hobbyObject.getString("hobb1");
            }
        }*/

        return response.getBody();
    }
}
