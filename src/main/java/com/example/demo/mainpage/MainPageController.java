package com.example.demo.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    // This endpoint will be called when you access the root URL
    @GetMapping("/")
    public String showMainPage(Model model) {
        // You can add more attributes to the model if needed
        return "index"; // This will render the "index.html" page
    }
}
