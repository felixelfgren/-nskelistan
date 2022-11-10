package com.santashelpers.onskelistan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class OnskelistanController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", new User());

        return "/login";
    }

    @PostMapping("/")
    public String login(HttpSession session, @ModelAttribute User user {
    }

    @GetMapping("/login")

}
