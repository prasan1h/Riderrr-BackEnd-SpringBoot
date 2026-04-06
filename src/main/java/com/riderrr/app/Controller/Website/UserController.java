package com.riderrr.app.Controller.Website;

import com.riderrr.app.Service.Website.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String Home(){
        return userService.home();
    }
}
