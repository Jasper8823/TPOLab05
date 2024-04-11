package org.example.tpolab05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class WebController {

    @RequestMapping(path = "/current-time", method = RequestMethod.GET)
    @ResponseBody
    public String current_time(@RequestParam(value ="timeZ", required = false,defaultValue = "CET") String timeZ, @RequestParam(value = "timeD", required = false, defaultValue = "HH:mm:ss.SSSS") String timeD, @RequestParam(value = "yearD", required = false,defaultValue = "yyyy-MM-dd") String yearD) {
        LocalDate year = java.time.LocalDate.now();
        LocalTime time = java.time.LocalTime.now();

        ZonedDateTime zd = ZonedDateTime.of(year, time, ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of(timeZ));

        DateTimeFormatter tFormat = DateTimeFormatter.ofPattern(timeD);
        DateTimeFormatter yFormat = DateTimeFormatter.ofPattern(yearD);

        String timeF = zd.format(tFormat);
        String yearF = zd.format(yFormat);

        return "<h2><center> Time: "+timeF+"  |  "+"Date: "+yearF+"</center> </h2>";
    }

    @RequestMapping(path = "/current-year", method = RequestMethod.GET)
    @ResponseBody
    public String current_year() {
        LocalDate year = java.time.LocalDate.now();
        DateTimeFormatter yFormat = DateTimeFormatter.ofPattern("YYYY");
        String yearF = year.format(yFormat);
        return "<h1><center> "+yearF+"</center> </h1>";
    }
    @PostMapping("/convert-number")
    @ResponseBody
    public String convertNumber(@RequestParam("value") String value,
                                @RequestParam("fromBase") int fromBase,
                                @RequestParam("toBase") int toBase) {
        return "das";
    }


}
