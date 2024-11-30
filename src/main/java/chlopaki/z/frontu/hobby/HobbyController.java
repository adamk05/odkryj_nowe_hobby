package chlopaki.z.frontu.hobby;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HobbyController {


    @GetMapping("/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        return map;       
    }
}
