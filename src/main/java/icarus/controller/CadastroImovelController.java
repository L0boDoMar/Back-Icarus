package icarus.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import icarus.model.Imoveis;
import icarus.repository.ImovelRepository;

@Controller
public class CadastroImovelController {

	private static String caminhoImagens = "C:\\Users\\andre\\Documents\\imagensIcarus\\";

	@Autowired
	private ImovelRepository imovelrepository;

	// Cadastrar Imóvel
	@GetMapping("/novoimovel")
	public ModelAndView InsertImovel(Imoveis imovel) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/cadastro-imovel");
	mv.addObject("imovel", new Imoveis());
	return mv;
	}

	@PostMapping("InsertImovel")
	public ModelAndView CreateAd(Imoveis imovel, @RequestParam("file") MultipartFile file) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("redirect:/meusimoveis");
	imovelrepository.save(imovel);
		
		//método para upload de imagens no banco
		
	try {
				
				if(!file.isEmpty()) {
					byte[] bytes = file.getBytes();
					Path caminho = Paths.get(caminhoImagens+String.valueOf(imovel.getId())+ file.getOriginalFilename());
					Files.write(caminho, bytes);
					
					imovel.setPicture(String.valueOf(imovel.getId())+ file.getOriginalFilename());
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		imovelrepository.save(imovel);
		
			return mv;
		}
	

	// Lista de imóveis

	// Lista anuncios criados por um usuário na página /meusimoveis
	@GetMapping("/meusimoveis")
	public ModelAndView ImovelList() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/lista-imoveis");
	mv.addObject("imovellist", imovelrepository.findAll());
	return mv;
	}
	
	// Lista anuncios na página /listaimoveis
		@GetMapping("/listaimoveis")
		public ModelAndView ImovelList1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mapainterativo.html");
		mv.addObject("imovellist", imovelrepository.findAll());
		return mv;
		}
	
	
	//Mostrar Imagem
	
	@GetMapping("/mostrarImagem/{picture}")
	@ResponseBody
	public byte[] mostrarImagem(@PathVariable("picture") String picture) throws IOException {
		
		File mostrarImagem = new File(caminhoImagens + picture);
		
		if(picture!=null || picture.trim().length()>0) {
		
			return Files.readAllBytes(mostrarImagem.toPath());
		
		}
		
		return null;
	}
	
	

	// Exibe a dashboard de um anuncio especifico com base no id
	@RequestMapping("/dashboard/{id}")
	public ModelAndView dashboardimoveis(@PathVariable("id") Long id) {
	Imoveis dashboardimovel = imovelrepository.findByid(id);
	ModelAndView mv = new ModelAndView("dashboard-locador");
	mv.addObject("dashboardimovel", dashboardimovel);
	return mv;
	}
	
	//Exibe a folha de informações de um anuncio com base no id 
	
	@RequestMapping("/imovel-anuncio/{id}")
	public ModelAndView listagemImovel(@PathVariable("id") Long id) {
	ModelAndView mv = new ModelAndView("imovel-anuncio");
	Imoveis listagemImovel = imovelrepository.getById(id);
	mv.addObject("listagemImovel", listagemImovel);
	return mv;
	}
	

	// UPDATE e DELETE

	// Deleta um anuncio
	@RequestMapping("/deletar")
	public String deletar(Long id) {
	Imoveis dashboardimovel = imovelrepository.findByid(id);
	imovelrepository.delete(dashboardimovel);
	return "redirect:/meusimoveis";
	}

	// Editar as informações de um anúncio
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/editar-anuncio");
	Imoveis imovel = imovelrepository.getById(id);
	mv.addObject("imovel", imovel);
	return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Imoveis imovel, @RequestParam("file") MultipartFile file) {
	ModelAndView mv = new ModelAndView();
	imovelrepository.save(imovel);
		
		//método para upload de imagens no banco
		
		try {
					
					if(!file.isEmpty()) {
						byte[] bytes = file.getBytes();
						Path caminho = Paths.get(caminhoImagens+String.valueOf(imovel.getId())+ file.getOriginalFilename());
						Files.write(caminho, bytes);
						
						imovel.setPicture(String.valueOf(imovel.getId())+ file.getOriginalFilename());
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			imovelrepository.save(imovel);
		
		mv.setViewName("redirect:/meusimoveis");
		return mv;

	}

}