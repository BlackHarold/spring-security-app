package home.blackharold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.Function;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("inDate") String inDate) {
        System.out.println(inDate);

//        yyyy-MM-dd-HH-mm-ss
        int inYear = Integer.parseInt(inDate.substring(0, 4));
        System.out.println(inYear);
        int inMonth = Integer.parseInt(inDate.substring(5, 7));
        System.out.println(inMonth);
        int inDay = Integer.parseInt(inDate.substring(8, 10));
        System.out.println(inDay);
        int inHour = Integer.parseInt(inDate.substring(11, 13));
        System.out.println(inHour);
        int inMinute = Integer.parseInt(inDate.substring(14, 16));
        System.out.println(inMinute);

        Function<Double, Integer> trunc = (d) -> d.intValue();

        double jd = 367 * inYear - trunc.apply(7.0 * (inYear + trunc.apply((inMonth + 9.0) / 12)) / 4)
                + trunc.apply(275.0 * inMonth / 9)
                + inDay
                + 1721013.5 + 1.0 * (inHour + inMinute / 60.0) / 24
                - 0.5 * Math.signum(100 * inYear + inMonth - 190002.5)
                + 0.5;
        return "" + jd;
    }
}
