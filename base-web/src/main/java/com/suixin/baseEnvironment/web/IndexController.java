package com.suixin.baseEnvironment.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private static Logger logger=Logger.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

}
