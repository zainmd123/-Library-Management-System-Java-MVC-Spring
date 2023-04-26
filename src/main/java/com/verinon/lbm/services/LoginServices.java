package com.verinon.lbm.services;
import org.springframework.stereotype.Component;


@Component
//@Service
public class LoginServices
{
    public boolean checkUserAuthentication(String name, String password)
    {
        return name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }
}
