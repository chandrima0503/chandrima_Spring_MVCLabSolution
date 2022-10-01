package com.greatLearning.DebateRegistration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.DebateRegistration.Service.StudentsService;
import com.greatLearning.DebateRegistration.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentsService studentService;
	
	//add mapping("/list)
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("request Recieved");
		
		//get students from database
		List<Student>theStudents=studentService.findAll();
		
		//add to the spring model
		theModel.addAttribute("Students",theStudents);
		
		return "list-student";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		
		Student theStudent=new Student();
		
		theModel.addAttribute("Student",theStudent);
		 return "Student-form";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormFormForUpdate(@RequestParam("studentId") int theId,Model theModel) {
		
		//get the book service
		 Student theStudent= studentService.findById(theId);
		 
		 //set Book as a model attribute to pre-populate the form
		 theModel.addAttribute("Student",theStudent);
		 //send over to our form
		 return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,@RequestParam("name") String name
			,@RequestParam("department") String department,
			@RequestParam("country") String country){
		System.out.println(id);
		Student theStudent;
		if(id!=0) {
			theStudent=studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}else {
			theStudent=new Student(id,name,department,country);
			//save the book
			studentService.save(theStudent);
			
			//use a redirect to prevent duplicate submission
		}
			return "redirect:/student/list";
		
		
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		//delete the book
		studentService.deleteById(theId);
		
		//redirect to books/list
		return "redirect:/student/list";
		
	}
	

}
