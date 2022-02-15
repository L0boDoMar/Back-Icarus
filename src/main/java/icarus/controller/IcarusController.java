package icarus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IcarusController {

	//Mapeamento das páginas que não estão em nenhum método
	
	@GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }
	
	@GetMapping("/sobrenos")
    public ModelAndView sobrenos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sobrenos");
        return mv;
    }
	
	@GetMapping("/suporte")
    public ModelAndView helpdesk() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/centraldeajuda");
        return mv;
    }
	
	
	
	
}
