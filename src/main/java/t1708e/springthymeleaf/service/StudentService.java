package t1708e.springthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import t1708e.springthymeleaf.entity.Student;
import t1708e.springthymeleaf.repository.StudentRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Student create(Student student) {
        student.setStatus(1);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student getByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

}
