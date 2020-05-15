package ru.vlsv.training.seven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsv.training.seven.entities.Student;
import ru.vlsv.training.seven.services.StudentService;
import javax.validation.Valid;


/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 14.05.2020
 * @link https://github.com/Centnerman
 */

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String studentsPage(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("edit", true);
        model.addAttribute("student", studentService.findById(id));
        return "student";
    }

    @GetMapping({"/create"})
    public String create(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("student") Student student, Model model) {
        studentService.update(student);
//        model.addAttribute("users", studentService.findAll());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id) {
        studentService.delete(id);
//        model.addAttribute("users", studentService.findAll());
        return "redirect:/";
    }

}
