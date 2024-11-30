package chlopaki.z.frontu.hobby.controllers;

import chlopaki.z.frontu.hobby.domain.Form;
import chlopaki.z.frontu.hobby.domain.Hobby;
import chlopaki.z.frontu.hobby.services.GeminiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GeminiAIController {

    private final GeminiService geminiService;

    public GeminiAIController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/recommendations")
    public List<Hobby> generate(@RequestBody Form form) throws JsonProcessingException {
        String question = "Zaproponuj 3 hobby dla aktywnej osoby w postaci tylko JSON (daj tylko JSON) tak jak tu, tylko z jedną kategorią (w miarę różne kategorie): [{hobby1, opis hobby1, kategoria hobby1}, {hobby2, opis hobby2, kategoria hobby2}, {hobby3, opis hobby3, kategoria hobby3}], gdy użytkownik";

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
        if (form.isLikesNature()) question += ", lubi obcować z naturą.";

        List<Hobby> hobbies = geminiService.generateContent(question);

        return hobbies;

    }
}
