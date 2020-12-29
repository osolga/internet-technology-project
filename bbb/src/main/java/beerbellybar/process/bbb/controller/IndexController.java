package beerbellybar.process.bbb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public String getIndexView() {
        return "index.html";
    }

    @GetMapping("/home")
    public String getHomeView() {
        return "front-page-index.html";
    }

    @GetMapping("/menu")
    public String getMenuView() {
        return "menu.html";
    }
}
