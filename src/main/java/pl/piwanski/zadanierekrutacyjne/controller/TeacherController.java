package pl.piwanski.zadanierekrutacyjne.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.TeacherDTO;
import pl.piwanski.zadanierekrutacyjne.service.SearchService;
import pl.piwanski.zadanierekrutacyjne.service.TeacherService;

import javax.validation.Valid;
import javax.validation.Validator;


@RequiredArgsConstructor
@Controller
public class TeacherController {
    private final TeacherService teacherService;
    private final SearchService searchService;
    @Bean
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }

    @RequestMapping(value = "zapiszNauczyciela", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("teacherDTO", new TeacherDTO());
        return "zapiszNauczyciela";
    }

    @RequestMapping(value = "/zapiszNauczyciela", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("teacherDTO") TeacherDTO teacherDTO, BindingResult result) {
        Teacher teacher = null;
        if (result.hasErrors()) {
            return "zapiszNauczyciela";
        }
            teacher = teacherService.register(teacherDTO);
        return "zapiszNauczyciela";
        }


    @GetMapping(value = "/delete")
    public String delete(Teacher teacher) {
        teacherService.delete(teacher.getId());
        return "nauczyciele";
    }

    @GetMapping(value = "/edit")
    public String editForm(Teacher teacher, Model model) {
        model.addAttribute("teacher", teacherService.get(teacher.getId()).get());
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String edit(@Valid TeacherDTO teacherDTO, BindingResult result) {
        if (!result.hasErrors()) {
            teacherService.updateEdit(teacherDTO);
            return "nauczyciele";
        }
        return "zapiszNauczyciela";
    }

    @RequestMapping(value = "/nauczyciele", method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "nauczyciele";
    }
    @GetMapping(value = "/wyszukajNauczyciela")
    public String teacherSearch(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        model.addAttribute("teachers", searchService.searchT(firstName, lastName));
        return "nauczyciele";
    }
}
