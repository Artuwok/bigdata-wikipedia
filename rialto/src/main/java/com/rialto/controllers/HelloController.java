package com.rialto.controllers;


import com.rialto.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    private RateService rateService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity getPairs() {


        return new ResponseEntity(rateService.getRates(), HttpStatus.OK);
    }

    {

    }
    public ModelAndView index() {

        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
