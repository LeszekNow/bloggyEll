package com.leszeknowinski.bloggyEll.models.controllers;


import com.leszeknowinski.bloggyEll.models.forms.UserRegistrationAndLoginForm;
import com.leszeknowinski.bloggyEll.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAccessController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRegistrationAndLoginForm", new UserRegistrationAndLoginForm());
        return "loginAndRegistrationForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegistrationAndLoginForm userRegistrationAndLoginForm, Model model) {
        if (userService.isUserExistByLogin(userRegistrationAndLoginForm.getLogin())) {
            model.addAttribute("infoTwo", "This login is arrested!");
            return "loginAndRegistrationForm";
        }
        userService.register(userRegistrationAndLoginForm);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userRegistrationAndLoginForm", new UserRegistrationAndLoginForm());
        return "loginAndRegistrationForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserRegistrationAndLoginForm userRegistrationAndLoginForm, Model model){
        if(!userService.authenticate(userRegistrationAndLoginForm.getLogin(), userRegistrationAndLoginForm.getPassword())){
            model.addAttribute("info", "Invalid login or password!");
            return "loginAndRegistrationForm";
        }
        return "redirect:/";
    }

}
