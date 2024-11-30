package chlopaki.z.frontu.hobby.services;

import chlopaki.z.frontu.hobby.domain.Hobby;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private List<Hobby> hobbies = new ArrayList<Hobby>();

    public List<Hobby> generateContent(String prompt) throws JsonProcessingException {
        final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, String> textMap = new HashMap<>();
        textMap.put("text", prompt);

        List<Map<String, String>> partsList = new ArrayList<>();
        partsList.add(textMap);

        Map<String, Object> partsMap = new HashMap<>();
        partsMap.put("parts", partsList);

        List<Map<String, Object>> contentsList = new ArrayList<>();
        contentsList.add(partsMap);

        Map<String, Object> topLevelMap = new HashMap<>();
        topLevelMap.put("contents", contentsList);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(topLevelMap, headers);

        ResponseEntity<String> response = restTemplate.exchange(GEMINI_URL, HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());

        String jsonString = response.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(jsonString);

        String text = rootNode
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        String cleanedText = text.replaceFirst("^```json\\n", "").replaceFirst("\\n```$", "");

        System.out.println(cleanedText);

        JSONArray jsonArray = new JSONArray(cleanedText);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject hobbyObject = jsonArray.getJSONObject(i);

            if (hobbyObject.has("hobby") && hobbyObject.has("opis")) {
                hobbies.add(new Hobby(hobbyObject.getString("hobby"), hobbyObject.getString("opis")));
            }
        }

        return hobbies;
    }
}
