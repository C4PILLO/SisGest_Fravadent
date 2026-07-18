package pe.com.fravadent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping({ "/", "/inicio", "/home" })
	public String inicio() {
		return "inicio";
	}
}
