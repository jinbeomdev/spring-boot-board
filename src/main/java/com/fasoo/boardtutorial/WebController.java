package com.fasoo.boardtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = {"/", "/home"})
    public String index() {
        return "homePage";
    }

    @GetMapping("contactus")
    public String contactus(Model model) {
        model.addAttribute("address", "vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }
}
