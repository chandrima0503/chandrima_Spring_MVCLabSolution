package com.greatLearning.DebateRegistration.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String redirectPage() {
		return "redirect:/student/list";
	}

}
