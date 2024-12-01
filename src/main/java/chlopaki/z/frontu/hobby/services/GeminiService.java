package chlopaki.z.frontu.hobby.services;

import chlopaki.z.frontu.hobby.domain.Hobby;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Serwis odpowiadający za komunikację z API Gemini
 */
@Service
public class GeminiService {

    private final String[] categories = {
            "Sporty wytrzymalosciowe",
            "Turystyka",
            "Kajakarstwo",
            "Turystyka gorska",
            "Wedkarstwo",
            "Sporty zimowe",
            "Sporty motorowe",
            "Sporty powietrzne",
            "Sporty jezdzieckie",
            "Sporty strzeleckie",
            "Technologia i robotyka",
            "Modelarstwo",
            "Sztuka",
            "Sporty walki",
            "Aktywnosci kreatywne",
            "Aktywnosci naukowe",
            "Projektowanie",
            "Przyrodnicze",
            "Rekonstrukcje historyczne",
            "Programowanie",
            "Gry komputerowe",
            "Wspinaczka",
            "Rower"
    };

    /**
     * Metoda uzupełniająca pytanie kategoriami
     * @param question pytanie do uzupełnienia
     * @return zwraca uzupełnione pytanie
     */
    public String completeQuestion(String question) {

        String prompt = question;

        for (int i = 0; i < categories.length; i++) {
            if (i == 0) {
                prompt += categories[i];
                continue;
            }
            prompt += ", " + categories[i];
            if (i == categories.length - 1) prompt += ", " + categories[i] + ": ";
        }

        return prompt;
    }

    // Klucz API do Gemini
    @Value("${google.gemini.api-key}")
    private String apiKey;

    /**
     * Domyślny konstruktor
     */
    public GeminiService() {}

    /**
     * Pozyskiwanie obiektów Hobby z odpowiedzi z API Gemini
     * @param prompt zapytanie do Gemini
     * @return zwraca listę obiektów Hobby
     * @throws JsonProcessingException rzuca wyjątek przy błędnym parsowaniu na JSON
     */
    public List<Hobby> generateContent(String prompt) throws JsonProcessingException {

        List<Hobby> hobbies = new ArrayList<Hobby>();

        JSONArray jsonArray = askGemini(prompt);

        // Pozyskiwanie obiektów Hobby z odpowiedzi
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject hobbyObject = jsonArray.getJSONObject(i);

            // Tworzenie obiektów Hobby
            if (hobbyObject.has("hobby1") && hobbyObject.has("opis hobby1") && hobbyObject.has("kategoria hobby1")) {
                hobbies.add(new Hobby(hobbyObject.getString("hobby1"), hobbyObject.getString("opis hobby1"), hobbyObject.getString("kategoria hobby1")));
            }

            if (hobbyObject.has("hobby2") && hobbyObject.has("opis hobby2") && hobbyObject.has("kategoria hobby2")) {
                hobbies.add(new Hobby(hobbyObject.getString("hobby2"), hobbyObject.getString("opis hobby2"), hobbyObject.getString("kategoria hobby2")));
            }

            if (hobbyObject.has("hobby3") && hobbyObject.has("opis hobby3") && hobbyObject.has("kategoria hobby3")) {
                hobbies.add(new Hobby(hobbyObject.getString("hobby3"), hobbyObject.getString("opis hobby3"), hobbyObject.getString("kategoria hobby3")));
            }
        }

        return hobbies;
    }

    /**
     * Wysyłanie zapytania do Gemini i parsuje je do obiektu JSONArray
     * @param prompt Początek zapytania
     * @return zwraca obiekt JSONArray
     * @throws JsonProcessingException rzuca wyjątek przy błędnym parsowaniu na JSON
     */
    private JSONArray askGemini(String prompt) throws JsonProcessingException {
        final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
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

        String jsonString = response.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(jsonString);

        // Pozyskanie wartości "text" z drzewka JSON
        String text = rootNode
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        // Usunięcie "```json" z początku
        String cleanedJson = text.replaceFirst("^```json\\n", "");

        // Usunięcie "```" z końca
        cleanedJson = cleanedJson.replaceFirst("\\n```$", "");

        // Parsowanie na JSON
        return new JSONArray(cleanedJson);
    }
}
