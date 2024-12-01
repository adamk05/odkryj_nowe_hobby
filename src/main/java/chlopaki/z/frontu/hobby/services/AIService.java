package chlopaki.z.frontu.hobby.services;

import chlopaki.z.frontu.hobby.domain.Hobby;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;

import java.util.List;

/**
 * Interfejs serwisu odpowiadającego za komunikację z API AI
 */
public interface AIService {

    /**
     * Metoda uzupełniająca pytanie kategoriami
     * @param question pytanie do uzupełnienia
     * @return zwraca uzupełnione pytanie
     */
    String completeQuestion(String question);

    /**
     * Pozyskiwanie obiektów Hobby z odpowiedzi z API AI
     * @param prompt zapytanie do AI
     * @return zwraca listę obiektów Hobby
     * @throws JsonProcessingException rzuca wyjątek przy błędnym parsowaniu na JSON
     */
    List<Hobby> generateContent(String prompt) throws JsonProcessingException;

    /**
     * Wysyłanie zapytania do AI i parsuje je do obiektu JSONArray
     * @param prompt Początek zapytania
     * @return zwraca obiekt JSONArray
     * @throws JsonProcessingException rzuca wyjątek przy błędnym parsowaniu na JSON
     */
    private JSONArray askAI(String prompt) throws JsonProcessingException {
        return null;
    }
}
