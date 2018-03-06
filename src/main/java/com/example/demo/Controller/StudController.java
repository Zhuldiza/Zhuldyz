package com.example.demo.Controller;


import com.example.demo.models.Stud;
import com.example.demo.reposotories.StudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/stud")
public class StudController {
    @Autowired
    private StudRepository StudRepository;
    private long a;

    @GetMapping("/main")
    public String allstud(Model model){
        List<Stud> studs = (List<Stud>) StudRepository.findAll();
        model.addAttribute("studs",studs);
        return "studs";
    }

    @RequestMapping("/addd")
    public String showFormmm(Model model){
        model.addAttribute("studt",new Stud());
        return "studupdate";
    }

    @GetMapping("/add")
    public String studForm(Model model){
        model.addAttribute("stud",new Stud());
        return "stud_add_form";
    }

    @GetMapping("/main2")
    public @ResponseBody Iterable<Stud> allstudents(){
        return StudRepository.findAll() ;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Stud stud){
        StudRepository.save(stud);
        return "redirect:/stud/main";
    }

    @PostMapping("/adds")
    public String addsStuds(@ModelAttribute Stud stud){
        Stud stud1 = new Stud();
        stud1.setId(a);
        stud1.setstudName(stud.getStudName());
        stud1.setYear(stud.getYear());
        StudRepository.save(stud1) ;

        return "redirect:/stud/main" ;
    }

    @RequestMapping(value = "/updatestud",method = RequestMethod.GET)
    public ModelAndView updateStuds(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Stud> stud = (Optional <Stud> ) StudRepository.findById(id);
        model.addAttribute("studt",stud);
        return new ModelAndView("studupdate");
    }

    @RequestMapping(value = "/deletestud",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        StudRepository.deleteById(idd);
        return new ModelAndView("redirect:/stud/main");
    }
}

