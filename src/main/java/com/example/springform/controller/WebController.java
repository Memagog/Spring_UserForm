package com.example.springform.controller;


import com.example.springform.domain.UserForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/")
    public String showForm(UserForm userForm){
        return "userform";
    }
    @PostMapping("/")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           return "userform";
       }
       return "redirect:/results";
    }
}
