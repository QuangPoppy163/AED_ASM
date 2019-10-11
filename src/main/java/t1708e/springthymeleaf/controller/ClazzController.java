package t1708e.springthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.springthymeleaf.entity.Clazz;
import t1708e.springthymeleaf.entity.Student;
import t1708e.springthymeleaf.repository.ClazzRepository;
import t1708e.springthymeleaf.repository.StudentRepository;
import t1708e.springthymeleaf.service.ClazzService;
import t1708e.springthymeleaf.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/clazz")
public class ClazzController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    ClazzService clazzService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Clazz clazz = clazzService.getById(id);
        List<Student> studentList = studentService.getAll();
        if (clazz == null) {
            return "error/404";
        }
        model.addAttribute("studentList", studentList);
        model.addAttribute("clazz", clazz);
        return "clazz/detail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addStudent")
    public String addStudent(int[] studentIds, int clazzId) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : studentIds)
        {
            intList.add(i);
        }
        List<Student> studentList = studentRepository.findAllById(intList);
        Clazz clazz = clazzService.getById(clazzId);
        for (Student student: studentList
             ) {
            clazz.addStudent(student);
        }
        clazzRepository.save(clazz);
        return "redirect:/clazz/"+clazzId;
    }
}
