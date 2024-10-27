package com.bobotw.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankController {

    @GetMapping("/rank")
    public String rank() {
        return "rankView";
    }
}
