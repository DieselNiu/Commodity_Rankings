package com.github.hcsp.controller;

import com.github.hcsp.Service.MallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.HashMap;

@Controller
public class MallController {
    private MallService mallService;

    @Inject
    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("items", mallService.getGoodAmountRank());
        return new ModelAndView("rank", params);
    }

    @RestController
    public class HelloController {
        @RequestMapping("/")
        public Object index() {
            return mallService.getGoodAmountRank();
        }

    }
}
