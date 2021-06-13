package ru.zateev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zateev.Entity.Person;
import ru.zateev.service.PersonService;
import ru.zateev.service.PersonServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        personService = new PersonServiceImpl();
        List<Person> allPeople = personService.getAllPersons();
        model.addAttribute("allPeop", allPeople);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Person person = new Person();
        model.addAttribute("employeees", person);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employeees") Person empl) {

        personService.savePerson(empl);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("employeees", person);
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam("empId") int id){
        personService.deletePerson(id);
        return "redirect:/";
    }
}
