package com.readspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yanggy
 */
@Controller
@RequestMapping("/request")
public class RequestMappingController {

    @RequestMapping("/mapping")
    public ModelAndView mapping() {
        System.out.println("Request mapping controller working.");
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("attr_name", "kato");
        return modelAndView;
    }
}
