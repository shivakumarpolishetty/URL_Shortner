package springboot.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.urlshortner.model.URL;
import springboot.urlshortner.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@RequestMapping(method = RequestMethod.GET,value="/greet")
	public String welcomemepage(Model model)
	{
		String welcomemessage="past the long url for the shotter url ";
		model.addAttribute("welcome", welcomemessage);
		
		return "main";
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="/shorturl")
	public String getshorturl(@RequestParam String originalUrl, Model model)
	{
		String shorturl=mainService.databasebased(originalUrl);
		model.addAttribute("data", shorturl);
		
		return "main";
		
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST,value="/thirdparyapi")
	public String  thirdpartyapi(@RequestParam String  originalUrl, Model model)
	{   
		
	   String shorturl  = 	mainService.thirdparyapi(originalUrl);
	   model.addAttribute("data", shorturl);
		
		return "main";
		
	}
	//
	
	/*
	 * @RequestMapping(method = RequestMethod.POST,value="/database") public
	 * ResponseEntity<String> databasebased(@RequestBody String url) { String
	 * shortURL = mainService.databasebased(url); return
	 * ResponseEntity.ok(shortURL);
	 * 
	 * }
	 */

	
	 
}
