package icarus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Teste {
@RequestMapping("/mapainterativo")
	public String teste() {
		
		return "mapainterativo";
	}

@RequestMapping("/login")
public String teste01() {
	
	return "login";
}






}
	

