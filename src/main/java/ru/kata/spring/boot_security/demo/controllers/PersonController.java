package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.models.Person;
import ru.kata.spring.boot_security.demo.service.PersonService;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;

    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/persons")
    public String getAllPerson(@RequestParam(value = "allperson", required = false) String personlist, Model model) {
        model.addAttribute("persons", personService.getAll(personlist));
        return "persons";
    }

    @GetMapping("/person_id")
    public String getPerson(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("person", personService.getById(Long.parseLong(id)));
        return "show";
    }

    @GetMapping("add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "add_new_person";
    }

    @PostMapping("create")
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.add(person);
        return "redirect:/persons";
    }

    @PostMapping("/edit_person")
    public String editPerson(@RequestParam("id") String id, Model model) {
        model.addAttribute("person", personService.getById(Long.parseLong(id)));
        return "edit_person";
    }

    @PostMapping("/update")
    public String updatePerson(@ModelAttribute("person") Person person) {
        personService.edit(person);
        return "redirect:/persons";
    }

    @PostMapping("/delete_person")
    public String deletePerson(@RequestParam("id") String id) {
        personService.delete(Long.parseLong(id));
        return "redirect:/persons";
    }
}