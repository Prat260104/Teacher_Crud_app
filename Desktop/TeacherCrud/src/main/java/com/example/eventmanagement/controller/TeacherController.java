package com.example.eventmanagement.controller;

import com.example.eventmanagement.model.Teacher;
import com.example.eventmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public String getAllTeachers(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers";
    }

    @PostMapping
    public String addTeacher(@ModelAttribute("newTeacher") Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
        model.addAttribute("teacher", teacher);
        return "edit_teacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute("updatedTeacher") Teacher teacher) {
        teacher.setId(id);
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
        model.addAttribute("teacher", teacher);
        return "delete_confirm";
    }

    @GetMapping("/perform-delete/{id}")
    public String deleteTeacherConfirmed(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/teachers";
    }

    // Strict REST Endpoints
    @PutMapping("/{id}")
    @ResponseBody
    public Teacher updateTeacherRest(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteTeacherRest(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return "Teacher deleted";
    }
}
