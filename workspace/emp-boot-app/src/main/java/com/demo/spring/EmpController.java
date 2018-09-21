package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Controller
public class EmpController {

	@Autowired
	EmpRepository repo;

	@RequestMapping("/")
	public ModelAndView getMainPage() {
		System.out.println("I am hit..");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("message", "Our Emp Application");
		return mv;
	}

	@RequestMapping("/add")
	public String getEmpForm(Model modelMap) {
		modelMap.addAttribute("emp", new Emp());
		return "addEmp";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView addEmp(@ModelAttribute("emp") Emp e) {
		ModelAndView mv = new ModelAndView();
		if (!repo.existsById(e.getEmpId())) {
			Emp e1 = repo.save(e);
			
			mv.setViewName("details");
			mv.addObject("emp", e1);
		}else {
			mv.setViewName("empExists");
		}
		return mv;

	}

	@RequestMapping(path = "/find", method = RequestMethod.GET)
	public String getFinderPage() {
		return "empform";
	}

	@RequestMapping(path = "/find", method = RequestMethod.POST)
	public ModelAndView findEmp(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			mv.setViewName("details");
			mv.addObject("emp", o.get());
		} else {
			mv.setViewName("noemp");
		}
		return mv;
	}

}
