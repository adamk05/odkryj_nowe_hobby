package chlopaki.z.frontu.hobby.controllers;

import chlopaki.z.frontu.hobby.services.GeminiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
public class GeminiAIController {

    private final GeminiService geminiService;

    public GeminiAIController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/gemini")
    public String generate(@RequestParam String question) {
        if (question == null || question.trim().isEmpty()) {
            throw new IllegalArgumentException("Question parameter cannot be empty");
        }
        try {
            return geminiService.generateContent(question);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
