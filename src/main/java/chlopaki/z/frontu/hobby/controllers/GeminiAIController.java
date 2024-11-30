package chlopaki.z.frontu.hobby.controllers;

import chlopaki.z.frontu.hobby.domain.Form;
import chlopaki.z.frontu.hobby.domain.Hobby;
import chlopaki.z.frontu.hobby.services.GeminiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler odpowiadający za komunikację z API Gemini
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class GeminiAIController {

    private final GeminiService geminiService;

    /**
     * Konstruktor ustawiający serwis Gemini
     * @param geminiService serwis Gemini
     */
    public GeminiAIController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    /**
     * Metoda odpowiadająca za tworzenie zapytania do Gemini i zwracanie odpowiedzi
     * @param form obiekt odpowiedzi z formularza
     * @return zwraca listę obiektów Hobby
     * @throws JsonProcessingException rzuca wyjątek przy błędnym parsowaniu na JSON
     */
    @PostMapping("/recommendations")
    public List<Hobby> generate(@RequestBody Form form) throws JsonProcessingException {
        String question = "Zaproponuj 3 hobby dla aktywnej osoby w postaci tylko JSON (daj tylko JSON) tak jak tu, dopasuj każde hobby do jednej z kategorii (nie używaj polskich znaków w nazwach kategorii): ";

        question = geminiService.completeQuestion(question);

        question += " i tylko w tej konwencji: [{hobby1, opis hobby1, kategoria hobby1}, {hobby2, opis hobby2, kategoria hobby2}, {hobby3, opis hobby3, kategoria hobby3}], gdy użytkownik";

        question += " ma " + form.getTime() + " godzin wolnego czasu w tygodniu";
        if (form.isRiskyActivities()) question += ", lubi ryzykowne aktywności";
        if (form.isIndyvidual()) question += ", lubi indywidualne aktywności";
        else question += ", lubi grupowe aktywności";
        if (form.isSpontanic()) question += ", lubi spontaniczne aktywnośi";
        else question += ", lubi planowane aktywnosci";
        if (form.isFreshAirActivities()) question += ", lubi aktywności na świerzym powietrzu";
        if (form.isCreative()) question += ", lubi aktywności wymagające kreatywności";
        if (form.isManualActivities()) question += ", lubi aktywności manualne";
        if (form.isLikesScience()) question += ", lubi naukę";
        if (form.isLikeHistory()) question += ", lubi historię";
        if (form.isLikesNature()) question += ", lubi obcować z naturą";

        question += ".";

        List<Hobby> hobbies = geminiService.generateContent(question);

        return hobbies;
    }
}
