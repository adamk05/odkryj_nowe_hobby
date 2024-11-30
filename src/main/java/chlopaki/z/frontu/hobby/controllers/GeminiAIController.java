package chlopaki.z.frontu.hobby.controllers;

import chlopaki.z.frontu.hobby.services.GeminiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
public class OpenAIController {

    private final GeminiService geminiService;

    public OpenAIController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/openai")
    public String openai(@RequestParam String question) {
        return geminiService.generateContent(question);
    }
}
