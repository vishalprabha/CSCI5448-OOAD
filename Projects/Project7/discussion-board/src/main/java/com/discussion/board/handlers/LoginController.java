package com.discussion.board.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    // Route to login page
    @GetMapping("login")
    public String displayLogin() {
        return "login";
    }
}