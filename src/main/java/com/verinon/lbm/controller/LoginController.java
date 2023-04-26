package com.verinon.lbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.verinon.lbm.services.LoginServices;

@Controller
@SessionAttributes("username")
public class LoginController
{
    @Autowired
    LoginServices services;

    @GetMapping("/userlogin")
    public String showLoginPage(ModelMap model)
    {
        return "loginpage";
    }

    @PostMapping("/userlogin")
    /*public String showMainHomePageWhenLogin(ModelMap model,@RequestParam String username,@RequestParam String password)
    {
        boolean authentication= services.checkUserAuthentication(username,password);
        if(!authentication)
        {
            model.put("errorMessage","Bad Credentials");
            return "loginpage";
        }

        model.put("username", "Admin");
        return "home";
    }*/
    @RequestMapping("/home")
    public String showHomePage(ModelMap model)
    {
        return "home";
    }

    @RequestMapping("/about")
    public String logoutUser(ModelMap model)
    {
        return "aboutpage";
    }

    @RequestMapping("/contactus")
    public String contactUsPage(ModelMap model)
    {
        return "contactus";
    }
}
