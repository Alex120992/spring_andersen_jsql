package ru.zateev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zateev.Entity.Person;
import ru.zateev.service.PersonService;
import ru.zateev.validator.Validator;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PersonService personService;
    @Autowired
    private Validator validator;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Person> allPeople = personService.getAllPersons();
        model.addAttribute("allPeop", allPeople);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Person person = new Person();
        model.addAttribute("personsss", person);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("personsss") Person empl, Model model) {

        validator.generalValidator(empl);

        if (empl.isValide()) {
            System.out.println("Работает");
            model.addAttribute("personsss", empl);
            return "employee-info";
        }
        System.out.println(empl);
        personService.savePerson(empl);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("personsss", person);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam("empId") int id){
        personService.deletePerson(id);
        return "redirect:/";
    }
}
