package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	private final OwnerService ownerService;

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listVets(Model model) {
		model.addAttribute("owners", ownerService.findAll());

		return "owners/index";
	}

}
