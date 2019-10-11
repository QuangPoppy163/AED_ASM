package t1708e.springthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import t1708e.springthymeleaf.entity.Student;
import t1708e.springthymeleaf.service.ClazzService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @GetMapping
    public String loginView(){
        return "login";
    }
}
