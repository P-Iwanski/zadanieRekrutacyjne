package pl.piwanski.zadanierekrutacyjne.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.StudentDTO;
import pl.piwanski.zadanierekrutacyjne.model.dto.TeacherDTO;
import pl.piwanski.zadanierekrutacyjne.service.SearchService;
import pl.piwanski.zadanierekrutacyjne.service.StudentService;

import javax.validation.Valid;
import javax.validation.Validator;

@RequiredArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;
    private final SearchService searchService;

    @RequestMapping(value = "/zapiszStudenta", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());

        return "zapiszStudenta";
    }

    @RequestMapping(value = "/zapiszStudenta", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, BindingResult result) {
        Student student = null;
        if (!result.hasErrors()) {
            student = studentService.register(studentDTO);
        }
        return "zapiszStudenta";
    }

    @GetMapping(value = "/deleteS")
    public String delete(Student student) {
        studentService.delete(student.getId());
        return "studenci";
    }

    @GetMapping(value = "/editS")
    public String editForm(Student student, Model model) {
        model.addAttribute("student", studentService.get(student.getId()).get());
        return "editS";
    }

    @PostMapping(value = "/editS")
    public String edit(@Valid StudentDTO studentDTO, BindingResult result) {
        if (!result.hasErrors()) {
            studentService.updateEdit(studentDTO);
            return "studenci";
        }
        return "zapiszStudenta";
    }

    @RequestMapping(value = "/studenci", method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studenci";
    }

    @GetMapping(value = "/wyszukajStudenta")
    public String teacherSearch(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        model.addAttribute("students", searchService.searchS(firstName, lastName));
        return "nauczyciele";
    }
}
