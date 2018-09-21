package testtask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testtask.model.Element;
import testtask.service.ElementService;

@Controller
@RequestMapping(value="/element")
public class ElementController {
	
	@Autowired
	ElementService elementService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public ModelAndView list() {		
		ModelAndView model = new ModelAndView("element/element_page");
		
		List<Element> list = elementService.listAllElements();
		model.addObject("listElement", list);
		
		return model;		
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public ModelAndView add() {		
		ModelAndView model = new ModelAndView("element/element_form");
		
		Element element = new Element();
		model.addObject("elementForm", element);
		
		return model;		
	}

	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("element/element_form");
	  
	  Element element = elementService.findElementById(id);
	  model.addObject("userForm", element);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("elementForm") Element element){
	  if(element != null && element.getId() != null){
		  elementService.updateElement(element);
	  } else {
		  elementService.addElement(element);
	  }
	  
	  return new ModelAndView("redirect:/element/list");
	 }
	
}
