package com.example.login.Controller;

import com.example.login.Entity.Student;
import com.example.login.Request.StudentRequest;
import com.example.login.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/")
    public String index(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("role", userDetails.getAuthorities());
        return "index";
    }

    @GetMapping("/admin")
    public  String admin(Model model) {
        List<Student> studentList=studentService.getAll();
        model.addAttribute("Student",studentList);
        return "studentList";
    }

    @GetMapping("/admin/add")
    public  String add(){
        return "add";
    }

    @PostMapping("/admin/add")
    public String add(@Valid @ModelAttribute StudentRequest studentRequest){
        studentService.add(studentRequest);
        return "redirect:/admin";
    }

    @GetMapping("/admin/remove/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        studentService.remove(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/update/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model){
        Student student=studentService.getById(id);
        model.addAttribute("student",student);
        return "update";
    }
    @PostMapping("/admin/update/{id}")
    public  String update(@PathVariable(name = "id") Long id, @Valid @ModelAttribute StudentRequest studentRequest){
        studentService.edit(id,studentRequest);
        return "redirect:/admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/hello")
    public String e() {
        return "hr";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

}
