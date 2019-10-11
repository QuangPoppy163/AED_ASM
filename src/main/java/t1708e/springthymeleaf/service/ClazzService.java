package t1708e.springthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1708e.springthymeleaf.entity.Clazz;
import t1708e.springthymeleaf.entity.Student;
import t1708e.springthymeleaf.repository.ClazzRepository;

import java.util.List;

@Service
public class ClazzService {

    @Autowired
    ClazzRepository clazzRepository;

    public List<Clazz> getAll(){
        return clazzRepository.findAll();
    }

    public Clazz getById(int id) {
        return clazzRepository.findById(id).orElse(null);
    }
}
