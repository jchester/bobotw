package com.bobotw.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpController {
    @GetMapping("/up")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("UP");
    }
}
