package com.greatlearning.studentManagement.controller;

import java.util.List;

import com.greatlearning.studentManagement.service.StudentService;
import com.greatlearning.studentManagement.entity.*;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		// System.out.println(students);
		return "list-students";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("action", "add");
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country,
			@RequestParam("action") String action) {
		Student student;
		if (action.equalsIgnoreCase("update")) {
			student = studentService.getStudentById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
			System.out.println(student);
			studentService.saveStudent(student);
		}
		if (action.equalsIgnoreCase("add")) {
			student = new Student(id, name, department, country);
			studentService.saveStudent(student);
		}
		return "redirect:/student/list";

	}

	@RequestMapping("/update")
	public String updateStudentById(@RequestParam("id") int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student", student);
		model.addAttribute("action", "update");
		model.addAttribute("id", id);
		return "student-form";
	}

	@RequestMapping("/delete")
	public String deleteStudentByid(@RequestParam("id") int id) {
		studentService.deleteStudentById(id);
		return "redirect:/student/list";
	}

}
