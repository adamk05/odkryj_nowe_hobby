package chlopaki.z.frontu.hobby.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class FormController {

    @RequestMapping("/form")
    public Map<String, String> form() {
        Map<String, String> text = new HashMap<>();
        text.put("Tekst", "Zobaczymy");
        return text;
    }
}
