package com.rialto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    public ResponseEntity checkLogin() {
        return new ResponseEntity("login", HttpStatus.OK);
    }
}
