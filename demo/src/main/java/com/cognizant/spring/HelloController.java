package com.cognizant.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class HelloController {

	@Autowired
	private StudentServiceImpl studentService;

	@RequestMapping("hello")
	public String hello() {
		System.out.println("HELLO WELCOME");
		return "hello";
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("display");
		List<Student> list = studentService.findAll();
		mv.addObject("list", list);
		return mv;
	}
	

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertPage() {
		ModelAndView mv = new ModelAndView("insert");
		Student student = new Student();
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("student") Student student) {

		ModelAndView mv = new ModelAndView("insert");

		System.out.println(student);

		int res = studentService.create(student);

		if (res > 0) {
			mv.addObject("msg", "Record Inserted");
		} else {
			mv.addObject("msg", "Record not Inserted");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("update");
		Student student = new Student();
		mv.addObject("id", id);
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") Student student) {
		System.out.println("Model Attribute:" + student);
		int res = studentService.update(student);
		ModelAndView mv = new ModelAndView("update");
		if (res==1) {
			mv.addObject("msg", "Record Updated");
		} else {
			mv.addObject("msg", "Record Not Updated");
		}
		return findAll();
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deletePage(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		int res = studentService.delete(id);
		if (res==1) {
			mv.addObject("msg", "Record Deleted");
		} else {
			mv.addObject("msg", "Record Not Deleted");
		}
		mv.setViewName("delete");
		return findAll();
}
}
