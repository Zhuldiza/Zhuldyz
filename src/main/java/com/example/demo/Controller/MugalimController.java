package com.example.demo.Controller;


import com.example.demo.models.Mugalim;
import com.example.demo.reposotories.MugalimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(path = "/demo")
public class MugalimController {
    @Autowired
    private MugalimRepository mugalimRepository ;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("mugalim",new Mugalim());
        return "mugalim_add_form";
    }
    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute(",mugalimm",new Mugalim());
        return "update";
    }
    @PostMapping("/add")
    public String addMugalim(@ModelAttribute Mugalim mugalim){
        mugalimRepository.save(mugalim) ;

        return "redirect:/demo/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Mugalim> allMugalims(){
        return mugalimRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allMugalims2(Model model){
        List<Mugalim> mugalims = (List<Mugalim>) mugalimRepository.findAll();
        model.addAttribute("mugalims", mugalims) ;
        return "mugalims" ;
    }

    @PostMapping("/adds")
    public String addsMugalim(@ModelAttribute Mugalim mugalim){
        Mugalim mugalim1 = new Mugalim();
        mugalim1.setId(a);
        mugalim1.setFirstName(mugalim.getFirstName());
        mugalim1.setLastName(mugalim.getLastName());
        mugalim1.setEmail(mugalim.getEmail());
        mugalimRepository.save(mugalim1) ;

        return "redirect:/demo/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Mugalim> mugalim = (Optional <Mugalim> ) mugalimRepository.findById(id);
        model.addAttribute("mugalimm",mugalim);
        return new ModelAndView("update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        mugalimRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all");
    }
}
