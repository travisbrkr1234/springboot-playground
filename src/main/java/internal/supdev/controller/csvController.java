package internal.supdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	@RequestMapping("hello")
	public String loadHomePage(Model m) {
		m.addAttribute("message", "CIA - CSV Import Assistant");
		return "hello";
	}
}
