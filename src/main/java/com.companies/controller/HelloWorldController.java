package main.java.com.companies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by carlos.ochoa on 7/31/2015.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");

        return mav;
    }

    @RequestMapping(value = "/wizardoptions", method = RequestMethod.GET)
    public ModelAndView wizardoptions() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("wizardoptions");

        return mav;
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView export() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("export");

        return mav;
    }

}
