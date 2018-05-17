package de.meziane.spring.boot.controller;

import java.util.List;

// for library loggers
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.meziane.spring.boot.mapper.StudentBatisRepo;
import de.meziane.spring.boot.model.Student;

/**
 * @author M. Kettou
 */

@Controller

public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentBatisRepo repo;

    @RequestMapping("hello")
    public String sayhello() {
        return "Hello from MyBatis.";
    }

    @RequestMapping(value = "student/new")
    public String addStudent(final Model model) {
        model.addAttribute("student", new Student());
        logger.info(">>> GET REQUEST student/new RECEIVED   <<<");
        return "studentForm";
    }

    @GetMapping("students")
    public String getAll(final Model data) {
        // final List<Student> students = repo.findAll();
        logger.info(">>>   GET REQUEST students RECEIVED   <<<");
        data.addAttribute("students", repo.findAll());
        logger.info("Students: {}", repo.findAll());
        return "students";
    }

    @GetMapping("student/{id}")
    public String showStudent(@PathVariable final long id, final Model model) {
        logger.info(">>>   GET REQUEST student/{} RECEIVED   <<<", id);
        final Student student = repo.findById(id);
        model.addAttribute("student", student);
        return "studentView";
    }

    @GetMapping("student/edit/{id}")
    public String editStudent(@PathVariable final long id, final Model model) {
        final Student student = repo.findById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @PostMapping("/student")
    public String saveStudent(final Student student) {
        logger.info(">>>   POST REQUEST student RECEIVED   <<<");
        if (student.getId() != null) {
            final Long idUpdated = repo.update(student);
            logger.info(">>>   student with id = {} has been updated   <<<", idUpdated);
        } else {
            final Long idInserted = repo.save(student);
            logger.info(">>>   student with id = {} has been inserted.   <<<", idInserted);
        }

        return "redirect:/student/" + student.getId();
    }

    @RequestMapping("student/delete/{id}")
    public String delete(@PathVariable final Long id) {
        logger.info(">>>   DELETE REQUEST student/delete/{} RECEIVED   <<<", id);
        final Long idDeleted = repo.delete(id);
        logger.info(">>>   student with id = {} has been deleted    <<<", idDeleted);
        return "redirect:/students";
    }

}
