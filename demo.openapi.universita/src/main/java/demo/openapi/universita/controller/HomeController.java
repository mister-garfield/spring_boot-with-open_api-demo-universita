package demo.openapi.universita.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to OpenAPI api documentation (swagger)
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}