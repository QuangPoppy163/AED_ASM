package t1708e.springthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import t1708e.springthymeleaf.entity.Clazz;
import t1708e.springthymeleaf.entity.Student;
import t1708e.springthymeleaf.service.ClazzService;
import t1708e.springthymeleaf.service.StudentService;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClazzService clazzService;

    @GetMapping
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Student student = studentService.getByEmail(name);
        List<Clazz> clazzList = clazzService.getAll();
        model.addAttribute("student", student);
        model.addAttribute("clazzList", clazzList);
        return "index";
    }
}
