package org.example.tpolab05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CounterController {
    @PostMapping(path = "/convert")
    @ResponseBody
    public String index(@RequestParam String value, @RequestParam int baseF, @RequestParam int baseT) {
        String val = String.valueOf(Integer.parseInt(value, baseF));
        return "<center><h1>Conversion Results:</h1>\n" +
                "<h2>Converted Value:  " + Integer.toString(Integer.parseInt(val, baseF), baseT) + " </h2>\n" +
                "<h2>Binary: " + Integer.toString(Integer.parseInt(val, baseF), 2) + "</h2>\n" +
                "<h2>Octal: " + Integer.toString(Integer.parseInt(val, baseF), 8) + "</h2>\n" +
                "<h2>Decimal: " + Integer.toString(Integer.parseInt(val, baseF), 10) + "</h2>\n" +
                "<h2>Hexadecimal: " + Integer.toString(Integer.parseInt(val, baseF), 16) + "</center></h2>\n";
    }
}
